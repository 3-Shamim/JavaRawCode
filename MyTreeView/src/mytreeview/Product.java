/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytreeview;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MD SHAMIM
 */
public class Product {

    private final SimpleStringProperty productName;
    private final SimpleIntegerProperty Remainting;

    public Product(String productName, int Remainting) {
        this.productName = new SimpleStringProperty(productName);
        this.Remainting = new SimpleIntegerProperty(Remainting);
    }

    public SimpleStringProperty getProductName() {
        return productName;
    }

    public SimpleIntegerProperty getRemainting() {
        return Remainting;
    }

}
