/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Page_Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class Admin_PageController implements Initializable {

    @FXML
    private JFXTextField AdminPassField;
    @FXML
    private JFXPasswordField AdminLogField;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AdminLoginButton(ActionEvent event) throws Exception {
        String user = AdminPassField.getText();
        String pass = AdminLogField.getText();

        if (user.equals("shamim") && pass.equals("shamim")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/Admin_Main_Page/Admin_Main_Page.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Computer Shop Admin Panel");
            stage.show();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Login Error!");
            alert.setContentText("Username and Password doesn't match");
            alert.showAndWait();
        }
    }

}
