/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author MD SHAMIM
 */
public class SingleThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Printer p = new Printer(0, 1000, "Print = ");
        Printer p1 = new Printer(0, 1000, "Print = ");
        p.start();
        p1.start();

        
    }
    
}
