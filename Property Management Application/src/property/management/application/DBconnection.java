package property.management.application;

import java.sql.*;

/**
 *
 * @author MD SHAMIM
 */
public class DBconnection {
    
    private Connection con;
    protected Statement st;
    protected ResultSet rs;
    
    public DBconnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/PropertyManagementSystem";
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
