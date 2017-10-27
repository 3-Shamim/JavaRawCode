package DB_Connector;

import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author MD SHAMIM
 */
public final class DataBaseHandler {

    private Connection con;
    protected Statement st;
    private ResultSet rs;
            
    public DataBaseHandler() {
        createConnection();
    }

    void createConnection() 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/computerShop";
            con = DriverManager.getConnection(url,user,pass);
        } 
        catch (Exception ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("DataBase Connection Error!");
            alert.setContentText(ex + "");
            alert.showAndWait();
        } 
    }
    
    public ResultSet execQuery(String query)
    {
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(query);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
        return rs;
    }
    
    public boolean execAction(String qu)
    {
        try
        {
            st = con.createStatement();
            st.executeUpdate(qu);
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        } 
    }
    

    }
