import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class M4Practice extends Application {
    // Control instance variables
    private Button button;
    private Text helloText;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Group root = new Group();

        // Pane is a way to organize - FlowPane organizes one after another
        // Pane can serve as a root node
        Pane pane = new FlowPane();

        helloText = new Text("Hello world!!");
        helloText.setFont(Font.font("Times New Roman", 20));
        helloText.setFill(Color.RED);
        pane.getChildren().add(helloText);

        button = new Button("Click here");
        button.setOnAction(this::handleButton);

        pane.getChildren().add(button);


        Scene scene = new Scene(pane, 300, 300, Color.BEIGE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Title");
        primaryStage.show();

    }

    private void handleButton(ActionEvent event) {
        helloText.setText("Hello universe!!!");
    }

    public static void main(String[] args) { launch(args); }
}