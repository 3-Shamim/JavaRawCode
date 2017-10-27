/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TreeView<ProductList> treeView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ProductList helper = new ProductList();
        
        ArrayList<TreeItem> products = helper.getProducts();

        
        TreeItem rootItem = new TreeItem("Vehicles");
     
        rootItem.getChildren().addAll(products);
       
        treeView.setRoot(rootItem);
    }

}
