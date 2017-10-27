/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateAccount_Page;

import DBConnector.DataBaseHandler;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class CreateAccount_PageController implements Initializable {

    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXTextField fullNameField;
    @FXML
    private JFXTextField emailField;
    @FXML
    private JFXRadioButton FemaleRadioButton;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private JFXRadioButton MaleRadioButton;
    @FXML
    private JFXTextField numberField;
    @FXML
    private JFXPasswordField passwordField;

    private ResultSet rs;

    private String gender = "Male";
    private int checkUserName = 0;
    private DataBaseHandler db;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    /**
     * boolean FindNumberFieldException(String Number) { if (Number.length() !=
     * 11) { return true; }
     *
     * if (Number.startsWith("017") || Number.startsWith("019") ||
     * Number.startsWith("011") || Number.startsWith("016") ||
     * Number.startsWith("018") || Number.startsWith("015")); else { return
     * true; } return false; }
     *
     * boolean FindFullNameFieldExection(String fullName) { for (int i = 0; i <
     * fullName.length(); i++) { if
     * (!Character.isAlphabetic(fullName.charAt(i))) { return true; } } return
     * false; } boolean FinduserNameFieldExection(String userName) { int
     * alphabets = 0; for (int i = 0; i < userName.length(); i++) { if
     * ((Character.isAlphabetic(userName.charAt(i)))) { alphabets += 1; } } if
     * (alphabets == 0) { return true; } for (int i = 0; i < userName.length();
     * i++) { if (!(Character.isAlphabetic(userName.charAt(i)) ||
     * Character.isDigit(userName.charAt(i)) || userName.charAt(i) == '_' ||
     * userName.charAt(i) == '-')) {
     *
     * return true; } } return false; }
     */
    boolean FillFieldExecption(String userName, String fullName, String Email, String Password, String Number) {
        if (userName.isEmpty()
                || fullName.isEmpty()
                || Email.isEmpty()
                || Password.isEmpty()
                || Number.isEmpty()) {

            return true;
        }

        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void CreateAccountButton(ActionEvent event) throws Exception {

        String userName = usernameField.getText();
        String fullName = fullNameField.getText();
        String Email = emailField.getText();
        String Password = passwordField.getText();
        String Number = numberField.getText();

        if (FillFieldExecption(userName, fullName, Email, Password, Number)) {
            System.out.println("You must fill all of field");
        } else if (checkUserName == 1) {
            errorLabel.setText("UserName already exist.");
        } else {
            db = new DataBaseHandler();
            String qu = "INSERT INTO `customeruser` VALUES ('" + userName + "','" + fullName + "','" + Number + "','" + Email + "','" + Password + "','" + gender + "')";
            if (db.execAction(qu)) {
                usernameField.clear();
                fullNameField.clear();
                emailField.clear();
                passwordField.clear();
                numberField.clear();
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    Parent parent = FXMLLoader.load(getClass().getResource("/Main_Log_in_page/Main_log_in_Page.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    // ... user chose CANCEL or closed the dialog
                }

            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Somting Wrong !!");
                alert.setContentText("Try again.");
                alert.showAndWait();
            }
        }

    }

    @FXML
    private void BackButton(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/Main_Log_in_page/Main_log_in_Page.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void genderRadioButton(ActionEvent event) {
        if (FemaleRadioButton.isSelected()) {
            gender = "Female";
        }
        if (MaleRadioButton.isSelected()) {
            gender = "Male";
        }

    }

    @FXML
    private void userNameKeyPress(KeyEvent event) {
        String userName = usernameField.getText().toLowerCase();
        String dbuserName = "";
        try {
            db = new DataBaseHandler();
            String query = "select *from customeruser";
            rs = db.execQuery(query);
            while (rs.next()) {
                dbuserName = rs.getString("userName").toLowerCase();
            }

            if (userName.equals(dbuserName)) {
                errorLabel.setText("UserName already exist.");
                checkUserName = 1;
            } else {
                errorLabel.setText("");
                checkUserName = 0;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
