import java.util.ArrayList;
import java.util.List;

public class ListTester {
    public static void main(String[] args) {
        List<EvictionNotice> evictionNoticeList = generateListFromFile();
    }

    private static List<EvictionNotice> generateListFromFile() {
        List<EvictionNotice> evictionNoticeList = new ArrayList<EvictionNotice>();
        // WRITE LOGIC
        return evictionNoticeList;
    }

    /*
        HELPER FUNCTIONS
     */


    public static void println(Object line) { System.out.println(line); }

    public static void print(Object line) { System.out.print(line); }

    public static void printDashes() { println("----------------------------"); }

    public static void printNameOfCurrMethod() {
        String nameOfCurrMethod =
                new Throwable()
                        .getStackTrace()[1]
                        .getMethodName();

        println("*********** Running: " + nameOfCurrMethod + " **************");
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
}
