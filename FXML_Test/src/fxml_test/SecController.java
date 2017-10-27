/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class SecController implements Initializable {
    
    @FXML
    private Label TextLabel;
    private String Text;

    public void setData(String text)
    {
        TextLabel.setText(text);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Text);
    }    
    
}
