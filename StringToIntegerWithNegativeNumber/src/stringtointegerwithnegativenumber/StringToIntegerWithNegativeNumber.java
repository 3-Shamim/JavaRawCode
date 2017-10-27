package stringtointegerwithnegativenumber;

import java.util.Scanner;

/**
 *
 * @author Md Shamim
 */

public class StringToIntegerWithNegativeNumber {

    static String sInput = "", operation = "";
    static int sum = 0;

    static boolean isNegative(String input) {
        if (input.charAt(0) == '-') {
            sInput = input.substring(1);
            return true;
        }
        return false;
    }

    static int convertStringToInt(String input) {
        if (isNegative(input)) {
            for (int i = 0; i < sInput.length(); i++) {
                sum = sum * 10 + (sInput.charAt(i) - 48);
                operation = "Negative";
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                sum = sum * 10 + (input.charAt(i) - 48);
                operation = "Positive";
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner str = new Scanner(System.in);
        String input = str.nextLine();

        int x = convertStringToInt(input);
        if (operation.equals("Negative")) {
            System.out.println(-sum);
        } else {
            System.out.println(sum);
        }
    }
}
