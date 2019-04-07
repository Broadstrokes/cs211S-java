import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

import java.awt.event.ActionEvent;

public class LineGUI extends Application {

    private Pane pane;
    private BorderPane borderPane;
    private Circle startPoint, endPoint;
    private Line line;
    private Button distanceButton, midpointButton, vertHorzButton, isALineButton;
    private Text distanceText, midpointText, vertHorxText, isALineText;

    private static final int CIRCLE_RADIUS = 5;

    public void start(Stage primaryStage) {
        borderPane = new BorderPane();

        pane = new Pane();
        pane.setOnMouseClicked(this::handleMouseClicks);
        borderPane.setCenter(pane);
              
        distanceText = new Text("");
        distanceButton = new Button("Calculate Distance");
        distanceButton.setOnAction(evt -> {
            DisplayLineInfo distance = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.DISTANCE);
            distanceText.setText(distance.getInfo(line));
        });
        
        TilePane distancePane = new TilePane(distanceButton, distanceText);
        distancePane.setAlignment(Pos.CENTER);

        midpointText = new Text("");
        midpointButton = new Button("Calculate Midpoint");
        midpointButton.setOnAction(evt -> {
            DisplayLineInfo midpoint = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.MIDPOINT);
            midpointText.setText(midpoint.getInfo(line));
        });
        
        TilePane midpointPane = new TilePane(midpointButton, midpointText);
        midpointPane.setAlignment(Pos.CENTER);
        
        vertHorxText = new Text("");
        vertHorzButton = new Button("Determine Vertical/Horizontal");
        vertHorzButton.setOnAction(evt -> {
            DisplayLineInfo verticalOrHorizontal = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.VERTHORZ);
            vertHorxText.setText(verticalOrHorizontal.getInfo(line));
        });

        TilePane vertHorzPane = new TilePane(vertHorzButton, vertHorxText);
        vertHorzPane.setAlignment(Pos.CENTER);


        isALineText = new Text("");
        isALineButton = new Button("Is a line");
        isALineButton.setOnAction(evt -> {
            DisplayLineInfo isALine = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.IS_A_LINE);
            isALineText.setText(isALine.getInfo(line));
        });

        TilePane isALinePane = new TilePane(isALineButton, isALineText);
        isALinePane.setAlignment(Pos.CENTER);


        VBox controlBox = new VBox(distancePane,midpointPane,vertHorzPane, isALinePane);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setSpacing(10);
        borderPane.setBottom(controlBox);

        Scene scene = new Scene(borderPane, 500, 500, Color.WHITE);
        primaryStage.setTitle("Line Characteristics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMouseClicks(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if(startPoint==null ) { // no start point yet
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);
            addCoordinateString(x,y);
            line = null;
        } else if(endPoint==null) { // start point, but not end point yet
            endPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(endPoint);
            addCoordinateString(x,y);
            
            line = new Line(startPoint.getCenterX(), startPoint.getCenterY(), endPoint.getCenterX(), endPoint.getCenterY());
            pane.getChildren().add(line);
            
        } else { // startPoint != null && endPoint !=null
            // both start and end are there, so this is starting a new line

            // clear out everything from the last line
            pane.getChildren().clear();
            endPoint = null;
            line = null;
            distanceText.setText("");
            midpointText.setText(""); 
            vertHorxText.setText("");
            isALineText.setText("");

            // start the new line
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);        
            addCoordinateString(x,y);
        }

    }
    
    private void addCoordinateString(double x, double y) {
        String coordinateString = "(" + x + ", " + y + ")";
        Text coordinates = new Text(x-CIRCLE_RADIUS, y-CIRCLE_RADIUS-2, coordinateString);
        pane.getChildren().add(coordinates);
    }
  

    public static void main(String[] args) {
        launch(args);
    }

}
