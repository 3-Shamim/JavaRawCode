/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing_canvas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author MD SHAMIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas drawingCanvas;
    private GraphicsContext gc;

    private void GridDrawing() {
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.LIGHTGRAY);
        double width = drawingCanvas.getWidth();
        double height = drawingCanvas.getHeight();
        double dx = 20;
        double dy = 20;
        int p = 0;
        int q = 0;

        for (double x = 0; x <= width; x += dx) {
            p += 1;
            gc.strokeLine(x, 0, x, height);
            if (p % 5 == 0) {
                gc.setStroke(Color.BLACK);
            } else {
                gc.setStroke(Color.LIGHTGRAY);
            }
        }

        for (double x = 0; x <= width; x += dy) {
            q += 1;
            gc.strokeLine(0, x, width, x);
            if (q % 5 == 0) {
                gc.setStroke(Color.BLACK);
            } else {
                gc.setStroke(Color.LIGHTGRAY);
            }
        }

    }

    private void RectDrawing() {
        double height = drawingCanvas.getHeight();
        double width = drawingCanvas.getWidth();
        double x = 50;
        double y = 50;
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeRect(width - 150, 0, 150, 100);
        gc.strokeRect(width / 2 - 150 / 2, height / 2 - 150 / 2, 150, 150);
    }

    private void ovalDrawing() {
        gc = drawingCanvas.getGraphicsContext2D();
        double height = drawingCanvas.getHeight();
        double width = drawingCanvas.getWidth();
        double x = 50;
        double y = 50;
        for (int redius = 100; redius >= 20; redius -= 20, x += 20, y += 20) {
            gc.strokeOval(x, y, 2 * redius, 2 * redius);
        }
    }

    private void drawRegularNGons() {
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setFill(Color.YELLOW);
        gc.setLineWidth(5);
        

        double r = 200;
        double theta;

        for (theta = 0; theta <= 360; theta += 20) {
            double x1 = 0;
            double y1 = 0;
            double x2 = r * Math.cos(theta * Math.PI / 180.0);
            double y2 = r * Math.sin(theta * Math.PI / 180.0);

            double w = drawingCanvas.getWidth();
            double h = drawingCanvas.getHeight();
            gc.strokeLine(x1 + w / 2, -y1 + h / 2, x2 + w / 2, -y2 + h / 2);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        GridDrawing();
//        RectDrawing();
        gc.setStroke(Color.BLUE);
//        ovalDrawing();
//        drawRegularNGons();
        
        BD_Flag();
    }

    private void BD_Flag() {
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setLineWidth(5);
        gc.setFill(Color.GREEN);
        gc.fillRect(100, 100, 400, 200);
        gc.setFill(Color.RED);
        gc.fillOval(100 + 400/2 - 75, 100 + 200/2 - 75, 150, 150);
    }

}
