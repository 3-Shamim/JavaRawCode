/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package age_calculator;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private DatePicker dateField;
    @FXML
    private Label yearLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private Label dayLabel;
    
    private int ayear;
    private int amonth;
    private int aday;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void getAgeActionButton(ActionEvent event) {
        String date = dateField.getValue().toString();
        int day = dateField.getValue().getDayOfMonth();
        int month = dateField.getValue().getMonthValue();
        int year = dateField.getValue().getYear();
        //dateField.getValue().getDayOfYear();
        
        String Dpattern = "dd";
        String Mpattern = "MM";
        String Ypattern = "YYYY";
        SimpleDateFormat CurrentDay = new SimpleDateFormat(Dpattern);
        SimpleDateFormat CurrentMonth = new SimpleDateFormat(Mpattern);
        SimpleDateFormat CurrentYear = new SimpleDateFormat(Ypattern);
        int Cday = Integer.parseInt(CurrentDay.format(new Date()));
        int Cmonth = Integer.parseInt(CurrentMonth.format(new Date()));
        int Cyear = Integer.parseInt(CurrentYear.format(new Date()));
        
        ayear = Cyear - year;
        
        if(Cmonth < month)
        {
            amonth = (Cmonth + 12) - month;
            ayear -= 1;
        }
        else
        {
            amonth = Cmonth - month;
        }
        
        if(Cday < day)
        {
            aday = (Cday + 31) - day;
            amonth -= 1;
        }
        else
        {
            aday = Cday - day;
        }
        
        yearLabel.setText(ayear + "");
        monthLabel.setText(amonth + "");
        dayLabel.setText(aday + "");
    }
    
}
