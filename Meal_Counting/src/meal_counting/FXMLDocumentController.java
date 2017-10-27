/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meal_counting;

import DB_Handler.DBconnector;
import Simple_Class.Meal;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Saurav
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField ronyField;
    @FXML
    private JFXTextField shotonField;
    @FXML
    private JFXTextField mijanField;
    @FXML
    private JFXTextField shuvoField;
    @FXML
    private JFXTextField totalRony;
    @FXML
    private JFXTextField totalShoton;
    @FXML
    private JFXTextField totalShuvo;
    @FXML
    private JFXTextField totalMijan;
    @FXML
    private TableView<Meal> tableView;
    @FXML
    private TableColumn<Meal, String> dateCol;
    @FXML
    private TableColumn<Meal, Number> ronyCol;
    @FXML
    private TableColumn<Meal, Number> shotonCol;
    @FXML
    private TableColumn<Meal, Number> shuvoCol;
    @FXML
    private TableColumn<Meal, Number> mijanCol;
    @FXML
    private Label totalMeal;

    private DBconnector db;
    private ResultSet rs;
    private ObservableList<Meal> mealList;
    private double totalAmountRony = 0.0;
    private double totalAmountShoton = 0.0;
    private double totalAmountShuvo = 0.0;
    private double totalAmountMijan = 0.0;
    
    private double totalMealc = 0.0;

    private void setCol() {
        dateCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate()));
        ronyCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getRony()));
        shotonCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getShoton()));
        shuvoCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getShuvo()));
        mijanCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getMijan()));
    }

    private boolean checkField() {
        String date = "" + datePicker.getValue();
        if (ronyField.getText().isEmpty()
                || shotonField.getText().isEmpty()
                || shuvoField.getText().isEmpty()
                || mijanField.getText().isEmpty()
                || date.isEmpty()) {
            return false;
        }
        return true;
    }

    private void getData() {
        mealList = FXCollections.observableArrayList();
        try {
            db = new DBconnector();
            String qu = "select *from meal";
            rs = db.execQuery(qu);
            while (rs.next()) {
                String date = rs.getString("Date");
                double rony = rs.getDouble("Rony");
                double shoton = rs.getDouble("Shoton");
                double shuvo = rs.getDouble("Shuvo");
                double mijan = rs.getDouble("Mijan");

                Meal meal = new Meal(date, rony, shoton, shuvo, mijan);
                mealList.add(meal);

                totalAmountRony += rony;
                totalAmountShoton += shoton;
                totalAmountShuvo += shuvo;
                totalAmountMijan += mijan;

            }
            totalMealc = totalAmountRony + totalAmountShoton + totalAmountShuvo + totalAmountMijan;
            tableView.setItems(mealList);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void setQuentity() {
        totalRony.setText(totalAmountRony + "");
        totalShoton.setText(totalAmountShoton + "");
        totalShuvo.setText(totalAmountShuvo + "");
        totalMijan.setText(totalAmountMijan + "");
        totalMeal.setText(totalMealc + "");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getData();
        setCol();
        setQuentity();
    }

    @FXML
    private void submitAction(ActionEvent event) {
        if (checkField()) {
            LocalDate date = datePicker.getValue();
            String Date = date + "";
            double rony = Double.parseDouble(ronyField.getText());
            double shoton = Double.parseDouble(shotonField.getText());
            double shuvo = Double.parseDouble(shuvoField.getText());
            double mijan = Double.parseDouble(mijanField.getText());

            db = new DBconnector();
            String qu = "insert into meal values('" + Date + "','" + rony + "','" + shoton + "','" + shuvo + "','" + mijan + "')";
            if (db.execAction(qu)) {

                Meal meal = new Meal(Date, rony, shoton, shuvo, mijan);
                mealList.add(meal);

                totalAmountRony += rony;
                totalAmountShoton += shoton;
                totalAmountShuvo += shuvo;
                totalAmountMijan += mijan;
                totalMealc = totalAmountRony + totalAmountShoton + totalAmountShuvo + totalAmountMijan;
                
                setQuentity();
                
                
                ronyField.clear();
                shotonField.clear();
                shuvoField.clear();
                mijanField.clear();

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

    @FXML
    private void shopingListAction(ActionEvent event) throws Exception {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/ManageAmount/ManageAmount.fxml"));
        Parent parent = fxml.load();
        
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
