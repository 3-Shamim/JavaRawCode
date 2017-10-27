/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageAmount;

import DB_Handler.DBconnector;
import Simple_Class.Shoping;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class ManageAmountController implements Initializable {

    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXComboBox<String> personField;
    @FXML
    private JFXTextField amountField;
    @FXML
    private TableView<Shoping> tableView;
    @FXML
    private TableColumn<Shoping, String> dateCol;
    @FXML
    private TableColumn<Shoping, Number> amountCol;
    @FXML
    private TableColumn<Shoping, String> personCol;
    @FXML
    private Label shotonAmount;
    @FXML
    private Label shuvoAmount;
    @FXML
    private Label mijanAmount;
    @FXML
    private Label souravAmount;
    @FXML
    private Label totalAmountField;

    private DBconnector db;
    private ResultSet rs;
    private ObservableList<Shoping> shopingList;
    private double totalAmount = 0.0;

    private ObservableList comboList;

    private double souravAmounts = 0.0;
    private double shotonAmounts = 0.0;
    private double shuvoAmounts = 0.0;
    private double mijanAmounts = 0.0;

    private void setComboBox() {
        comboList = FXCollections.observableArrayList();
        comboList.add("sourav");
        comboList.add("shoton");
        comboList.add("shuvo");
        comboList.add("mijan");
        personField.setItems(comboList);
    }

    private void souravAmount() {
        String sourav = "sourav";
        try {
            db = new DBconnector();
            String qu = "SELECT * FROM `shopping` WHERE `person` = '" + sourav + "'";
            rs = db.execQuery(qu);
            while (rs.next()) {
                double amount = rs.getDouble("amount");

                souravAmounts += amount;
            }
            souravAmount.setText(souravAmounts + "");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void shotonAmount() {
        String sourav = "shoton";
        try {
            db = new DBconnector();
            String qu = "SELECT * FROM `shopping` WHERE `person` = '" + sourav + "'";
            rs = db.execQuery(qu);
            while (rs.next()) {
                double amount = rs.getDouble("amount");

                shotonAmounts += amount;
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void shuvoAmount() {
        String sourav = "shuvo";
        try {
            db = new DBconnector();
            String qu = "SELECT * FROM `shopping` WHERE `person` = '" + sourav + "'";
            rs = db.execQuery(qu);
            while (rs.next()) {
                double amount = rs.getDouble("amount");

                shuvoAmounts += amount;
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void mijanAmount() {
        String sourav = "mijan";
        try {
            db = new DBconnector();
            String qu = "SELECT * FROM `shopping` WHERE `person` = '" + sourav + "'";
            rs = db.execQuery(qu);
            while (rs.next()) {
                double amount = rs.getDouble("amount");

                mijanAmounts += amount;
            }
          
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void setCol() {
        dateCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate()));
        amountCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAmount()));
        personCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
    }

    private boolean checkField() {
        String date = "" + datePicker.getValue();
        if (personField.getSelectionModel().getSelectedItem().isEmpty()
                || amountField.getText().isEmpty()
                || date.isEmpty()) {
            return false;
        }
        return true;
    }

    private void getData() {
        shopingList = FXCollections.observableArrayList();
        try {
            db = new DBconnector();
            String qu = "select *from shopping";
            rs = db.execQuery(qu);
            while (rs.next()) {
                String date = rs.getString("date");
                double amount = rs.getDouble("amount");
                String person = rs.getString("person");

                Shoping shoping = new Shoping(date, amount, person);
                shopingList.add(shoping);

                totalAmount += amount;

            }
            tableView.setItems(shopingList);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void setQuentity() {
        totalAmountField.setText(totalAmount + "");
        shuvoAmount.setText(shuvoAmounts + "");
        shotonAmount.setText(shotonAmounts + "");
        shuvoAmount.setText(shuvoAmounts + "");
          mijanAmount.setText(mijanAmounts + "");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getData();
        setCol();
        setComboBox();
        souravAmount();
        shotonAmount();
        shuvoAmount();
        mijanAmount();
        setQuentity();
    }

    @FXML
    private void submitAction(ActionEvent event) {

        if (checkField()) {
            LocalDate date = datePicker.getValue();
            String Date = date + "";
            double amount = Double.parseDouble(amountField.getText());
            String person = personField.getSelectionModel().getSelectedItem();
            
            if(person.equals("sourav"))
            {
                souravAmounts += amount; 
            }
            else if(person.equals("shoton"))
            {
                shotonAmounts += amount; 
            }
            else if(person.equals("shuvo"))
            {
                shuvoAmounts += amount; 
            }
            else if(person.equals("mijan"))
            {
                mijanAmounts += amount;
            }
            
            db = new DBconnector();
            String qu = "insert into shopping values('" + Date + "','" + amount + "','" + person + "')";
            if (db.execAction(qu)) {

                Shoping shoping = new Shoping(Date, amount, person);
                shopingList.add(shoping);
                
//                souravAmounts = 0.0; shotonAmounts = 0.0; shuvoAmounts = 0.0; mijanAmounts = 0.0;
//                
//                souravAmount();
//                shotonAmount();
//                shuvoAmount();
//                mijanAmount();
                
                totalAmount += amount;
                setQuentity();

                amountField.clear();
                personField.getSelectionModel().clearSelection();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Notificition");
                alert.setHeaderText("Successfully Inserted !");
                alert.setContentText("Your data successfully inserted in your DataBase..");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Notificition");
                alert.setHeaderText("Not Inserted !");
                alert.setContentText("Your data is not inserted in your DataBase..");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Notificition");
            alert.setHeaderText("You must fill all the field !");
            alert.setContentText("Fillup all field..");
            alert.showAndWait();
        }

    }

}
