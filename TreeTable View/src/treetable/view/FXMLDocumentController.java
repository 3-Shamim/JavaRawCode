/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treetable.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;


/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TreeTableView<String> TableView;
    @FXML
    private TreeTableColumn<String, String> col1;

    @FXML
    private TreeTableView<Students> mTableView;
    @FXML
    private TreeTableColumn<Students, String> mCol1;
    @FXML
    private TreeTableColumn<Students, Number> mCol2;
    
    private ObservableList<Students> list;

    private void SingleTreeTable() {
        TreeItem<String> item1 = new TreeItem<>("Java");
        TreeItem<String> item2 = new TreeItem<>("C++");
        TreeItem<String> item3 = new TreeItem<>("Phython");
        TreeItem<String> parent1 = new TreeItem<>("High Level Languages");

        TreeItem<String> item4 = new TreeItem<>("Java Script");
        TreeItem<String> item5 = new TreeItem<>("PHP");
        TreeItem<String> parent2 = new TreeItem<>("WEB Languages");

        TreeItem<String> root = new TreeItem<>("Programing Languages");
        
        parent1.getChildren().setAll(item1, item2, item3);
        parent2.getChildren().setAll(item4, item5);

        root.getChildren().setAll(parent1, parent2);

        col1.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> param) -> new SimpleStringProperty(param.getValue().getValue()));
        TableView.setRoot(root);
    }
    
    private void MultpleColumnTreeTableView()
    {
        list = FXCollections.observableArrayList();
//        list.add(new Students("Shamim", 2015000000003l));
//        list.add(new Students("Faisal", 2015000000199l));
        TreeItem<Students> item1 = new TreeItem<>(new Students("Shamim", 2015000000003l));
        TreeItem<Students> item2 = new TreeItem<>(new Students("Faisal", 2015000000199l));
        
        TreeItem<Students> root = new TreeItem<>(new Students("Name", 0));
        
        root.getChildren().setAll(item1,item2);
        
        mCol1.setCellValueFactory((TreeTableColumn.CellDataFeatures<Students, String> param) -> param.getValue().getValue().getName());
        mCol2.setCellValueFactory((TreeTableColumn.CellDataFeatures<Students, Number> param) -> param.getValue().getValue().getId());
        mTableView.setRoot(root);
        mTableView.setShowRoot(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SingleTreeTable();
        MultpleColumnTreeTableView();
        
    }

}
