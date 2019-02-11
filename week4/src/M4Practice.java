import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class M4Practice extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Group root = new Group();

        // Pane is a way to organize - FlowPane organizes one after another
        // Pane can serve as a root node
        Pane pane = new FlowPane();

        Text helloText = new Text("Hello world!!");
        helloText.setFont(Font.font("Times New Roman", 20));
        helloText.setFill(Color.RED);
        pane.getChildren().add(helloText);

        Scene scene = new Scene(pane, 300, 300, Color.BEIGE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Title");
        primaryStage.show();

    }

    public static void main(String[] args) { launch(args); }
}