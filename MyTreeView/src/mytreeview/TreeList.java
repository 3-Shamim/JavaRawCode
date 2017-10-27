/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytreeview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 *
 * @author MD SHAMIM
 */
public class TreeList {

    private ObservableList<TreeItem> Products;
    private ObservableList<TreeItem> Cars;
    private ObservableList<TreeItem> Buses;
    private ObservableList<TreeItem> Motorcycles;

    public ObservableList<TreeItem> getProducts() {
        
        Products = FXCollections.observableArrayList();
        
        TreeItem Car = new TreeItem("Cars");
        Car.getChildren().setAll(getCars());
        
        TreeItem Bus = new TreeItem("Buses");
        Bus.getChildren().setAll(getCars());
        
        TreeItem Moto = new TreeItem("Motorcycles");
        Moto.getChildren().setAll(getMotorcycles());
        
        Products.add(Bus);
        Products.add(Car);
        Products.add(Moto);
        
        return Products;
    }

    public ObservableList<TreeItem> getCars() {

        Cars = FXCollections.observableArrayList();

        TreeItem bmw = new TreeItem("BMW");
        TreeItem ferrari = new TreeItem("Ferrari");
        TreeItem porsche = new TreeItem("Porsche");
        TreeItem ford = new TreeItem("Ford");
        TreeItem mercedes = new TreeItem("Mercedes");

        Cars.add(bmw);
        Cars.add(ferrari);
        Cars.add(porsche);
        Cars.add(ford);
        Cars.add(mercedes);

        return Cars;
    }

    public ObservableList<TreeItem> getBuses() {

        Buses = FXCollections.observableArrayList();

        TreeItem gm = new TreeItem("GM");
        TreeItem vw = new TreeItem("VW");
        TreeItem man = new TreeItem("MAN");
        TreeItem volvo = new TreeItem("Volvo");

        Buses.add(gm);
        Buses.add(man);
        Buses.add(volvo);
        Buses.add(vw);

        return Buses;
    }

    public ObservableList<TreeItem> getMotorcycles() {

        Motorcycles = FXCollections.observableArrayList();

        TreeItem harley = new TreeItem("Harley");
        TreeItem suzuki = new TreeItem("Suzuki");
        TreeItem ktm = new TreeItem("KTM");
        TreeItem honda = new TreeItem("Honda");

        Motorcycles.add(harley);
        Motorcycles.add(honda);
        Motorcycles.add(ktm);
        Motorcycles.add(suzuki);

        return Motorcycles;
    }

}
