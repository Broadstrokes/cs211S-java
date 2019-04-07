import javafx.scene.shape.Line;
@FunctionalInterface
public interface DisplayLineInfo {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ;
    }

    public static DisplayLineInfo createDisplayLineInfo(InfoType type) {
        //  YOUR CODE HERE!
        return null;
      
    }

}
