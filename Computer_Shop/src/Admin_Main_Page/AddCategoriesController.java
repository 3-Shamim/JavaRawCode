/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Main_Page;

import DB_Connector.DataBaseHandler;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class AddCategoriesController implements Initializable {

    @FXML
    private JFXListView<String> CategoriesListViews;
    @FXML
    private JFXTextField categoriesField;
    
     private DataBaseHandler db;
    private ObservableList<String> CategoriesList;

    void setCategories() {
        db = new DataBaseHandler();
        CategoriesList = FXCollections.observableArrayList();
        try {
            String qu = "select *from categories";
            ResultSet rs = db.execQuery(qu);
            while (rs.next()) {
                String categories = rs.getString("Categories");
                CategoriesList.add(categories);
            }
            CategoriesListViews.setItems(CategoriesList);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    boolean FillFieldExecption(String categories) {
        if (categories.isEmpty()) {

            return true;
        }

        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCategories();
    }    

    @FXML
    private void SaveButton(ActionEvent event) {
        String categories = categoriesField.getText();
         if (FillFieldExecption(categories)) {
            System.out.println("You must fill categories field");
        }
        else {
            db = new DataBaseHandler();
            String qu = "INSERT INTO `categories` VALUES ('" + categories + "')";
            if (db.execAction(qu)) {
                System.out.println("Insertion Successful");
                CategoriesList.add(categories);
                categoriesField.clear();
            } else {
                System.out.println("Insertion Not Successful");
            }
        }
        
    }
    
}
