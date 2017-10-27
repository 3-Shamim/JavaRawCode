/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageview;
import javafx.scene.image.ImageView;
/**
 *
 * @author MD SHAMIM
 */
public class SimpleClass {
    private final ImageView image;
    private final int id;

    public SimpleClass(ImageView image, int id) {
        this.image = image;
        this.id = id;
    }

    public ImageView getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
    
}
