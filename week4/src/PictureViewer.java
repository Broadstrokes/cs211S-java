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
        // Center the image
        primaryBox.setAlignment(Pos.CENTER);



        // Get image
//        Image beeImage = new Image("bee.jpg");
        Image beeImage = new Image("bee.jpg", 500, 400, true, false);

        // Provide image to ImageView class
        ImageView beeImageView = new ImageView(beeImage);
        // Add ImageView instance to the pane instance
        primaryBox.getChildren().add(beeImageView);


        // Add text describing the object
        Text beeDescription = new Text("Bright yellow");
        // Change font & size of text
        beeDescription.setFont(Font.font("Times New Roman", 20));
        // Add text to scene graph
        primaryBox.getChildren().add(beeDescription);


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
