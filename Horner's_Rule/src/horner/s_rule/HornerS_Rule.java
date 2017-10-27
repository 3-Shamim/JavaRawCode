package horner.s_rule;

import java.util.Scanner;

/**
 *
 * @author Md Shamim
 */
public class HornerS_Rule {

    static String check = "";
    static int sum = 0;

    static boolean NotDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    static int convertStringToInt(String input) {
        if (NotDigit(input)) {
            check = "NotDigit";
        } else {
            for (int i = 0; i < input.length(); i++) {
                sum = sum * 10 + (input.charAt(i) - 48);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner str = new Scanner(System.in);
        String input = str.nextLine();

//        if (NotDigit(input)) {
//            System.out.println("It's not Digits.");
//        } else {
//            for (int i = 0; i < input.length(); i++) {
//                sum = sum * 10 + (input.charAt(i) - 48);
//            }
//            System.out.println(sum);
//        }
        int x = convertStringToInt(input);
        if (check.equals("NotDigit")) {
            System.out.println("It's not digits.");
        } else {
            System.out.println(x);
        }

    }

}
