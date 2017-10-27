/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author MD SHAMIM
 */
public final class DataBaseHandler {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DataBaseHandler() {
        createConnection();
    }

    void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/computerShop";
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("DataBase Connection Error!");
            alert.setContentText(ex + "");
            alert.showAndWait();
        }
    }

    public ResultSet execQuery(String query) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("DataBase Error!");
            alert.setContentText(ex + "");
            alert.showAndWait();
            return null;
        }
        return rs;
    }

    public boolean execAction(String query) {
        try {
            st = con.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("DataBase Error!");
            alert.setContentText(ex + "");
            alert.showAndWait();
            return false;
        } finally {
        }
    }
}
