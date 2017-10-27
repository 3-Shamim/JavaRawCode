/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple_Class;

/**
 *
 * @author MD SHAMIM
 */
public class Shoping {
    private final String date;
    private final double amount;
    private final String name;

    public Shoping(String date, double amount, String name) {
        this.date = date;
        this.amount = amount;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
    
}
