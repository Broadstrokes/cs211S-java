import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CookThread implements Runnable {
    List<Food> foodList;

    private BlockingQueue<Food> queue;


    public CookThread(List<Food> foodList, BlockingQueue queue) {
        this.foodList = foodList;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(!foodList.isEmpty()) {
            try {
                Food order = foodList.remove(0);
                System.out.println("COOK READY");
                System.out.println("COOK STARTING: " + order.toString());
                Thread.sleep(order.getCookTime() * 1000);
                queue.put(order);
                System.out.println("COOK ENDING: " + order.toString());
            } catch (InterruptedException ex) { }
        }
    }
}
