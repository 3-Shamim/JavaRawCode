package oop_2;
/**
 *
 * @author MD SHAMIM
 */
public class Adder extends Arithmetic {
    public Adder(int x, int y)
    {
        super(x,y);
    }
    public void sum()
    {
        System.out.println(add());
    }
}
