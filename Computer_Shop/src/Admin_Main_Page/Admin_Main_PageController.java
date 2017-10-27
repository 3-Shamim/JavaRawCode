/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Main_Page;

import DB_Connector.DataBaseHandler;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class Admin_Main_PageController implements Initializable {

    @FXML
    private JFXComboBox<String> pNameField;
    @FXML
    private JFXTextField pModelField;
    @FXML
    private JFXTextField cNameField;
    @FXML
    private JFXTextField priceField;
    @FXML
    private JFXTextField remainField;

    private DataBaseHandler db;
    private ObservableList CategoriesList;

    boolean FillFieldExecption(String ModelName, String Brand, String price, String remain) {
        if (ModelName.isEmpty()
                || Brand.isEmpty()
                || price.isEmpty()
                || remain.isEmpty()) {

            return true;
        }

        return false;
    }

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
            pNameField.setItems(CategoriesList);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCategories();
    }

    @FXML
    private void LogOutButton(ActionEvent event) throws Exception {

        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin_Page_Login/Admin_Page.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Login Computer Shop");
        stage.show();
    }

    @FXML
    private void ProductList(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/Product_view/Product_view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Product List");
        stage.show();
    }

    @FXML
    private void CustomerDetails(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/CustomerList/CustomerDetails.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Customer List");
        stage.show();
    }

    @FXML
    private void SubmitButton(ActionEvent event) {
        String pName = pNameField.getSelectionModel().getSelectedItem();
        String mName = pModelField.getText();
        String cName = cNameField.getText();
        String price = priceField.getText();
        String remain = remainField.getText();

        if (FillFieldExecption(mName, cName, price, remain)) {
            System.out.println("You must fill all of field");
        } else {
            db = new DataBaseHandler();
            String qu = "INSERT INTO `all_product` VALUES ('" + pName + "','" + mName + "','" + cName + "','" + price + "','" + remain + "')";
            if (db.execAction(qu)) {
                System.out.println("Insertion Successful");
                pNameField.getSelectionModel().clearSelection();
                pModelField.clear();
                cNameField.clear();
                priceField.clear();
                remainField.clear();

            } else {
                System.out.println("Insertion Not Successful");
            }
        }
    }

    @FXML
    private void ClearButton(ActionEvent event) {
        pNameField.getSelectionModel().clearSelection();
        pModelField.clear();
        cNameField.clear();
        priceField.clear();
        remainField.clear();
    }

    @FXML
    private void AddNewCategories(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("AddCategories.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Add Categories");
        stage.show();
    }

}
