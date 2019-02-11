import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class M4Practice extends Application {
    // Control instance variables
    private Button button1;
    private Button button2;
    private Text helloText;
    private Text countText;
    private int count = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Group root = new Group();

        // Pane is a way to organize
        // FlowPane organizes one after another
        // TilePane laysout children in a grid of equally sized cells
        // Pane can serve as a root node


        Pane tilePane = new TilePane();

        helloText = new Text("Hello world!!");
        helloText.setFont(Font.font("Times New Roman", 20));
        helloText.setFill(Color.RED);
        tilePane.getChildren().add(helloText);


        button1 = new Button("Click here to change text");
        button1.setOnAction(this::handleButton1);
        tilePane.getChildren().add(button1);


        countText = new Text(String.valueOf(this.count));
        countText.setFill(Color.GREEN);
        tilePane.getChildren().add(countText);

        button2 = new Button("Click to increment counter");
        button2.setOnAction(this::handleButton2);
        tilePane.getChildren().add(button2);

        Scene scene = new Scene(tilePane, 300, 300, Color.BEIGE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Title");
        primaryStage.show();

    }

    private void handleButton1(ActionEvent event) {
        helloText.setText("Hello universe!!!");
    }

    private void handleButton2(ActionEvent event) {
        this.count++;
        countText.setText(String.valueOf(count));
    }

    public static void main(String[] args) { launch(args); }
}