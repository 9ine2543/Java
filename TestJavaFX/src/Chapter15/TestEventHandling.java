/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author ECC-912A
 */
public class TestEventHandling extends Application {

    CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().addAll(btEnlarge, btShrink);
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction(e->circlePane.shrink()); // Lambda Expression

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.enlarge();
        }
    }

//    class ShrinkHandler implements EventHandler<ActionEvent> {
//        @Override
//        public void handle(ActionEvent e) {
//            circlePane.shrink();
//        }
//    }

    public static void main(String[] args) {
        launch(args);
    }

}

class CirclePane extends StackPane {

    private Circle circle = new Circle(20);

    CirclePane() {
        circle.setFill(Color.GREEN);
        circle.setStroke(Color.BLUE);
        getChildren().add(circle);
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink() {
        circle.setRadius(circle.getRadius() - 2);
    }
}
