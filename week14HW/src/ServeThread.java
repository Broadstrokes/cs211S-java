import java.util.concurrent.BlockingQueue;

public class ServeThread implements Runnable {
    private int numServed = 0;
    private BlockingQueue<Food> queue;

    public ServeThread(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (numServed < 8) {
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
