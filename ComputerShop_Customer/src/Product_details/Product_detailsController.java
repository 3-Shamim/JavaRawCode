/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product_details;

import DBConnector.DataBaseHandler;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class Product_detailsController implements Initializable {

    @FXML
    private Label TypeLable;
    @FXML
    private Label ModelLable;
    @FXML
    private Label BrandLable;
    @FXML
    private Label PriceLable;
    @FXML
    private Label StockLabel;
    @FXML
    private Button CloseButton;

    private DataBaseHandler db;
    

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
                int remain = rs.getInt("Remaining");

                TypeLable.setText(productName);
                ModelLable.setText(Model);
                BrandLable.setText(Company);
                PriceLable.setText(price + "");
                StockLabel.setText(remain + "");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setData(String model) {
        getData(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void CloseButton(ActionEvent event) {

    }

}
