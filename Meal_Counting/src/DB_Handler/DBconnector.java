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

    public ResultSet execQuery(String qu) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(qu);
        } catch (Exception ex) {
            System.out.println(ex);
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
            System.out.println(ex);
            return false;
        }
    }

}
