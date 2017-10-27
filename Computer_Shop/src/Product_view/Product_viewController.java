/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product_view;

import DB_Connector.DataBaseHandler;
import Product.Product;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class Product_viewController implements Initializable {

    @FXML
    private TableView<Product> ProductTableView;
    @FXML
    private TableColumn<Product, String> ProductName;
    @FXML
    private TableColumn<Product, String> ProductModel;
    @FXML
    private TableColumn<Product, String> ProductCompany;
    @FXML
    private TableColumn<Product, Number> ProductPrice;
    @FXML
    private TableColumn<Product, Number> ProductRemaining;
    
    private DataBaseHandler db;
    private Product product;
    private ObservableList<Product> ProductList;
    @FXML
    private JFXButton closeButton;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    void getData()
    {
        db = new DataBaseHandler();
        ProductList = FXCollections.observableArrayList();
        try
        {
            String qu = "select *from all_product";
            ResultSet rs = db.execQuery(qu);
            while(rs.next())
            {
                String productName = rs.getString("Name");
                String Model = rs.getString("Model");
                String Company = rs.getString("Company");
                double price = rs.getDouble("Price");
                int remain = rs.getInt("Remaining");
                product = new Product(productName, Model, Company, price, remain);
                ProductList.add(product);
                ProductTableView.setItems(ProductList);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    void IntializeColumn()
    {
        ProductName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProductName()));
        ProductModel.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getModel()));
        ProductCompany.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCompany()));
        ProductPrice.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        ProductRemaining.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getRemainting()));
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getData();
        IntializeColumn();
        
    }    

    @FXML
    private void CloseButton(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
}
