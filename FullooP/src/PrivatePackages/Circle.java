package PrivatePackages;
/**
 *
 * @author MD SHAMIM
 */
public class Circle extends Shape{
    private double radius;
    public Circle(double r)
    {
        radius = r;
    }
    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }
}
