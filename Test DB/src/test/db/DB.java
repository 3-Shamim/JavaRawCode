package test.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MD SHAMIM
 */
public class DB {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String dbName = "Student2";

    public DB() {
        createConnection();
        setupStudentTable();
    }

    private void createConnection() {
        
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","");
            st = con.createStatement();
//            int Result = st.executeUpdate("CREATE DATABASE " + dbName);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

private void setupStudentTable() {
        String TABLE_NAME = "STUDENT";
        try {
            st = con.createStatement();

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
            } else {
                st.execute("CREATE TABLE " + TABLE_NAME + "(id int primary key, name varchar(200))");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } 
}

}
