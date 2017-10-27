/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MealDetails;

import DB_Handler.DBconnector;
import java.net.URL;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class Meal_DetailsController implements Initializable {

    @FXML
    private Label totalMealRony;
    @FXML
    private Label totalMealShoton;
    @FXML
    private Label totalMealShuvo;
    @FXML
    private Label totalMealMijan;
    @FXML
    private Label totalMeal;
    @FXML
    private Label totalAmountRony;
    @FXML
    private Label totalAmountShoton;
    @FXML
    private Label totalAmountShuvo;
    @FXML
    private Label totalAmountMijan;
    @FXML
    private Label totalAmount;
    @FXML
    private Label perMealAmount;
    @FXML
    private Label costOfRony;
    @FXML
    private Label costOfShoton;
    @FXML
    private Label costOfShuvo;
    @FXML
    private Label costOfMijan;
    @FXML
    private Label finalcostOfRony;
    @FXML
    private Label finalcostOfShoton;
    @FXML
    private Label finalcostOfShuvo;
    @FXML
    private Label finalcostOfMijan;
    
    private DBconnector db;
    private ResultSet rs;
    
    private double totalamountRony = 0.0;
    private double totalamountShoton = 0.0;
    private double totalamountShuvo = 0.0;
    private double totalamountMijan = 0.0;
    private double totalamount = 0.0;
    private double costofRony = 0.0;
    private double costofShoton = 0.0;
    private double costofShuvo = 0.0;
    private double costofMijan = 0.0;
    private double permealAmount = 0.0;
    private DecimalFormat myFormatter;
    
    
    
    
    private void getData() {
        try {
            db = new DBconnector();
            String qu = "select *from shopping";
            rs = db.execQuery(qu);
            while (rs.next()) {
                double amount = rs.getDouble("amount");
                String person = rs.getString("person");
                if(person.toLowerCase().equals("rony"))
                {
                    totalamountRony += amount;
                }
                else if(person.toLowerCase().equals("shoton"))
                {
                    totalamountShoton += amount;
                }
                else if(person.toLowerCase().equals("shuvo"))
                {
                    totalamountShuvo += amount;
                }
                else if(person.toLowerCase().equals("mijan"))
                {
                    totalamountMijan += amount;
                }

            }
            
            totalamount = totalamountRony + totalamountShoton + totalamountShuvo + totalamountMijan;
                    
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void setLabel()
    {
        totalAmountRony.setText(totalamountRony + "");
        totalAmountShoton.setText(totalamountShoton + "");
        totalAmountShuvo.setText(totalamountShuvo + "");
        totalAmountMijan.setText(totalamountMijan + "");
        totalAmount.setText(totalamount + "");
    }

    public void getMealDetails(double rony,double shoton,double shuvo, double mijan, double total)
    {
        myFormatter = new DecimalFormat(".00");
        totalMealRony.setText(rony + "");
        totalMealShoton.setText(shoton + "");
        totalMealShuvo.setText(shuvo + "");
        totalMealMijan.setText(mijan + "");
        totalMeal.setText(total + "");
        
        permealAmount = totalamount / total; 
        costofRony = permealAmount * rony;
        costofShoton = permealAmount * shoton;
        costofShuvo = permealAmount * shuvo;
        costofMijan = permealAmount * mijan;
        
        perMealAmount.setText(myFormatter.format(permealAmount));
        costOfRony.setText(myFormatter.format(costofRony));
        costOfShoton.setText(myFormatter.format(costofShoton));
        costOfShuvo.setText(myFormatter.format(costofShuvo));
        costOfMijan.setText(myFormatter.format(costofMijan));
        
        
        finalcostOfRony.setText(myFormatter.format(totalamountRony - costofRony));
        finalcostOfShoton.setText(myFormatter.format(totalamountShoton - costofShoton));
        finalcostOfShuvo.setText(myFormatter.format(totalamountShuvo - costofShuvo));
        finalcostOfMijan.setText(myFormatter.format(totalamountMijan - costofMijan));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getData();
        setLabel();
    }    
    
}
