package javawithdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MD SHAMIM
 */
public class JavaWithDataBase {
    
    public static Connection getconnetion() throws Exception
    {
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/javaproperty";
            String user = "root";
            String pass = "";
            Class.forName(driver);
            
            Connection con = DriverManager.getConnection(URL,user,pass);
            System.out.println("Connected");
            return con;
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex);
        }
        
        return null;
    }
    
    public static void main(String[] args) throws Exception {
        getconnetion();
    }
    
}
