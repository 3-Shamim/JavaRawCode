package PrivatePackages;
/**
 *
 * @author MD SHAMIM
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;
    public Triangle(double x, double y, double z)
    {
        a = x;
        b = y;
        c = z;
    }

    @Override
    public double getArea()
    {
        double s = getPerimeter()/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override
    public double getPerimeter()
    {
        return a+b+c;
    }
}
