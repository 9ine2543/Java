/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ECC-912A
 */
public class TestUIControls extends Application {

    protected Text text = new Text(10,10,"");
    BorderPane pane = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(getPane(), 450, 200);
        stage.setScene(scene);
        stage.show();
    }

    protected BorderPane getPane() {
        textField();
        text();
        checkBox();
        button();
        radioButton();
        return pane;
    }

    void text() {
        Pane textPane = new Pane();
        textPane.setStyle("-fx-border-color: green");
        textPane.getChildren().add(text);
        pane.setCenter(textPane);
    }

    void button() {
        HBox hBox = new HBox(10);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-border-color: red");
        hBox.getChildren().addAll(btLeft, btRight);
        btLeft.setOnAction(e -> text.setX(text.getX() - 2));
        btRight.setOnAction(e -> text.setX(text.getX() + 2));
        pane.setBottom(hBox);
    }

    void checkBox() {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setStyle("-fx-border-color: blue");
        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");
        vBox.getChildren().addAll(chkBold, chkItalic);
        pane.setLeft(vBox);
    }

    void textField() {
        BorderPane paneText = new BorderPane();
        paneText.setPadding(new Insets(5, 5, 5, 5));
        paneText.setLeft(new Label("Enter text:  "));
        paneText.setStyle("-fx-border-color: violet");
        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_LEFT);
        tf.setOnAction(e->text.setText(tf.getText()));
        paneText.setCenter(tf);
        pane.setTop(paneText);

    }

    void radioButton() {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setStyle("-fx-border-color: blue");
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        vBox.getChildren().addAll(rbRed, rbGreen, rbBlue);
        pane.setRight(vBox);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
