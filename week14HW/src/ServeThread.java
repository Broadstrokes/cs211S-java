import java.util.concurrent.BlockingQueue;

public class ServeThread implements Runnable {
    private int numItemsToServe;
    private BlockingQueue<Food> queue;
    private int numServed = 0;


    public ServeThread(BlockingQueue<Food> queue, int numItemsToServe) {
        this.queue = queue;
        this.numItemsToServe = numItemsToServe;
    }

    @Override
    public void run() {
        while (numServed < numItemsToServe) {
            try {
                System.out.println("SERVER READY");
                Food order = queue.take();
                System.out.println("SERVER STARTING: " + order.toString());
                Thread.sleep(order.getServeTime() * 1000);
                System.out.println("SERVER ENDING: " + order.toString());
                numServed++;
            } catch (InterruptedException ex) {}
        }
    }
}
