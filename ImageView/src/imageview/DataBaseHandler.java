package imageview;

import java.io.File;
import java.io.InputStream;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author MD SHAMIM
 */
public final class DataBaseHandler {

    protected Connection con;
    protected Statement st;
    private ResultSet rs;

    public DataBaseHandler() {
        createConnection();
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/image1";
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

    public boolean execActionAll(String qu,int id,InputStream fin, File file) {
        try {
            PreparedStatement pst = con.prepareStatement(qu);
            pst.setInt(1, id);
            pst.setBinaryStream(2, (InputStream) fin, (int) file.length());
            pst.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

}
