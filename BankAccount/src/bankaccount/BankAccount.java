package bankaccount;

import java.util.Scanner;
/**
 *
 * @author Md Shamim
 */
public class BankAccount {

    public static void main(String[] args) {
        
        double Balance;
        BankAccount_Class object = new BankAccount_Class();
        Scanner Input = new Scanner(System.in);
        int Diposite = Input.nextInt();
        int WithDraw = Input.nextInt();
        object.diposit(Diposite);
        object.WithDraw(WithDraw);
        Balance = object.balance;
        System.out.println(Balance);
    }
    
}
