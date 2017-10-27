/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerList;

import Customer.Customer;
import DB_Connector.DataBaseHandler;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD SHAMIM
 */
public class CustomerDetailsController implements Initializable {

    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, String> userNameColumn;
    @FXML
    private TableColumn<Customer, String> fullrNameColumn;
    @FXML
    private TableColumn<Customer, String> phoneNumberColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;
    @FXML
    private TableColumn<Customer, String> passwordColumn;
    @FXML
    private TableColumn<Customer, String> genderColumn;
    
    private ResultSet rs;
    private Customer customer;
    private DataBaseHandler db;
    private ObservableList<Customer> CustomerList;
    @FXML
    private JFXButton closeButton;
    
    void getData()
    {
        db = new DataBaseHandler();
        CustomerList = FXCollections.observableArrayList();
        try
        {
            String qu = "SELECT * FROM `customeruser`";
            rs = db.execQuery(qu);
            while(rs.next())
            {
                String userName = rs.getString("UserName");
                String fullName = rs.getString("FullName");
                String phoneNumber = rs.getString("PhoneNumber");
                String Email = rs.getString("Email");
                String Passward = rs.getString("Password");
                String Gender = rs.getString("Gender");
                customer = new Customer(userName, fullName, phoneNumber, Email, Passward, Gender);
                CustomerList.add(customer);
            }
            customerTableView.setItems(CustomerList);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    void InitializeColumn()
    {
        userNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getUserName()));
        fullrNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFullName()));
        phoneNumberColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPhoneNumber()));
        emailColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
        passwordColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPassward()));
        genderColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGender()));
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getData();
        InitializeColumn();
    }    

    @FXML
    private void CloseCustomerList(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
}
