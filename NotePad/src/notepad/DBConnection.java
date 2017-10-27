package notepad;

import java.sql.*;


/**
 *
 * @author MD SHAMIM
 */
public class DBConnection {
    protected Connection con;
    protected Statement st;
    public DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javaproperty";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();  
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
