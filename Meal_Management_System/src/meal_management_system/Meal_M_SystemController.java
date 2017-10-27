/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meal_management_system;

import DB_Handler.DBconnector;
import MealDetails.Meal_DetailsController;
import Simple_Class.Meal;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MD SHAMIM
 */
public class Meal_M_SystemController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXDrawer Drawer;
    @FXML
    private JFXHamburger Hamburger;
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
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField ronyField;
    @FXML
    private JFXTextField shotonField;
    @FXML
    private JFXTextField shuvoField;
    @FXML
    private JFXTextField mijanField;
    @FXML
    private Label totalMeal;

    private HamburgerBackArrowBasicTransition transition1;
    private VBox box;

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
        if (ronyField.getText().isEmpty()
                || shotonField.getText().isEmpty()
                || shuvoField.getText().isEmpty()
                || mijanField.getText().isEmpty()
                || datePicker.getValue() == null) {
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

    void getDetials() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MealDetails/Meal_Details.fxml"));

        Parent parent = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        
        Image img = new Image(getClass().getResourceAsStream("/Image/5.png"));
        stage.getIcons().add(img);
        
        stage.setScene(scene);
        ((Meal_DetailsController) fxmlLoader.getController()).getMealDetails(totalAmountRony, totalAmountShoton, totalAmountShuvo, totalAmountMijan, totalMealc);
        stage.show();
    }

    void getCostList() throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/CostLists/CostList.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        
        Image img =  new Image(getClass().getResourceAsStream("/Image/list-flat.png"));
        stage.getIcons().add(img);
        
        stage.setScene(scene);
        stage.show();
    }
    void getAbout() throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/About/About.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        
        Image img =  new Image(getClass().getResourceAsStream("/Image/info-xxl.png"));
        stage.getIcons().add(img);
        
        stage.setScene(scene);
        stage.show();
    }

    void ResetDB() {

        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Reset Database");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your 'reset-DB' and press 'Ok' to reset Database");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if (result.get().equals("reset-DB")) {
                db = new DBconnector();
                String qu = "TRUNCATE meal";
                String qu1 = "TRUNCATE shopping";
                if (db.execAction(qu) && db.execAction(qu1)) {
                    mealList.clear();
                    totalMeal.setText("");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notificition");
                    alert.setHeaderText("Successfully Reset !");
                    alert.setContentText("Your Table successfully Reset From your DataBase");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Notificition");
                    alert.setHeaderText("Not Reset");
                    alert.setContentText("Your Table Is Not Reset");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Notificition");
                alert.setHeaderText("Fill Text Field Following Instruction !");
                alert.setContentText("Your Table Is Not Reset From your DataBase");
                alert.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            box = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
            transition1 = new HamburgerBackArrowBasicTransition(Hamburger);
            transition1.setRate(-1);
            Drawer.setSidePane(box);
            Drawer.setVisible(false);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        for (Node node : box.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "CostList": {
                            try {
                                getCostList();
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                        break;
                        case "Details": {
                            try {
                                getDetials();
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                        break;
                        case "resetDB":
                            ResetDB();
                            break;
                        case "About":
                            try {
                                getAbout();
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            break;
                        case "Exit":
                            System.exit(0);
                    }
                });
            }
        }

        getData();
        setCol();
        totalMeal.setText(totalMealc + "");
    }

    @FXML
    private void HamburgerClickAction(MouseEvent event) {

        transition1.setRate(transition1.getRate() * -1);
        transition1.play();
        if (Drawer.isShown()) {
            Drawer.close();
            Drawer.setVisible(false);
        } else {
            Drawer.setVisible(true);
            Drawer.open();
        }
    }

    @FXML
    private void submitButton(ActionEvent event) {
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
                totalMeal.setText(totalMealc + "");

                ronyField.clear();
                shotonField.clear();
                shuvoField.clear();
                mijanField.clear();

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
