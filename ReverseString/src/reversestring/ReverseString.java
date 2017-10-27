package reversestring;
/**
 *
 * @author MD SHAMIM
 */
public class ReverseString {

    public static void main(String[] args) {
        String s,r;
        s = "shamim";
        r = new StringBuffer(s).reverse().toString();
        System.out.println("Orginal : " + s);
        System.out.println("Reverse : " + r);
    }
    
}
