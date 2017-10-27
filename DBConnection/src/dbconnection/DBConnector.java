package dbconnection;

import java.sql.*;

/**
 *
 * @author MD SHAMIM
 */
public class DBConnector {
    private  Connection con;
    private  Statement st;
    private  ResultSet rs;
    
    public DBConnector()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/javaproperty";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public void getData()
    {
        try
        {
            String query = "select *from shamim";
            rs = st.executeQuery(query);
            System.out.println("Read from Database: ");
            while(rs.next())
            {
                String name = rs.getString("Name");
                String text = rs.getString("Text");
                String id = rs.getString("Id");
                System.out.println(name + " " + text + " " + id);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
