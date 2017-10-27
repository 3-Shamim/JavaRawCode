/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class SplashController implements Initializable {

    @FXML
    private AnchorPane splashScreen;

    class SpalshScreen extends Thread {

        public void run() {
            try {
                Thread.sleep(5000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Parent parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                            
                            Scene scene = new Scene(parent);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();
                            splashScreen.getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            } catch (InterruptedException ex) {
                Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SpalshScreen().start();
    }

}
