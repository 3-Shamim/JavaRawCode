package bankaccount;
/**
 *
 * @author Md Shamim
 */
public class BankAccount_Class {
    private String accountName;
    private String accountNumber;
    private String address;
    double balance;
    void WithDraw(int amount)
    {
        balance -= amount;
    }
    void diposit(int amount)
    {
        balance += amount;
    }
    double getBalance()
    {
        return balance;
    }
}
