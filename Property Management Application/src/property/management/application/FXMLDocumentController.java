/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property.management.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField IdField;
    @FXML
    private TextField NameField;
    @FXML
    private ListView<Property> ListView;
    @FXML
    private TableView<Property> TableView;
    @FXML
    private TableColumn<Property, Number> IdColum;
    @FXML
    private TableColumn<Property, String> NameColum;
    private ObservableList<Property> List;
    private int PropertyIndex,SelectedIndex;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DBconnection DB = new DBconnection();
        List = FXCollections.observableArrayList();
        ListView.setItems(List);
        TableView.setItems(List);
        IdColum.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        NameColum.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        try
        {
            String query = " SELECT * FROM `property` ";
            DB.rs = DB.st.executeQuery(query);
            while(DB.rs.next())
            {
                String Name = DB.rs.getString("Name");
                int Id = DB.rs.getInt("Id");
                int Index = DB.rs.getInt("Index");
                Property p = new Property(Name,Id,Index);
                List.add(p);
                PropertyIndex = Index;
            }    
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }    

    @FXML
    private void SubmitButton(ActionEvent event) {
        
        String Name = NameField.getText();
        int Id = Integer.parseInt(IdField.getText());
        PropertyIndex += 1;
        try
        {
            DBconnection DB = new DBconnection();
            DB.st.executeUpdate("insert into property values('" + Id + "','" + Name +"','" + PropertyIndex +"')");
            Property p = new Property(Name,Id,PropertyIndex);
            List.add(p);
            NameField.clear();
            IdField.clear();
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }   
    }

    @FXML
    private void UpdateButton(ActionEvent event) {
        int ID = Integer.parseInt(IdField.getText());
        String NAME = NameField.getText();
        int propertyIndex = List.get(SelectedIndex).getIndex();
        try
        {
            DBconnection DB = new DBconnection();
            DB.st.executeUpdate("UPDATE `property` SET `Id`='"+ID+"',"
                    + "`Name`='"+NAME+"' WHERE `Index`='"+propertyIndex+"'");
            Property p = new Property(NAME,ID,PropertyIndex);
            List.set(SelectedIndex, p);
            NameField.clear();
            IdField.clear();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @FXML
    private void DeleteButton(ActionEvent event) {
        int ID = List.get(SelectedIndex).getId();
        String NAME = List.get(SelectedIndex).getName();
        try
        {
            DBconnection DB = new DBconnection();
            DB.st.executeUpdate("DELETE FROM property WHERE Id = " 
                    + ID + " AND Name = '" 
                    + NAME + "'");
            List.remove(SelectedIndex);
            NameField.clear();
            IdField.clear();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @FXML
    private void ListClickAction(MouseEvent event) {
        SelectedIndex = ListView.getSelectionModel().getSelectedIndex();
        IdField.setText(List.get(SelectedIndex).getId()+"");
        NameField.setText(List.get(SelectedIndex).getName());
    }
    
}
