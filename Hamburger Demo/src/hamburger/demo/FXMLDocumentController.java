/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamburger.demo;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javax.management.Notification;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;

    private HamburgerBackArrowBasicTransition transition1;
    private VBox box;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        drawer.setVisible(false);
        AnchorPane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        
        try {
            box = FXMLLoader.load(getClass().getResource("SliderMenu.fxml"));

            transition1 = new HamburgerBackArrowBasicTransition(hamburger);
            transition1.setRate(-1);
            drawer.setSidePane(box);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    class takeTime extends Thread
    {
        @Override
        public void run()
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    drawer.setVisible(false);
                }
            });
        }
    }

    @FXML
    private void HamburgerAction(MouseEvent event) {

        for (Node node : box.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "Button_one":
                            AnchorPane.setBackground(new Background(new BackgroundFill
                            (Paint.valueOf("#fff000"), CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case "Button_two":
                            AnchorPane.setBackground(new Background(new BackgroundFill
                            (Paint.valueOf("#ff0000"), CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case "Button_three":
                            AnchorPane.setBackground(new Background(new BackgroundFill
                            (Paint.valueOf("#3358ff"), CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case "Button_four":
                            AnchorPane.setBackground(new Background(new BackgroundFill
                            (Paint.valueOf("#e933ff"), CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case "Button_exit":
                            System.exit(0);
                    }
                });
            }
        }

        transition1.setRate(transition1.getRate() * -1);
        transition1.play();
        if (drawer.isShown()) {
//            new takeTime().start();
            drawer.close();  
        } else {
            drawer.setVisible(true);
            drawer.open();
        }
    }

}
