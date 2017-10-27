/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Computer_Product;

/**
 *
 * @author MD SHAMIM
 */
public class Product {

    private final String productName;
    private final String Model;
    private final String Company;
    private final double Price;
    private final int Remainting;

    public Product(String productName, String Model, String Company, double Price, int Remainting) {
        this.productName = productName;
        this.Model = Model;
        this.Company = Company;
        this.Price = Price;
        this.Remainting = Remainting;
    }

    public String getProductName() {
        return productName;
    }

    public String getModel() {
        return Model;
    }

    public String getCompany() {
        return Company;
    }

    public double getPrice() {
        return Price;
    }

    public int getRemainting() {
        return Remainting;
    }
    
}
