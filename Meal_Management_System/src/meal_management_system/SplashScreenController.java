/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meal_management_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class SplashScreenController implements Initializable {

    @FXML
    private AnchorPane SplashScreen;

    class SplashScreen extends Thread {

        public void run() {
            try {
                Thread.sleep(4000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("Meal_M_System.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            Image img = new Image(getClass().getResourceAsStream("/Image/1.png"));
                            stage.getIcons().add(img);
                            stage.setScene(scene);
                            stage.setTitle("Meal Management System");
                            stage.show();
                            SplashScreen.getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplashScreen().start();
    }

}
