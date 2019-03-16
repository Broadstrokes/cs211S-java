import java.util.*;

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

    /**
     * Adds an item of type T to the RandomBox
     * @param newItem items to add to the box; can contain duplicates
     */
    public void addItem(T newItem) {
        listOfRandomItems.add(newItem);
    }

    /**
     * Select & return a random item of type T from the RandomBox list
     * @return return a random item of type T from the RandomBox list or null if list is empty
     */
    public T drawWinner() {
        Random random = new Random();

        if (listOfRandomItems.size() > 0) {
            return listOfRandomItems.get(random.nextInt(listOfRandomItems.size()));
        }

        return null;
    }

    /**
     * Displays all the entries in the list
     */
    public void displayEntries() {
        System.out.println("===== Displaying entries =====");
        listOfRandomItems.forEach(item -> System.out.println(item));
        System.out.println("===== End of entries =====");
    }

    /**
     * Return the number of items in the list
     * @return Return the number of items in the list
     */
    public int size () {
        return listOfRandomItems.size();
    }

    /**
     * Retrieve the list of items
     * @return list containing all the items
     */
    public List<T> getListOfRandomItems() {
        return listOfRandomItems;
    }

    /*
        Overrides
     */

    @Override
    public String toString() {
        return "RandomBox{" + "listOfRandomItems=" + listOfRandomItems + '}';
    }
}
