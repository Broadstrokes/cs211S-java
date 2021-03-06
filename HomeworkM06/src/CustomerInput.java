import java.io.*;
import java.util.*;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class CustomerInput extends Application {

    private Stage primaryStage;
    private Text statusText, resultText;
    private Button uploadButton;

    private final static Font RESULT_FONT = Font.font("Helvetica", 24);
    private final static Font INPUT_FONT = Font.font("Helvetica", 20);

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        VBox uploadBox = new VBox();
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setSpacing(20);
        Text uploadLabel = new Text("Upload a comma-separated file with customer data.");
        uploadLabel.setFont(INPUT_FONT);
        uploadButton = new Button("Upload data");
        uploadButton.setOnAction(this::processDataUpload);

        uploadBox.getChildren().add(uploadLabel);
        uploadBox.getChildren().add(uploadButton);
        primaryBox.getChildren().add(uploadBox);

        VBox resultsBox = new VBox();
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setSpacing(20);
        statusText = new Text("");
        statusText.setVisible(false);
        statusText.setFont(RESULT_FONT);
        statusText.setFill(Color.RED);
        resultText = new Text("");
        resultText.setVisible(false);
        resultText.setFont(RESULT_FONT);
        resultsBox.getChildren().add(statusText);
        resultsBox.getChildren().add(resultText);
        primaryBox.getChildren().add(resultsBox);

        Scene scene = new Scene(primaryBox, 475, 200, Color.TRANSPARENT);
        primaryStage.setTitle("Customer Data Upload");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void processDataUpload(ActionEvent event) {
        statusText.setVisible(false);
        resultText.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        parseFile(file);

    }

    private void parseFile(File file) {
        Scanner fileScan = null;

        try {
            ArrayList<Customer> customers = new ArrayList<>();
            int totalNumOrder = 0;
            FileReader fileReader = new FileReader(file);
            fileScan = new Scanner(fileReader);

            try {
                while (fileScan.hasNext()) {
                    String line = fileScan.nextLine();
                    Scanner lineScan = new Scanner(line);
                    lineScan.useDelimiter(",");

                    while (lineScan.hasNext()) {
                        String id = lineScan.next();

                        if (id.contains("@")) {
                            throw new InvalidCustomerIdException();
                        }

                        int numOrders = Integer.parseInt(lineScan.next());
                        totalNumOrder += numOrders;

                        Customer customer = new Customer(id, numOrders);
                        customers.add(customer);

                        statusText.setText("Number of users created: "  + customers.size());
                        resultText.setText("Number of orders: "  + totalNumOrder);
                        uploadButton.setDisable(true);
                    }
                }
            } catch (NumberFormatException | InvalidCustomerIdException e) { // Situation 1 & 2
                if (e.getClass().getCanonicalName().equals( "java.lang.NumberFormatException")) {
                    statusText.setText("Number input is not of type integer.");
                } else if (e.getClass().getCanonicalName().equals("InvalidCustomerIdException")) {
                    statusText.setText("Customer id contains invalid character: @.");
                }
                e.printStackTrace();
                uploadButton.setDisable(false);
            } finally {
                statusText.setVisible(true);
                resultText.setVisible(true);
            }
        } catch (IOException e) { // Situation 3
            statusText.setText("Error reading file. Please try again.");
            e.printStackTrace();
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}