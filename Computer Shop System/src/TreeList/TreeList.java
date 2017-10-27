/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 *
 * @author MD SHAMIM
 */
public class TreeList {
    private ObservableList<TreeItem> product;
    private ObservableList<TreeItem> car;
    private ObservableList<TreeItem> laptop;

    public ObservableList<TreeItem> getProduct() {
        product = FXCollections.observableArrayList();
        TreeItem t1 = new TreeItem("Laptop");
        TreeItem t2 = new TreeItem("Car");
        t1.getChildren().addAll(getLaptop());
        t2.getChildren().addAll(getCar());
        product.add(t1);
        product.add(t2);
        return product;
    }

    public ObservableList<TreeItem> getCar() {
        car = FXCollections.observableArrayList();
        TreeItem t1 = new TreeItem("BMW");
        TreeItem t2 = new TreeItem("Audi");
        TreeItem t3 = new TreeItem("Aston Martin");
        car.add(t1);
        car.add(t2);
        car.add(t3);
        return car;
    }

    public ObservableList<TreeItem> getLaptop() {
        laptop = FXCollections.observableArrayList();
        TreeItem t1 = new TreeItem("HP");
        TreeItem t2 = new TreeItem("Dell");
        TreeItem t3 = new TreeItem("Apple");
        laptop.add(t1);
        laptop.add(t2);
        laptop.add(t3);
        return laptop;
    }
    

}
