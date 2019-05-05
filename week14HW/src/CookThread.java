import java.util.LinkedList;
import java.util.List;

public class CookThread implements Runnable {
    List<Food> foodList;

    public CookThread(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
