package string.todouble;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Md Shamim
 */

public class StringToDouble {

    static String sInput = "", s1Input = "", s2Input = "", operation = "";
    static int sum1 = 0;
    static double sum = 0, subsum1 = 0;
    
    static boolean isWithDot(String input)
    {
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == '.')
            {
                s1Input = input.substring(0,i);
                s2Input = input.substring(i+1,input.length());
                sInput = s1Input + s2Input;
                return true;
            }
        }
        return false;
    }
    
    static double covertStringToDouble(String input)
    {
        if(isWithDot(input))
        {
            for(int i = 0; i < sInput.length(); i++)
            {
                subsum1 = subsum1 * 10 + (sInput.charAt(i) - 48);
            }
            sum = subsum1 * Math.pow(10, -s2Input.length());
            operation = "yesDot";
        }
        else
        {
            for(int i = 0; i < input.length(); i++)
            {
                sum = sum * 10 + (input.charAt(i) - 48);
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        
        DecimalFormat precision = new DecimalFormat("0.00");
        
        Scanner str = new Scanner(System.in);
        
        String input = str.nextLine();

          double x = covertStringToDouble(input);
          {
              if(operation.equals("yesDot"))
              {
                  System.out.println(precision.format(sum));
                  System.out.println(sum);
              }
              else
              {
                  sum1 = (int)sum;
                  System.out.println(sum1);
              }
          } 
    }
}
