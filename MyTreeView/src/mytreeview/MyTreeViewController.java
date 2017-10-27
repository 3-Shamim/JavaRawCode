/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytreeview;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

/**
 *
 * @author MD SHAMIM
 */
public class MyTreeViewController implements Initializable {
    
    @FXML
    private TreeView<TreeList> treeView;
    
    private ObservableList<TreeItem> treeLists;
    @FXML
    private TreeTableView<Product> tableView;
    @FXML
    private TreeTableColumn<Product, String> nameCol;
    @FXML
    private TreeTableColumn<Product, Number> idCol;
    private ObservableList<TreeItem> stList;
    private ObservableList<TreeItem> treeItemList;
    private Product product;
    
     private ObservableList getData() {

        DB db = new DB();
        stList = FXCollections.observableArrayList();
        try {
            String qu = "select *from all_product";
            ResultSet rs = db.execQuery(qu);
            while (rs.next()) {
                String productName = rs.getString("Name");
                String Model = rs.getString("Model");
                String Company = rs.getString("Company");
                double price = rs.getDouble("Price");
                int remain = rs.getInt("Remaining");
                product = new Product(productName,remain);
                TreeItem<Product> item = new TreeItem(product);
                
                stList.add(item);
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return stList;
    }
     
     private void setTable()
     {
//         treeItemList = FXCollections.observableArrayList();
//         treeItemList.addAll(getData());
         
         
         TreeItem root = new TreeItem();
         
         nameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Product, String> param) -> param.getValue().getValue().getProductName());
         
         idCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Product, Number> param) -> param.getValue().getValue().getRemainting());
         
         root.getChildren().addAll(getData());
         
         tableView.setRoot(root);
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        setTable();
        
        TreeList treeList = new TreeList();
        
        TreeItem root = new TreeItem("Vehicles");
        root.getChildren().addAll(treeList.getProducts());
        
        treeView.setRoot(root);
        
    }    
    
}
