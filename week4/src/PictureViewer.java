import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PictureViewer extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Pane
        VBox primaryBox = new VBox();
        // Get image
        Image beeImage = new Image("bee.jpg");
        // Provide image to ImageView class
        ImageView beeImageView = new ImageView(beeImage);
        // Add ImageView instance to the pane instance
        primaryBox.getChildren().add(beeImageView);


        // Scene using the pane as root node
        Scene scene = new Scene(primaryBox, 500, 400, Color.LIGHTGRAY);

        // Set title for the primaryStage
        primaryStage.setTitle("Bee");
        // Set scene on the primaryStage
        primaryStage.setScene(scene);
        // Show primaryStage
        primaryStage.show();

    }


    // launcher
    public static void main(String[] args) { launch(args); }
}
