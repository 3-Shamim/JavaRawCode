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
public class Printer extends Thread {
    private final int start;
    private final int stop;
    private final String label;

    public Printer(int start, int stop, String label) {
        this.start = start;
        this.stop = stop;
        this.label = label;
    }
    
    public void print()
    {
        for (int i = start; i < stop; i++) {
            System.out.printf("%s: %d\n", label, i);
        }
    }
    
    @Override
    public void run()
    {
        print();
    }
}
