package PrivatePackages;
/**
 *
 * @author MD SHAMIM
 */
public abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
    public void getAreaAndPerimeter()
    {
        System.out.printf("Area = %.2f \nPerimeter = %.2f\n", getArea(),getPerimeter() );
    }
}
