/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Handler;

import java.sql.*;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Saurav
 */
public class DBconnector {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBconnector() {
        getConnection();
        setupMealTable();
        setupShopingTable();
    }

    private void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/meal";
            String userName = "root";
            String pass = "";

            con = DriverManager.getConnection(url, userName, pass);

        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Notification");
            alert.setHeaderText("Database Connection Error!");
            alert.setContentText("Maybe you forget to open Database ??");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        }
    }

    private void setupMealTable() {
        String TABLE_NAME = "meal";
        try {
            st = con.createStatement();

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toLowerCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
            } else {
//                Date 	Rony 	Shoton 	Shuvo 	Mijan
                st.executeUpdate("CREATE TABLE " + TABLE_NAME + "(Date varchar(300) primary key, "
                        + "Rony double,"
                        + "Shoton double,"
                        + "Shuvo double,"
                        + "Mijan double)");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage() + " --- setupDatabase");
        }
    }
    
    private void setupShopingTable()
    {
        String TableName = "shopping";
        try {
            st = con.createStatement();
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet table = dbm.getTables(null, null, TableName, null);
            if(table.next())
            {
                System.out.println("Table " + TableName + " already exists. Ready for go!");
            }
            else
            {
//                date 	amount 	person 
                st.executeUpdate("CREATE TABLE " + TableName + "(date varchar(300),"
                        + "amount double,"
                        + "person varchar(300))");
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage() + " --- setupDatabase");
        }
        
    }

    public ResultSet execQuery(String qu) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(qu);
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Notificition");
            alert.setHeaderText("Database problem !");
            alert.setContentText(ex + "");
            alert.showAndWait();
            return null;
        }
        return rs;
    }

    public boolean execAction(String qu) {
        try {
            st = con.createStatement();
            st.executeUpdate(qu);
            return true;
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Notificition");
            alert.setHeaderText("Database problem !");
            alert.setContentText(ex + "");
            alert.showAndWait();
            return false;
        }
    }

}
