package primenumber;

import java.util.Scanner;

/**
 *
 * @author MD SHAMIM
 */
public class PrimeNumber {

    public static void main(String[] args) {
        int num, i, ans = 0;
        Scanner S = new Scanner(System.in);
        System.out.print("Enter a Number: \n");
        num = S.nextInt();
        for (i = 2; i < num; i++) {
            if(num % i == 0)
            {
                ans++;
            }
        }
            if (ans == 0) 
            {
                System.out.print("This is a Prime Number. \n");
            } 
            else 
            {
                System.out.print("This is not a Prime Number. \n");
            }

    }
}
