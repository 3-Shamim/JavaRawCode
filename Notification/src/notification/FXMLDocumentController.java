/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.notification.TrayNotification;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Button button1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    class getNotifications extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Image img = new Image(getClass().getResourceAsStream("/img/success-icon-19.png"));
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            Notifications n = Notifications.create()
                    .title("Notification")
                    .text("Success")
                    .graphic(imageView)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Clicked on nodifications");
                    });
            n.darkStyle();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    n.show();
                }
            });

        }
    }

    @FXML
    private void ControllerFXNotifications(ActionEvent event) {
        new getNotifications().start();
    }

    @FXML
    private void trayNotifications(ActionEvent event) {
        Image img = new Image(getClass().getResourceAsStream("/img/success-icon-19.png"));
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Notifications n = Notifications.create()
                .title("Notification")
                .text("Success")
                .graphic(imageView)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT)
                .onAction((ActionEvent event1) -> {
                    System.out.println("Clicked on nodifications");
                });
        n.darkStyle();
        n.show();
    }

}
