/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.shop.system;

import Product.Product;
import TreeList.TreeList;
import com.jfoenix.controls.JFXTreeView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTreeView<?> treeListView;
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Image> imageCol;
    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private ImageView imgaeView;

    private ObservableList<Product> productList;
    private ObservableList<Product> CopyAllproductList;
    private ObservableList<Product> subproductList;

    private void setdata() {
        Image image1 = new Image("/Image/1.png");
        Image image2 = new Image("/Image/2.png");
        Image image3 = new Image("/Image/3.jpg");
        Image image4 = new Image("/Image/4.png");
        Image image5 = new Image("/Image/5.png");
        Image image6 = new Image("/Image/6.png");
        Image image7 = new Image("/Image/7.png");
        Image image8 = new Image("/Image/8.png");
        productList = FXCollections.observableArrayList();

        productList.add(new Product("Dell", new ImageView(image1)));
        productList.add(new Product("Dell", new ImageView(image2)));
        productList.add(new Product("Dell", new ImageView(image3)));
        productList.add(new Product("H", new ImageView(image4)));
        productList.add(new Product("P", new ImageView(image5)));
        productList.add(new Product("Dell", new ImageView(image6)));
        productList.add(new Product("Dell", new ImageView(image7)));
        productList.add(new Product("Dell", new ImageView(image8)));
        tableView.setItems(productList);
        CopyAllproductList = FXCollections.observableArrayList(productList);
    }

    private void setTreeLst() {
        TreeList treeList = new TreeList();
        TreeItem t1 = new TreeItem("Product");
        t1.getChildren().addAll(treeList.getProduct());
        treeListView.setRoot(t1);
        treeListView.getSelectionModel().selectFirst();
    }

    private void setCol() {
        imageCol.setCellValueFactory(new PropertyValueFactory<>("Image"));
        nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTreeLst();
        setdata();
        setCol();
        tableView.getSelectionModel().selectFirst();
    }

    @FXML
    private void treeListClickedAction(MouseEvent event) {
        String name = treeListView.getSelectionModel().getSelectedItem().getValue().toString();
        subproductList = FXCollections.observableArrayList();
        System.out.println(name);
        for (Product product : productList) {

            if (name.equals("Product")) {
                CopyAllproductList.clear();
                CopyAllproductList = FXCollections.observableArrayList(productList);
                tableView.setItems(CopyAllproductList);
            } else if (product.getName().equals(name)) {
                subproductList.add(new Product(product.getName(), product.getImage()));
            }
        }
        if (!subproductList.isEmpty()) {
            CopyAllproductList.clear();
            CopyAllproductList = FXCollections.observableArrayList(subproductList);
            tableView.setItems(CopyAllproductList);
        }
    }

    @FXML
    private void OnClickedActiontableView(MouseEvent event) {
        int Index = tableView.getSelectionModel().getSelectedIndex();
        ImageView imageView = CopyAllproductList.get(Index).getImage();
        imgaeView.setImage(imageView.getImage());
    }

}
