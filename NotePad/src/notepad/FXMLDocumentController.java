/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField NameField;
    @FXML
    private TextField IdField;
    @FXML
    private ListView<Property> ListViewer;
    private ObservableList<Property> List;
    private int SelectedIndex;
    @FXML
    private Button Update;
    private int ItemIndex;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBConnection db = new DBConnection();   
        ListViewer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List = FXCollections.observableArrayList();
        ListViewer.setItems(List);
        try
        {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("System Open");
            alert.setHeaderText("Looks Good..");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                String query = "select *from shamim";
                ResultSet rs = db.st.executeQuery(query);
                while(rs.next())
                {
                    String name = rs.getString("Name");
                    int id = rs.getInt("Id");
                    int index = rs.getInt("Index");
                    ItemIndex = index;
                    Property p = new Property(name,id,index);
                    List.add(p);
                }
                
            }
            else
            {
                System.exit(0);
            }
            
        }
        catch(Exception ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Look, an Error Can't Connect");
            alert.setContentText("Ooops, there was an error can't connect with Database..!");

            alert.showAndWait();
            System.out.println(ex);
        }
        
    }    

    @FXML
    private void SubmitButton(ActionEvent event) {
        
        ItemIndex += 1;
        String Name = NameField.getText();
        int ID = Integer.parseInt(IdField.getText());
        try
        {
            DBConnection db = new DBConnection();
            db.st.executeUpdate("insert into shamim values('" + ID + "','" + Name +"','" + ItemIndex +"')");
            Property p = new Property(Name,ID,ItemIndex);
            List.add(p);
            NameField.clear();
            IdField.clear();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmation Massage");
            alert.setHeaderText(null);
            alert.setContentText("Added to Database..");

            alert.showAndWait();
        }
        catch(Exception ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, there was an error can't connect with Database..!");

            alert.showAndWait();
            System.out.println(ex);
        }
        
    }

    @FXML
    private void DeleteButton(ActionEvent event) {
        
        try
        {
            DBConnection db = new DBConnection();
            int ownerID = List.get(SelectedIndex).getOwnerId();
            String ownerName = List.get(SelectedIndex).getOwnername();
            db.st.executeUpdate("DELETE FROM shamim WHERE Id = " 
                    + ownerID + " AND Name = '" 
                    + ownerName + "'");
            List.remove(SelectedIndex);
            NameField.clear();
            IdField.clear();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmation Massage");
            alert.setHeaderText(null);
            alert.setContentText("Deleted from Database..");

            alert.showAndWait();
        }
        catch(Exception ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Look, an Error Can't Delete!");
            alert.setContentText("Ooops, there was an error can't connect with Database..!");

            alert.showAndWait();
            System.out.println(ex);
        }
        
    }

    @FXML
    private void ListClickAction(MouseEvent event) {
        SelectedIndex = ListViewer.getSelectionModel().getSelectedIndex();
        IdField.setText(List.get(SelectedIndex).getOwnerId()+"");
        NameField.setText(List.get(SelectedIndex).getOwnername());
        
    }

    @FXML
    private void UpdateButton(ActionEvent event) {
        
        try
        {
            
            DBConnection db = new DBConnection();
            String name = NameField.getText();
            int ID = Integer.parseInt(IdField.getText());
            int Index = List.get(SelectedIndex).getOwnerIndex();
            
            db.st.executeUpdate("UPDATE `shamim` SET `Id`='"+ID+"',"
                    + "`Name`='"+name+"' WHERE `Index`='"+Index+"'");
            NameField.clear();
            IdField.clear();
            
            List.clear();
            String query = "select *from shamim";
            ResultSet rs = db.st.executeQuery(query);
            while(rs.next())
            {
                String Name = rs.getString("Name");
                int id = rs.getInt("Id");
                int index = rs.getInt("Index");
                ItemIndex = index;
                Property p = new Property(Name,id,index);
                List.add(p);
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmation Massage");
            alert.setHeaderText(null);
            alert.setContentText("Updated to Database..");

            alert.showAndWait();
              
        }
        catch(Exception ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, there was an error can't connect with Database..!");

            alert.showAndWait();
            System.out.println(ex);
        }
    }
    
}
