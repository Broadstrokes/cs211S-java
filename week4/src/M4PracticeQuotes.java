import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
    - Create a JavaFX GUI (without SceneBuilder) to display an inspirational quote.
    - Set either the color and/or the font of your quote.
    - Use at least one layout pane of your choice.
    - Bonus: Instead of displaying one quote, create a list of quotes and
    include a button. Randomly change the quote (and perhaps also the font!)
    when the user clicks the button.
 */


public class M4PracticeQuotes extends Application {
    // Control instance variables
    private Button changeQuote;
    private List<String> quotes = new ArrayList<>();
    private Text quote;

    @Override
    public void start(Stage primaryStage) throws Exception {

        addQuotesToArrayList(this.quotes);


        Pane gridPane = new GridPane();

        quote = new Text(quotes.get(0) + "\n");
        quote.setFont(Font.font("Times New Roman", 20));
        quote.setFill(Color.BLUEVIOLET);
        ((GridPane) gridPane).add(quote, 0, 0);

        changeQuote = new Button("Change quote");
        changeQuote.setOnAction(this::handleChangeQuoteButton);
        ((GridPane) gridPane).add(changeQuote, 0,1);

        Scene scene = new Scene(gridPane, 500, 100, Color.BEIGE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Quotes");
        primaryStage.show();

    }

    private void handleChangeQuoteButton(ActionEvent event) {
        Random rand = new Random();
        String randomQuote = quotes.get(rand.nextInt(quotes.size())) + "\n";
        quote.setText(randomQuote);
    }

    private static void addQuotesToArrayList(List<String> quotes) {
        quotes.add("You must be the change you wish to see in the world.");
        quotes.add("He who fears he will suffer, already suffers because he fears.");
        quotes.add("Broken crayons still color.");
        quotes.add("And so the adventure begins.");
        quotes.add("If you want it, work for it.");
        quotes.add("You can if you think you can. George Reeves");
        quotes.add("Whatever you are, be a good one. Abraham Lincoln");
        quotes.add("Impossible is for the unwilling. John Keats");
        quotes.add("Grow through what you go through.");
    }

    public static void main(String[] args) { launch(args); }
}