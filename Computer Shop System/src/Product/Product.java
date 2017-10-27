/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import javafx.scene.image.ImageView;

/**
 *
 * @author MD SHAMIM
 */
public class Product {
    private final String name;
    private final ImageView image;

    public Product(String name, ImageView image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public ImageView getImage() {
        image.setFitHeight(50);
        image.setFitWidth(50);
        return image;
    }
    
}
