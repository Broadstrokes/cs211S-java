import javafx.scene.shape.Line;
@FunctionalInterface
public interface DisplayLineInfo {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ, IS_A_LINE;
    }

    public static DisplayLineInfo createDisplayLineInfo(InfoType type) {
        switch (type) {
            case DISTANCE: return (Line line) -> {
                String output = "";

                if (line != null) {
                    double x1 = line.getStartX();
                    double y1 = line.getStartY();
                    double x2 = line.getEndX();
                    double y2 = line.getEndY();

                    double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

                    output = String.format("%.1f", distance);
                }

                return output;
            };
            case MIDPOINT: return (Line line) -> {
                String output = "";

                if (line != null) {
                    double x1 = line.getStartX();
                    double x2 = line.getEndX();
                    double y1 = line.getStartY();
                    double y2 = line.getEndY();
                    output = "(" + (x1 + x2) / 2 + ", " + (y1 + y2) / 2 + ")";
                }

                return output;
            };
            case VERTHORZ: return (Line line) -> {
                String output = "";

                if (line != null) {

                    double x1 = line.getStartX();
                    double x2 = line.getEndX();
                    double y1 = line.getStartY();
                    double y2 = line.getEndY();

                    boolean isVertical = (x1 == x2);
                    boolean isHorizontal = (y1 == y2);

                    output = "Vertical: " + isVertical + " | Horizontal: " + isHorizontal;
                }

                return output;
            };

            case IS_A_LINE: return (Line line) -> {
                String output = "";

                if (line != null) {
                    double x1 = line.getStartX();
                    double x2 = line.getEndX();
                    double y1 = line.getStartY();
                    double y2 = line.getEndY();

                    boolean isALine = (x1 != x2) || (y1 != y2);

                    output = Boolean.toString(isALine);
                }
                return output;
            };
        }

        return null;
    }

}
