/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageview;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView ImageView;
    @FXML
    private JFXTextArea TextArea;
    @FXML
    private JFXTextField idField;
    @FXML
    private TableView<SimpleClass> tableView;
    @FXML
    private TableColumn<SimpleClass, Number> idCol;
    @FXML
    private TableColumn<SimpleClass, Image> imgCol;

    private FileChooser fileChooser;
    private File file;
    private Image image;
    private String path;
    private FileInputStream fin;
    private DataBaseHandler db;
    private ResultSet rs;
    private ObservableList<SimpleClass> list;

    private void setTable() {
        try {
            db = new DataBaseHandler();
            list = FXCollections.observableArrayList();
            String qu = "SELECT * FROM `img`";
            rs = db.execQuery(qu);
            while (rs.next()) {
                InputStream is = new ByteArrayInputStream(rs.getBytes("image"));
                Image img = new Image(is);
                ImageView imageView = new ImageView(img);
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                int id = rs.getInt("ID");
                SimpleClass s = new SimpleClass(imageView, id);
                list.add(s);
            }
            tableView.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        tableView.getSelectionModel().selectFirst();
        idCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
//        imgCol.setCellValueFactory(data -> new PropertyValueFactory<>(data.getValue().getImage()));
        imgCol.setCellValueFactory(new PropertyValueFactory<>("Image"));
        imgCol.setPrefWidth(100);
    }

    @FXML
    private void AttachButton(ActionEvent event) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.mp3", "*.wav", "*.acc"),
                new ExtensionFilter("All Files", "*.*"),
                new ExtensionFilter("Text Files", "*.txt")
        );

        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            path = file.getAbsolutePath();
            TextArea.setText(path);
            image = new Image(file.toURI().toString(), 100, 150, true, true);
            ImageView.setFitWidth(100);
            ImageView.setFitHeight(150);
            ImageView.setImage(image);
        }

        // Multiple file Chooser
        /*List fileList = fileChooser.showOpenMultipleDialog(null);
        if(file != null)
        {
            
        }*/
    }

    @FXML
    private void submitButton(ActionEvent event) {
        try {
            db = new DataBaseHandler();

            if (ImageView.getImage() != null) {
                String qu = "INSERT INTO `img`(`ID`, `image`) VALUES (?,?)";

                int id = Integer.parseInt(idField.getText());
                fin = new FileInputStream(file);
                if (db.execActionAll(qu, id, fin, file)) {
                    System.out.println("Success");
                    ImageView.setImage(null);
                }
            } else {
                System.out.println("Attach your Image !");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showButton(ActionEvent event) {
        try {
            db = new DataBaseHandler();
            int id = Integer.parseInt(idField.getText());
            String qu = "select *from img WHERE id = '" + id + "' ";
            rs = db.execQuery(qu);

            if (rs.next()) {
                InputStream input = new ByteArrayInputStream(rs.getBytes("image"));
                Image imge = new Image(input);
                ImageView.setImage(imge);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void itemClickedAction(MouseEvent event) {
        int index = tableView.getSelectionModel().getSelectedIndex();
        ImageView img = list.get(index).getImage();
        Image imge = img.getImage();
        ImageView.setImage(imge);
    }
}
