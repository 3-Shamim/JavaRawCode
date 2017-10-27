/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treetable.view;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MD SHAMIM
 */
public class Students {
    private final SimpleStringProperty name;
    private final SimpleLongProperty id;

    public Students(String name, long id) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleLongProperty(id);
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public SimpleLongProperty getId() {
        return id;
    }
    
    
    
}
