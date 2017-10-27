/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop_customer;

import Computer_Product.Product;
import DBConnector.DataBaseHandler;
import ProductCompare.ProductCompareController;
import Product_details.Product_detailsController;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author MD SHAMIM
 */
public class Custom_MainController implements Initializable {

    @FXML
    private JFXTextField SearchBox;
    @FXML
    private JFXComboBox<String> categoriesBox;
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> ModelColumn;
    @FXML
    private TableColumn<Product, Number> PriceColumn;
    @FXML
    private TableColumn<Product, String> Type;

    private DataBaseHandler db;
    private ObservableList<Product> ProductList;
    private ObservableList<String> CategoriesList;
    private FilteredList<Product> filteredData;
    private SortedList<Product> sortedData;
    private Product product;
    private String SelectedProduct;
    private int SelectedProductIndex;
    private double priceLabel;
    @FXML
    private JFXSlider PriceLabel;
    private String Selectedcategorie;

    void setCategories() {
        db = new DataBaseHandler();
        CategoriesList = FXCollections.observableArrayList();

        try {
            String qu = "select *from categories";
            ResultSet rs = db.execQuery(qu);
            while (rs.next()) {
                String categories = rs.getString("Categories");
                CategoriesList.add(categories);
            }
            categoriesBox.setItems(CategoriesList);
            categoriesBox.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void getData(String categories) {

        db = new DataBaseHandler();
        ProductList = FXCollections.observableArrayList();
        try {
            String qu = "select *from all_product WHERE Name = '" + categories + "'";
            ResultSet rs = db.execQuery(qu);
            while (rs.next()) {
                String productName = rs.getString("Name");
                String Model = rs.getString("Model");
                String Company = rs.getString("Company");
                double price = rs.getDouble("Price");
                int remain = rs.getInt("Remaining");
                product = new Product(productName, Model, Company, price, remain);
                ProductList.add(product);
            }
            tableView.setItems(ProductList);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void getAllData() {
        db = new DataBaseHandler();
        ProductList = FXCollections.observableArrayList();
        try {
            String qu = "select *from all_product";
            ResultSet rs = db.execQuery(qu);
            while (rs.next()) {
                String productName = rs.getString("Name");
                String Model = rs.getString("Model");
                String Company = rs.getString("Company");
                double price = rs.getDouble("Price");
                int remain = rs.getInt("Remaining");
                product = new Product(productName, Model, Company, price, remain);
                ProductList.add(product);
            }
            tableView.setItems(ProductList);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void IntializeColumn() {
        ModelColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getModel()));
        Type.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProductName()));
        PriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        tableView.getSelectionModel().selectFirst();
    }

    private void SearchData() {
        filteredData = new FilteredList<>(ProductList, p -> true);

        SearchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(productList -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (productList.getModel().toLowerCase().contains(newValue)) {
                    return true;
                } else if (productList.getCompany().toLowerCase().contains(newValue)) {
                    return true;
                }
                return false;
            });
        });
        sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCategories();
        getAllData();
        IntializeColumn();
        tableView.getSelectionModel().selectFirst();
        SearchData();
    }

    @FXML
    private void LogInButton(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/Main_Log_in_page/Main_log_in_Page.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void categoriesShowButton(ActionEvent event) {
        Selectedcategorie = categoriesBox.getSelectionModel().getSelectedItem();
        if (Selectedcategorie.equals("ALL")) {
            getAllData();
            SearchData();
        } else {
            getData(Selectedcategorie);
            SearchData();
        }
        tableView.getSelectionModel().selectFirst();
    }

    @FXML
    private void ShowDetailsButton(ActionEvent event) throws Exception {
//        SelectedProduct = ProductList.get(SelectedProductIndex).getModel();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Product_details/Product_details.fxml"));

        Parent parent = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        ((Product_detailsController) fxmlLoader.getController()).setData(SelectedProduct);
        stage.show();
    }

    @FXML
    private void BuyNowButton(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("You Must be Loged in");
        alert.setContentText("Need to login for buying any product");
        alert.showAndWait();
    }

    @FXML
    private void ClickOnProduct(MouseEvent event) {
        SelectedProductIndex = tableView.getSelectionModel().getSelectedIndex();
        SelectedProduct = ProductList.get(SelectedProductIndex).getModel();
    }

    @FXML
    private void CompareButton(ActionEvent event) throws Exception {
//        SelectedProduct = ProductList.get(SelectedProductIndex).getModel();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProductCompare/ProductCompare.fxml"));

        Parent parent = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        ((ProductCompareController) fxmlLoader.getController()).setData(SelectedProduct);
        stage.show();
    }

    @FXML
    private void PriceLabel(MouseEvent event) {
        priceLabel = PriceLabel.getValue();
        db = new DataBaseHandler();
        ProductList = FXCollections.observableArrayList();

        if (Selectedcategorie == null) {
            try {
                String qu = "select *from all_product WHERE  Price < '" + priceLabel + "' ";
                ResultSet rs = db.execQuery(qu);
                while (rs.next()) {
                    String productName = rs.getString("Name");
                    String Model = rs.getString("Model");
                    String Company = rs.getString("Company");
                    double price = rs.getDouble("Price");
                    int remain = rs.getInt("Remaining");
                    product = new Product(productName, Model, Company, price, remain);
                    ProductList.add(product);
                }
                tableView.setItems(ProductList);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (Selectedcategorie.equals("ALL")) {
            try {
                String qu = "select *from all_product WHERE  Price < '" + priceLabel + "' ";
                ResultSet rs = db.execQuery(qu);
                while (rs.next()) {
                    String productName = rs.getString("Name");
                    String Model = rs.getString("Model");
                    String Company = rs.getString("Company");
                    double price = rs.getDouble("Price");
                    int remain = rs.getInt("Remaining");
                    product = new Product(productName, Model, Company, price, remain);
                    ProductList.add(product);
                }
                tableView.setItems(ProductList);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            try {
                String qu = "select *from all_product WHERE Name = '" + Selectedcategorie + "' AND Price < '" + priceLabel + "' ";
                ResultSet rs = db.execQuery(qu);
                while (rs.next()) {
                    String productName = rs.getString("Name");
                    String Model = rs.getString("Model");
                    String Company = rs.getString("Company");
                    double price = rs.getDouble("Price");
                    int remain = rs.getInt("Remaining");
                    product = new Product(productName, Model, Company, price, remain);
                    ProductList.add(product);
                }
                tableView.setItems(ProductList);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

}
