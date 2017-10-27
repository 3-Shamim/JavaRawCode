/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.table.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView<ProductList> table;
    @FXML
    private TableColumn<ProductList, String> c1;
    private ObservableList list;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBconnection db = new DBconnection();
        String query = "select *from product";
        c1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        try
        {
            list = FXCollections.observableArrayList();
            db.rs = db.st.executeQuery(query);
            while(db.rs.next())
            {
                String name = db.rs.getString("ProductName");
                String type = db.rs.getString("ProductType");
                String date = db.rs.getString("Date");
                int id = db.rs.getInt("ProductID");
                int remain = db.rs.getInt("RemainingItems");
                int index = db.rs.getInt("Index");
                ProductList product = new ProductList(id,name,type,remain,date,index);
                list.add(product);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        table.setItems(list);
    }    
    
}
