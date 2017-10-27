/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admission.form;

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
    
    @FXML
    private Button button;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    Boolean ID(String studentid)
    {
        if(studentid.length() != 13)
        {
            return false;
        }
            
        for(int i = 0; i < studentid.length(); i++)
        {
            if(studentid.charAt(i)<'0' || studentid.charAt(i)>'9')
            {
                return false;
            }
        }
        return true;
    }
    
    Boolean Name(String studentname)
    {
        for(int i = 0; i<studentname.length(); i++)
        {
            if(' ' > studentname.charAt(i) || (' ' < studentname.charAt(i) && studentname.charAt(i) < 'A') || studentname.charAt(i)> 'Z' )
            {
                return false;
            }
        }
        if(studentname.length() == 0)
        {
            return false;
        }
        return true;
    }
    
    Boolean Email(String studentemail,String save)
    {
        if(save.equals("@gmail.com") || save.equals("@yahoo.com") || save.equals("@hotmail.com"))
        {
            return true;
        }
        return false;
    }
    
    Boolean Phone(String phone)
    {
        if(phone.length() != 11)
        {
            return false;
        }
        for(int i = 0; i < phone.length(); i++)
        {
            if(phone.charAt(i)<'0' || phone.charAt(i)>'9')
            {
                return false;
            }
        }
        if(     phone.startsWith("011") ||
                phone.startsWith("015") ||
                phone.startsWith("016") ||
                phone.startsWith("017") ||
                phone.startsWith("018") ||
                phone.startsWith("019") );
        else
        {
            return false;
        }
        return true;
    }


    @FXML
    private void button(ActionEvent event) {
        
        // Student ID
        
        String studentid = id.getText().trim();
        if(ID(studentid))
        {
            System.out.println("Valid");
        }
        else
        {
            System.out.println("Invalid");
        }
        
        // Student Name
        
        String studentname = name.getText().trim();
        if(Name(studentname))
        {
            System.out.println("Valid");
        }
        else
        {
            System.out.println("Invalid");
        }
        
        // Eamil
        
        String studentemail,save="";
        studentemail = email.getText();
        for(int i = 0; i < studentemail.length(); i++)
        {
            if(studentemail.charAt(i) == '@')
            {
                save = studentemail.substring(i,studentemail.length());
            }
        }
        if(Email(studentemail,save))
        {
            System.out.println("Valid");
        }
        else
        {
            System.out.println("Invalid");
        }
        
        // Phone number
        
        String phone;
        phone = number.getText().trim();
        if(Phone(phone))
        {
            System.out.println("Valid");
        }
        else
        {
            System.out.println("Invalid");
        }
        
    }
    
}
