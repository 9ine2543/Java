package LabJavaFX;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Exercise16_13 extends Application {

    private double paneWidth = 500;
    private double paneHeight = 250;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        TextArea taTable = new TextArea();
        pane.setCenter(new ScrollPane(taTable));

        TextField tfLoanAmount = new TextField();
        tfLoanAmount.setPrefColumnCount(7);
        TextField tfNumberOfYears = new TextField();
        tfNumberOfYears.setPrefColumnCount(2);
        Button btShowTable = new Button("Show Table");
        Button btSave = new Button("Save");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Loan Amount"),
                tfLoanAmount, new Label("Number of Years"),
                tfNumberOfYears, btShowTable);
        HBox hBox2 = new HBox(10);
        hBox2.getChildren().add(btSave);
        hBox.setAlignment(Pos.CENTER);
        pane.setTop(hBox);
        pane.setBottom(hBox2);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, paneWidth, paneHeight);
        primaryStage.setTitle("Loan GUI"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        Text sample = new Text("test");
        sample.setFont(new Font(14));
        
        btShowTable.setOnAction(e -> {
            double loanAmount = Double.parseDouble(
                    tfLoanAmount.getText().trim());
            int numOfYears = Integer.parseInt(
                    tfNumberOfYears.getText().trim());
            Loan loan = new Loan();
            loan.setLoanAmount(loanAmount);
            loan.setNumberOfYears(numOfYears);

            taTable.setText("Interest Rate\tMonthly Payment\tTotal Payment\n");

            for (double rate = 5; rate <= 10; rate += 1 / 4.0) {
                loan.setAnnualInterestRate(rate);
                taTable.appendText(rate + "\t\t\t"
                        + (int) (loan.getMonthlyPayment() * 100) / 100.0
                        + "\t\t\t" + (int) (loan.getTotalPayment() * 100) / 100.0 + "\n");
            }
        });
        
        btSave.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
 
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
 
            //Show save file dialog
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                saveTextToFile(taTable.getText(), file);
            }
        });
        
        
    }
    
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
