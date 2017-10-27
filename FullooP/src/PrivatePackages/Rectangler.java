package PrivatePackages;
/**
 *
 * @author MD SHAMIM
 */
public class Rectangler extends Shape {

    protected double length;
    private double width;

    public Rectangler(double l, double w)
    {
        length = l;
        width = w;
    }

    public Rectangler() 
    {
        
    }
    
    @Override
    public double getArea()
    {
        return length * width;
    }
    @Override
    public double getPerimeter()
    {
        return 2*(length * width);
    }
}
