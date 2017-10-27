package PrivatePackages;
/**
 *
 * @author MD SHAMIM
 */
public class SquareInheritance extends Rectangler{
    public SquareInheritance(double length)
    {
        super(length,length);
    }
    @Override
    public double getArea()
    {
        return length * length + 4 * length;
    }
}
