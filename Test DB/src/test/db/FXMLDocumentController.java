/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.db;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> nameCOl;
    @FXML
    private TableColumn<?, ?> idCol;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DB db = new DB();
    }    
    
}
