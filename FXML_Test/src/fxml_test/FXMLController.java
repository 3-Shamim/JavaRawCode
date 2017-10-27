/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_test;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class FXMLController implements Initializable {

    @FXML
    private ToggleGroup Gender;
    @FXML
    private JFXRadioButton radioMaleButton;
    @FXML
    private JFXRadioButton radioFemaleButton;
    
    private String gender;
    @FXML
    private JFXTextField textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Click(ActionEvent event) throws Exception {
        String text = textField.getText();
        System.out.println(text);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sec.fxml"));

        Parent parent = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        ((SecController)fxmlLoader.getController()).setData(text);
        stage.show();
    }

    @FXML
    private void genderRadioButton(ActionEvent event) {
        if(radioMaleButton.isSelected())
        {
            gender = radioMaleButton.getText();
        }
        if(radioFemaleButton.isSelected())
        {
            gender = radioFemaleButton.getText();
        }
        System.out.println(gender);
    }
    
}
