/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Log_in_page;

import DBConnector.DataBaseHandler;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
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
public class Main_log_in_PageController implements Initializable {

    @FXML
    private JFXTextField LoginTextField;
    @FXML
    private JFXPasswordField LoginPassField;

    private DataBaseHandler db;
    private ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void LoginButton(ActionEvent event) throws Exception {

        String userName = LoginTextField.getText();
        String UserPass = LoginPassField.getText();
        String Pass = "";
        String User = "";
        if (!(userName.isEmpty() && UserPass.isEmpty())) {
            try {
                db = new DataBaseHandler();
                String query = "select *from customeruser WHERE UserName = '" + userName + "'";
                rs = db.execQuery(query);
                while (rs.next()) {
                    Pass = rs.getString("Password");
                    User = rs.getString("UserName");
                }
                if (UserPass.equals(Pass) && userName.equals(User)) {
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    Parent parent = FXMLLoader.load(getClass().getResource("/Loged_in_Customer_Page/Loged_in.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Login Error!");
                    alert.setContentText("Username and Password doesn't match");
                    alert.showAndWait();
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("DataBase Connection Error!");
            alert.setContentText("Username and Password doesn't match");
            alert.showAndWait();
        }

    }

    @FXML
    private void BackFromLogIn(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/computershop_customer/Custom_Main.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void CreateAccountButton(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/CreateAccount_Page/CreateAccount_Page.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
