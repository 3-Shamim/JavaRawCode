/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author Md Shamim
 */
public class FXMLDocumentController implements Initializable {

    double num1, num2, result;
    String oparetion, oldText, newText;
    int a = 0;

    private Label label;
    @FXML
    private TextArea textarea;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button divider;
    @FXML
    private Button multifly;
    @FXML
    private Button six;
    @FXML
    private Button five;
    @FXML
    private Button four;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button minus;
    @FXML
    private Button zero;
    @FXML
    private Button dot;
    @FXML
    private Button plus;
    @FXML
    private Button equal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void seven(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "7";
        textarea.setText(newText);
    }

    @FXML
    private void eight(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "8";
        textarea.setText(newText);
    }

    @FXML
    private void nine(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "9";
        textarea.setText(newText);
    }

    @FXML
    private void divider(ActionEvent event) {
        oldText = textarea.getText();
        num1 = Double.parseDouble(oldText);
        oparetion = "divide";
        textarea.setText("");
        a = 0;
    }

    @FXML
    private void multifly(ActionEvent event) {
        oldText = textarea.getText();
        num1 = Double.parseDouble(oldText);
        oparetion = "multiply";
        textarea.setText("");
        a = 0;
    }

    @FXML
    private void six(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "6";
        textarea.setText(newText);
    }

    @FXML
    private void five(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "5";
        textarea.setText(newText);
    }

    @FXML
    private void four(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "4";
        textarea.setText(newText);
    }

    @FXML
    private void one(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "1";
        textarea.setText(newText);
    }

    @FXML
    private void two(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "2";
        textarea.setText(newText);
    }

    @FXML
    private void three(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "3";
        textarea.setText(newText);
    }

    @FXML
    private void minus(ActionEvent event) {
        oldText = textarea.getText();
        num1 = Double.parseDouble(oldText);
        oparetion = "minus";
        textarea.setText("");
        a=0;
    }

    @FXML
    private void zero(ActionEvent event) {
        oldText = textarea.getText();
        newText = oldText + "0";
        textarea.setText(newText);
    }

    @FXML
    private void dot(ActionEvent event) {
        if (a == 0) {
            oldText = textarea.getText();
            newText = oldText + ".";
            textarea.setText(newText);
            a += 1;
        }
    }

    @FXML
    private void plus(ActionEvent event) {
        oldText = textarea.getText();
        num1 = Double.parseDouble(oldText);
        oparetion = "plus";
        textarea.setText("");
        a=0;
    }

    @FXML
    private void equal(ActionEvent event) {
        if (oparetion.equals("divide")) {
            newText = textarea.getText();
            num2 = Double.parseDouble(newText);
            result = num1 / num2;
            textarea.setText("" + result);
        }
        else if (oparetion.equals("multiply"))
        {
            newText = textarea.getText();
            num2 = Double.parseDouble(newText);
            result = num1 * num2;
            textarea.setText("" + result);
        }
        else if (oparetion.equals("plus"))
        {
            newText = textarea.getText();
            num2 = Double.parseDouble(newText);
            result = num1 + num2;
            textarea.setText("" + result);
        }
        else if (oparetion.equals("minus"))
        {
            newText = textarea.getText();
            num2 = Double.parseDouble(newText);
            result = num1 - num2;
            textarea.setText("" + result);
        }
        
    }

}
