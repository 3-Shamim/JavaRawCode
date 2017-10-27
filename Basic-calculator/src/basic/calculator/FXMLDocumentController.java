/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Md Shamim
 */
public class FXMLDocumentController implements Initializable {

    String newtext, oldtext, operation, ans;
    double num1, num2, result = 0.0;
    int a = 0, len, nlen;

    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button four;
    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button five;
    @FXML
    private Button two;
    @FXML
    private Button dot;
    @FXML
    private Button nine;
    @FXML
    private Button six;
    @FXML
    private Button three;
    @FXML
    private Button plus;
    @FXML
    private Button divider;
    @FXML
    private Button multiply;
    @FXML
    private Button minus;
    @FXML
    private Button equal;
    @FXML
    private TextField display;
    @FXML
    private Button AC;
    @FXML
    private Button C;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void button(ActionEvent event) {
        if (event.getSource() == one) {
            oldtext = display.getText();
            newtext = oldtext + "1";
            display.setText(newtext);
        } else if (event.getSource() == two) {
            oldtext = display.getText();
            newtext = oldtext + "2";
            display.setText(newtext);
        } else if (event.getSource() == three) {
            oldtext = display.getText();
            newtext = oldtext + "3";
            display.setText(newtext);
        } else if (event.getSource() == four) {
            oldtext = display.getText();
            newtext = oldtext + "4";
            display.setText(newtext);
        } else if (event.getSource() == five) {
            oldtext = display.getText();
            newtext = oldtext + "5";
            display.setText(newtext);
        } else if (event.getSource() == six) {
            oldtext = display.getText();
            newtext = oldtext + "6";
            display.setText(newtext);
        } else if (event.getSource() == seven) {
            oldtext = display.getText();
            newtext = oldtext + "7";
            display.setText(newtext);
        } else if (event.getSource() == eight) {
            oldtext = display.getText();
            newtext = oldtext + "8";
            display.setText(newtext);
        } else if (event.getSource() == nine) {
            oldtext = display.getText();
            newtext = oldtext + "9";
            display.setText(newtext);
        } else if (event.getSource() == zero) {
            oldtext = display.getText();
            newtext = oldtext + "0";
            display.setText(newtext);
        } else if (event.getSource() == dot) {
            if (a == 0) {
                oldtext = display.getText();
                newtext = oldtext + ".";
                display.setText(newtext);
                a += 1;
            }
        } else if (event.getSource() == plus) {
            oldtext = display.getText();
            if (oldtext.length() > 0) {
                num1 = Double.parseDouble(oldtext);
                display.setText("");
                operation = "plus";
                a = 0;
            }

        } else if (event.getSource() == minus) {
            oldtext = display.getText();
            if (oldtext.length() > 0) {
                num1 = Double.parseDouble(oldtext);
                display.setText("");
                operation = "minus";
                a = 0;
            }
        } else if (event.getSource() == multiply) {
            oldtext = display.getText();
            if (oldtext.length() > 0) {
                num1 = Double.parseDouble(oldtext);
                display.setText("");
                operation = "multiply";
                a = 0;
            }
        } else if (event.getSource() == divider) {
            oldtext = display.getText();
            if (oldtext.length() > 0) {
                num1 = Double.parseDouble(oldtext);
                display.setText("");
                operation = "divider";
                a = 0;
            }
        } else if (event.getSource() == AC) {
            display.setText("");
            a = 0;
        } else if (event.getSource() == C) {
            len = display.getText().length();
            nlen = len - 1;
            if (nlen >= 0) {
                newtext = display.getText().substring(0, nlen);
                display.setText(newtext);
                for (int i = 0; i < newtext.length(); i++) {
                    char p;
                    p = newtext.charAt(i);
                    if (p != '.') {
                        a = 0;
                    } else {
                        a = 1;
                    }
                }
            }
        } else if (event.getSource() == equal) {
            oldtext = display.getText();
            if (oldtext.length() > 0) {
                if (operation.equals("plus")) {
                    newtext = display.getText();
                    num2 = Double.parseDouble(newtext);
                    result = num1 + num2;
                    ans = "" + result;
                    display.setText(ans);
                } else if (operation.equals("minus")) {
                    newtext = display.getText();
                    num2 = Double.parseDouble(newtext);
                    result = num1 - num2;
                    ans = "" + result;
                    display.setText(ans);
                } else if (operation.equals("multiply")) {
                    newtext = display.getText();
                    num2 = Double.parseDouble(newtext);
                    result = num1 * num2;
                    ans = "" + result;
                    display.setText(ans);
                } else if (operation.equals("divider")) {
                    newtext = display.getText();
                    num2 = Double.parseDouble(newtext);
                    result = num1 / num2;
                    ans = "" + result;
                    display.setText(ans);
                }
                a = 1;
            }

        }
    }
}
