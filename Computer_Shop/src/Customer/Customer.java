/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

/**
 *
 * @author MD SHAMIM
 */
public class Customer {
    private final String userName;
    private final String fullName;
    private final String phoneNumber;
    private final String Email;
    private final String Passward;
    private final String Gender;

    public Customer(String userName, String fullName, String phoneNumber, String Email, String Passward, String Gender) {
        this.userName = userName;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
        this.Passward = Passward;
        this.Gender = Gender;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassward() {
        return Passward;
    }

    public String getGender() {
        return Gender;
    }
    
}
