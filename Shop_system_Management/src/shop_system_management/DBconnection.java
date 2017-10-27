package shop_system_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author MD SHAMIM
 */
public class DBconnection {
    protected Connection con;
    protected Statement st;
    protected ResultSet rs;
    
    public DBconnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gameshop_management";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
