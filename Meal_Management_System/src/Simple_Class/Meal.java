/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple_Class;

/**
 *
 * @author Saurav
 */
public class Meal {
    private final String date;
    private final double rony;
    private final double shoton;
    private final double shuvo;
    private final double mijan;

    public Meal(String date, double rony, double shoton, double shuvo, double mijan) {
        this.date = date;
        this.rony = rony;
        this.shoton = shoton;
        this.shuvo = shuvo;
        this.mijan = mijan;
    }

    public String getDate() {
        return date;
    }

    public double getRony() {
        return rony;
    }

    public double getShoton() {
        return shoton;
    }

    public double getShuvo() {
        return shuvo;
    }

    public double getMijan() {
        return mijan;
    }
    
    
    
}
