/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductCompare;

import DBConnector.DataBaseHandler;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class ProductCompareController implements Initializable {

    @FXML
    private Label PriceLable;
    @FXML
    private Label TypeLable;
    @FXML
    private Label ModelLable;
    @FXML
    private Label BrandLable;
    @FXML
    private JFXTextField searchBox;
    @FXML
    private Label PriceLable1;
    @FXML
    private Label TypeLable1;
    @FXML
    private Label ModelLable1;
    @FXML
    private Label BrandLable1;
    @FXML
    private JFXTextField searchBox1;

    private DataBaseHandler db;
    private ResultSet rs;

    public void setData(String Model) {
        getData(Model);
    }

    void getData(String SelectedModel) {
        db = new DataBaseHandler();

        try {
            String qu = "select *from all_product WHERE Model = '" + SelectedModel + "'";
            ResultSet rs = db.execQuery(qu);
            while (rs.next()) {
                String productName = rs.getString("Name");
                String Model = rs.getString("Model");
                String Company = rs.getString("Company");
                double price = rs.getDouble("Price");

                TypeLable.setText(productName);
                ModelLable.setText(Model);
                BrandLable.setText(Company);
                PriceLable.setText(price + "");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void searchBox(KeyEvent event) {

        String selectedModel = searchBox.getText();
        try {
            db = new DataBaseHandler();
            String query = "select *from all_product WHERE Model = '" + selectedModel + "'";
            rs = db.execQuery(query);
            while (rs.next()) {
                String productName = rs.getString("Name");
                String Model = rs.getString("Model");
                String Company = rs.getString("Company");
                double price = rs.getDouble("Price");

                TypeLable.setText(productName);
                ModelLable.setText(Model);
                BrandLable.setText(Company);
                PriceLable.setText(price + "");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void searchBox1(KeyEvent event) {
        String selectedModel = searchBox1.getText();
        try {
            db = new DataBaseHandler();
            String query = "select *from all_product WHERE Model = '" + selectedModel + "'";
            rs = db.execQuery(query);
            while (rs.next()) {
                String productName = rs.getString("Name");
                String Model = rs.getString("Model");
                String Company = rs.getString("Company");
                double price = rs.getDouble("Price");

                TypeLable1.setText(productName);
                ModelLable1.setText(Model);
                BrandLable1.setText(Company);
                PriceLable1.setText(price + "");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
