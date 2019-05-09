/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ECC-912A
 */
public class TestShapes extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        demoText(stage);
        demoLine(stage);
        demoPolygon(stage);
    }

    void demoText(Stage stage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Text text = new Text(10, 50, "Hello Java");
        text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 20));
        text.setFill(Color.RED);
        pane.getChildren().add(text);

        Scene scene = new Scene(pane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    void demoLine(Stage stage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Line line1 = new Line(10, 10, 250, 250);
        line1.setStroke(Color.RED);
        Line line2 = new Line(250, 10, 10, 250);
        line2.setStroke(Color.BLUE);
        pane.getChildren().addAll(line1, line2);

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    void demoPolygon(Stage stage) {
        Pane pane = new Pane();
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLUE);
        pane.getChildren().add(polygon);
        ObservableList<Double> list = polygon.getPoints();
        double centerX = 200 / 2, centerY = 200 / 2;
        double radius = Math.min(200, 200) * 0.4;
        for (int i = 0; i < 6; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
        }

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
