/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop_system_management;

import com.jfoenix.controls.JFXColorPicker;
import shop_system_management.All_Products.ProductList;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXTextField idField;
    @FXML
    private JFXComboBox<String> typeBox;
    @FXML
    private JFXTextField totalproductField;
    @FXML
    private TableView<ProductList> TableView;
    @FXML
    private TableColumn<ProductList, String> nameColumn;
    @FXML
    private TableColumn<ProductList, Number> idColumn;
    @FXML
    private TableColumn<ProductList, String> typeColumn;
    @FXML
    private TableColumn<ProductList, Number> remainingColumn;
    @FXML
    private TableColumn<ProductList, String> dateColumn;

    private ObservableList TypeList;
    private ObservableList Categories;
    private ObservableList CatagoList;
    private String Categorie;

    private ObservableList<ProductList> TableList;

    private int setIndex;
    private int selectedIndex;
    @FXML
    private JFXTextField SearchBox;
    private FilteredList<ProductList> filteredData;
    private SortedList<ProductList> sortedData;
    @FXML
    private JFXComboBox<String> CategoriesCombo;
    @FXML
    private AnchorPane AnchorPaneMain;
    @FXML
    private JFXColorPicker ColorPicker;

    private void TypeBoxItems() {
        TypeList = FXCollections.observableArrayList();
        Categories = FXCollections.observableArrayList();
        TypeList.add("Action");
        TypeList.add("Racing");
        TypeList.add("Fighting");
        TypeList.add("Sports");
        typeBox.setItems(TypeList);

        Categories.add("All");
        Categories.add("Action");
        Categories.add("Racing");
        Categories.add("Fighting");
        Categories.add("Sports");

        CategoriesCombo.setItems(Categories);
    }

    private void getData() {
        DBconnection db = new DBconnection();
        String n = "Action";
        String query = "select *from product";
        TableList = FXCollections.observableArrayList();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                String name = db.rs.getString("ProductName");
                String type = db.rs.getString("ProductType");
                String date = db.rs.getString("Date");
                int id = db.rs.getInt("ProductID");
                int remain = db.rs.getInt("RemainingItems");
                int index = db.rs.getInt("Index");
                setIndex = index;
                ProductList product = new ProductList(id, name, type, remain, date, index);
                TableList.add(product);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        TableView.setItems(TableList);
    }

    private void setColumn() {

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType()));
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate()));
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        remainingColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getRemain()));
    }

    private String getInstantTime() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    boolean findFiledException(String name, String idString, String totalproductString, String type) {
        if (name.isEmpty() || idString.isEmpty() || totalproductString.isEmpty() || type.isEmpty()) {
            return true;
        }
        for (int i = 0; i < idString.length(); i++) {
            if (!Character.isDigit(idString.charAt(i))) {
                return true;
            }
        }
        for (int i = 0; i < totalproductString.length(); i++) {
            if (!Character.isDigit(totalproductString.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private void insertData() {
        DBconnection db = new DBconnection();

//        Blob blob;
//        try {
//            blob = db.con.createBlob();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String name = nameField.getText();

        String idString = idField.getText();

        String totalproductString = totalproductField.getText();

        String type = typeBox.getSelectionModel().getSelectedItem();
        setIndex += 1;

        if (findFiledException(name, idString, totalproductString, type)) {
            System.out.println("Not valid. Any one Field are Empty");
        } else {
            int totalproduct = Integer.parseInt(totalproductString);
            int id = Integer.parseInt(idString);
            try {
                db.st.executeUpdate("INSERT INTO `product`VALUES ('" + id + "',"
                        + "'" + name + "','" + type + "','" + totalproduct + "','" + getInstantTime() + "',"
                        + "'" + setIndex + "')");
            } catch (Exception ex) {
                System.out.println(ex);
            }
            ProductList product = new ProductList(id, name, type, totalproduct, getInstantTime(), setIndex);
            TableList.add(product);
            nameField.clear();
            idField.clear();
            totalproductField.clear();
//            typeBox.getItems().clear();     //  Works
//            typeBox.getSelectionModel().clearSelection();  // Works Also
        }

    }

    private void RemoveData() {
        DBconnection db = new DBconnection();
        int Index = TableList.get(selectedIndex).getIndex();
        String Name = TableList.get(selectedIndex).getName();
        try {
            db.st.executeUpdate("DELETE FROM `product` WHERE `ProductName` = '" + Name + "' AND "
                    + "`Index` = '" + Index + "' ");
            TableList.remove(selectedIndex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void SearchData() {
        filteredData = new FilteredList<>(TableList, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        SearchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(ProductList -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (ProductList.getName().toLowerCase().contains(newValue)) {
                    return true; // Filter matches first name.
                }

                return false; // Does not match.
            });
        });
        sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(TableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        TableView.setItems(sortedData);
    }

    private void SelectCategories() {
        CatagoList = FXCollections.observableArrayList();
        if (Categorie.toLowerCase().equals("all")) {
            getData();
        } else {
            DBconnection db = new DBconnection();
            String query = "select *from product WHERE ProductType = '" + Categorie + "'";
            try {
                db.rs = db.st.executeQuery(query);
                while (db.rs.next()) {
                    String name = db.rs.getString("ProductName");
                    String type = db.rs.getString("ProductType");
                    String date = db.rs.getString("Date");
                    int id = db.rs.getInt("ProductID");
                    int remain = db.rs.getInt("RemainingItems");
                    int index = db.rs.getInt("Index");
                    ProductList product = new ProductList(id, name, type, remain, date, index);
                    CatagoList.add(product);
                }
                TableView.setItems(CatagoList);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

    private void tableIn() {
        TableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (TableView.getSelectionModel().getSelectedItem() != null) {
                    TableViewSelectionModel selectionModel = TableView.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    System.out.println("Selected Value" + val);
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TypeBoxItems();   // For All Product Types.
        getData();        // For geting data from Databases.
        setColumn();      // For seting Column
        SearchData();
        
    }

    @FXML
    private void submitButton(ActionEvent event) {
        insertData();
    }

    @FXML
    private void removeButton(ActionEvent event) {
        RemoveData();
    }

    @FXML
    private void selectEventClick(MouseEvent event) {
        selectedIndex = TableView.getSelectionModel().getSelectedIndex();
        tableIn();
    }

    @FXML
    private void CategoriesComboActionClicked(ActionEvent event) {
        Categorie = CategoriesCombo.getSelectionModel().getSelectedItem();
        if (Categorie != null) {
            SelectCategories();
        }

    }

    @FXML
    private void searchClickedevent(MouseEvent event) {
        SearchData();
    }

    @FXML
    private void ColorPickerAction(ActionEvent event) {
        Color selectColor = ColorPicker.getValue();
        AnchorPaneMain.setBackground(new Background(new BackgroundFill(Paint.valueOf(selectColor.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }

}
