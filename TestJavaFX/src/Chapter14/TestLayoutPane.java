/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author PKB
 */
public class TestLayoutPane extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        demoFlowPane(stage);
        demoGridPane(stage);
        borderPane(stage);
    }

    void demoFlowPane(Stage stage) {
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(new Label("JavaFX programming"));
        Scene scene = new Scene(pane, 250, 200);
        stage.setScene(scene);
        stage.show();
    }

    void demoGridPane(Stage stage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(15);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.add(new Label("Somsak"), 0, 0);
        pane.add(new Label("Walairacht"), 1, 0);
        pane.add(new Button("Hello"), 0, 1);
        pane.add(new Button("Bye"), 1, 1);
        Scene scene = new Scene(pane, 250, 200);
        stage.setScene(scene);
        stage.show();
    }

    void borderPane(Stage stage) {
        BorderPane pane = new BorderPane();
        pane.setTop(getTopHBox());
        pane.setRight(getRightVBox());
        pane.setBottom(new CustomPane("Bottom"));
        pane.setLeft(new CustomPane("Left"));
        pane.setCenter(new CustomPane("Center"));
        Scene scene = new Scene(pane, 350, 300);
        stage.setScene(scene);
        stage.show();
    }

    HBox getTopHBox() {
        HBox hBox = new HBox(30);
        hBox.getChildren().add(new Label("Mathematics"));
        hBox.getChildren().add(new Label("Programming"));
        hBox.getChildren().add(new Label("Chemistry"));
        return hBox;
    }

    VBox getRightVBox() {
        VBox vBox = new VBox(20);
        RadioButton hello = new RadioButton("Hello");
        RadioButton bye = new RadioButton("Bye");
        vBox.getChildren().addAll(hello, bye);
        ToggleGroup group = new ToggleGroup();
        hello.setToggleGroup(group);
        bye.setToggleGroup(group);
        return vBox;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

class CustomPane extends StackPane {

    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setPadding(new Insets(20, 20, 20, 20));
        setAlignment(Pos.CENTER);
    }

}
