import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PictureViewer extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Pane
        VBox primaryBox = new VBox();

        // Scene using the pane as root node
        Scene scene = new Scene(primaryBox, 500, 500, Color.LIGHTGRAY);

        // Set title for the primaryStage
        primaryStage.setTitle("Batman");
        // Set scene on the primaryStage
        primaryStage.setScene(scene);
        // Show primaryStage
        primaryStage.show();

    }


    // launcher
    public static void main(String[] args) { launch(args); }
}
