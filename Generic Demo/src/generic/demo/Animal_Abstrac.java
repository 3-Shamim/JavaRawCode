/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.demo;

/**
 *
 * @author MD SHAMIM
 */
public class Animal_Abstrac implements Animal{

    @Override
    public void eat() {
        System.out.println("I want to eat.");
    }

    @Override
    public void travel() {
        System.out.println("I want to travel.");
    }
    
}
