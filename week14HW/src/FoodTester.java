import java.util.*;
import java.util.concurrent.*;

public class FoodTester {

    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Spinach Dip", 2, 1));
        foodList.add(new Food("Burger", 5, 1));
        foodList.add(new Food("Pasta", 4, 3));
        foodList.add(new Food("Baked Alaska", 6, 20));
        foodList.add(new Food("Salad", 1, 1));
        foodList.add(new Food("Bruchetta", 3, 1));
        foodList.add(new Food("Bread", 1, 1));
        foodList.add(new Food("Fried Green Tomatoes", 2, 1));

        BlockingQueue<Food> queue = new ArrayBlockingQueue<>(3); // 1 would be analogous to the NumberBox example

        List<Food> foodListCopy = new ArrayList<>(foodList);

        // INITIALIZE AND START YOUR THREADS HERE!
        Thread cooker = new Thread(new CookThread(foodList, queue));
        Thread server = new Thread(new ServeThread(queue));

        cooker.start();
        server.start();

        int programTimeCounter = 0;
        while (Thread.activeCount() > 2) {
            System.out.println("TIME " + programTimeCounter);

            programTimeCounter++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
        }


        // USE STREAMS HERE ON THE INITIAL LIST!
        // NOTE: THIS PART HAS NOTHING TO DO WITH THE THREADS- JUST MORE STREAM PRACTICE! :)
        // USE METHOD REFERENCES!
        int totalCookTime = -1;
        int totalServeTime = -1;
        System.out.println("Total Cook Time = " + foodListCopy.stream().mapToInt(Food::getCookTime).sum());
        System.out.println("Total Serve Time = " + foodListCopy.stream().mapToInt(Food::getServeTime).sum());
        System.out.println("Program Time = " + programTimeCounter);

    }

}
