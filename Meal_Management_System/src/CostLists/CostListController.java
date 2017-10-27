/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostLists;

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
public class CostListController implements Initializable {

    @FXML
    private TableView<Shoping> tableView;
    @FXML
    private TableColumn<Shoping, String> dateCol;
    @FXML
    private TableColumn<Shoping, Number> amountCol;
    @FXML
    private TableColumn<Shoping, String> personCol;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField amountField;
    @FXML
    private JFXComboBox<String> personCombo;
    @FXML
    private Label totalAmountField;
    
    private DBconnector db;
    private ResultSet rs;
    private ObservableList<Shoping> shopingList;
    private double totalAmount = 0.0;

    private ObservableList comboList;

    private void setComboBox() {
        comboList = FXCollections.observableArrayList();
        comboList.add("Rony");
        comboList.add("Shoton");
        comboList.add("Shuvo");
        comboList.add("Mijan");
        personCombo.setItems(comboList);
    }

    private void setCol() {
        dateCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate()));
        amountCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAmount()));
        personCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
    }

    private boolean checkField() {
        if (personCombo.getSelectionModel().getSelectedItem() == null
                || amountField.getText().isEmpty()
                || datePicker.getValue() == null) {
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getData();
        setCol();
        setComboBox();
        totalAmountField.setText(totalAmount + "");
    }    

    @FXML
    private void SubmitButton(ActionEvent event) {
        if (checkField()) {
            LocalDate date = datePicker.getValue();
            String Date = date + "";
            double amount = Double.parseDouble(amountField.getText());
            String person = personCombo.getSelectionModel().getSelectedItem().toLowerCase();

            db = new DBconnector();
            String qu = "insert into shopping values('" + Date + "','" + amount + "','" + person + "')";
            if (db.execAction(qu)) {

                Shoping shoping = new Shoping(Date, amount, person);
                shopingList.add(shoping);

                totalAmount += amount;
                totalAmountField.setText(totalAmount + "");
                
                amountField.clear();
                personCombo.getSelectionModel().clearSelection();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Notificition");
                alert.setHeaderText("Successfully Inserted !");
                alert.setContentText("Your data successfully inserted in your DataBase");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Notificition");
                alert.setHeaderText("Not Inserted !");
                alert.setContentText("Your data is not inserted in your DataBase");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Notificition");
            alert.setHeaderText("You must fill all the field !");
            alert.setContentText("Fillup all field");
            alert.showAndWait();
        }
    }
    
}
