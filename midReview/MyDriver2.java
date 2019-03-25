import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class MyDriver1 {

    public static void main(String[] args) {
        println("=========== STARTING MY DRIVER 2 ============");
    }



    /*
        HELPER FUNCTIONS
     */


    /**
     * Test if a string is blank or null and return original string or "NA" if string is empty or null
     * @param str the string to test
     * @return original string or "NA" if string is empty or null
     */
    public static String isBlank(String str) {
        if (str == null || (str.length() == 0)) { str = "NA"; }
        return str;
    }

    public static void println(Object line) { System.out.println(line); }

    public static void print(Object line) { System.out.print(line); }

    public static void printDashes() { println("------------------------------------------------"); }
    public static void printDivider() { println("\n\n"); }

    public static void printNameOfCurrMethod() {
        String nameOfCurrMethod =
                new Throwable()
                        .getStackTrace()[1]
                        .getMethodName();
        printDivider();
        printDashes();
        println("*********** Running: " + nameOfCurrMethod + " **************");
        printDashes();
        printDivider();
    }

    /**
     * Function to test an expectation
     *
     * @param expression     Expectation/Expression to test, which returns a boolean
     * @param successMessage String to output to the user if the expectation is met
     * @param errorMessage   String to output to the user if the expectation is not met
     * @param should         String stating what should be tested
     */
    public static void test(boolean expression, String successMessage, String errorMessage, String should) {
        System.out.print(should + ": ");

        if (expression)
            System.out.println(successMessage);
        else
            System.out.println(errorMessage);
    }

    public static <T> void printAList(ListInterface<T> aList) {
        print("AList: [ ");
        for(int i = 1; i <= aList.getLength(); i++) {
            print(aList.getEntry(i));
            print(" ");
        }
        println("]");
    }

    /**
     * Loops over a list of nodes & prints the list
     * @param head first node
     */
    public static void loopOverList(Node head) {
        Node currentNode = head;
        String stringifiedList = "";

        while(currentNode != null) {
            stringifiedList += currentNode.data;
            if (currentNode.next != null) { stringifiedList+= "->"; }
            currentNode = currentNode.next;
        }

        println(stringifiedList);
    }

    /**
     * Generates a list of nodes
     * @param inputArray array of items to be added to the list
     * @return the first/head node
     */
    public static <T> Node generateList(T[] inputArray) {
        Node previousNode = null;

        for (int i = inputArray.length - 1; i >= 0; i--) {
//            println(">>> i: "  + i + " |  " + inputArray[i]);
            Node newNode = new Node(inputArray[i]);
            newNode.next = previousNode;
            previousNode = newNode;
        }

        return previousNode;
    }
}
