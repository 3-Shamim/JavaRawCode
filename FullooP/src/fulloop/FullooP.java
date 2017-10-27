package fulloop;

import PrivatePackages.Circle;
import PrivatePackages.Rectangler;
//import PrivatePackages.Square;
import PrivatePackages.SquareInheritance;
import PrivatePackages.Triangle;

/**
 *
 * @author MD SHAMIM
 */
public class FullooP {

    public static void main(String[] args) {
        Rectangler R = new Rectangler(10,20);
        SquareInheritance S = new SquareInheritance(10);
        Triangle T = new Triangle(10,20,15);
        Circle C = new Circle(10);
        R.getAreaAndPerimeter();
        S.getAreaAndPerimeter();
        T.getAreaAndPerimeter();
        C.getAreaAndPerimeter();
    }
}
