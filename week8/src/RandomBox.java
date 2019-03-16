import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBox <T> {
    List<T> listOfRandomItems;

    /*
        Constructors
     */

    public RandomBox() {
        listOfRandomItems = new ArrayList<>();
    }

    public RandomBox(List<T> listOfRandomItems) {
        this.listOfRandomItems = listOfRandomItems;
    }

    /*
        Member Methods
     */

    public void addItem(T newItem) {
        listOfRandomItems.add(newItem);
    }

    public T drawWinner() {
        Random random = new Random();
        return listOfRandomItems.get(random.nextInt(listOfRandomItems.size()));
    }

    public void displayEntries() {
        System.out.println("===== Displaying entries =====");
        listOfRandomItems.forEach(item -> System.out.println(item));
        System.out.println("===== End of entries =====");
    }

    /*
        Overrides
     */

    @Override
    public String toString() {
        return "RandomBox{" + "listOfRandomItems=" + listOfRandomItems + '}';
    }
}
