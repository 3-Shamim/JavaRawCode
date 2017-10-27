/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtoint;

import java.util.Scanner;

/**
 *
 * @author Md Shamim
 */
public class StringToInt {

    static boolean YesOrNot(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        String ask = "YES";
        int m = 0, j = 1;

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        if (YesOrNot(str)) {
            for (int i = str.length() - 1; i >= 0; i--) {
                m = m + ((str.charAt(i) - 48) * j);
                j = j * 10;
            }
            System.out.println(m);
        } else {
            System.out.println("It's not a digits.");
        }

//        for(int i=0; i<str.length(); i++)
//        {
//            if(!Character.isDigit(str.charAt(i)))
//            {
//                ask = "NOT";
//            }
//        }
//        
//        if(ask.equals("YES"))
//        {
//            for(int i = str.length()-1; i >= 0; i--)
//            {
//                m = m + ((str.charAt(i) - 48) * k );
//                k = k * 10;
//            }
//            System.out.println(m);
//        }
//        else 
//        {
//            System.out.println("It's not integer digits.");
//        }
    }

}
