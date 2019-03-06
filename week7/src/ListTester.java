import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ListTester {
    public static void main(String[] args) {
        List<EvictionNotice> evictionNoticeList = generateListFromFile();
    }

    private static List<EvictionNotice> generateListFromFile() {
        List<EvictionNotice> evictionNoticeList = new ArrayList<EvictionNotice>();

        try(Scanner fileScan = new Scanner(new FileReader(new File("resources/data2.csv")))) {
            String line = fileScan.nextLine(); // read column headers


            try {
                while (fileScan.hasNextLine()) {
                    line = fileScan.nextLine();
                    String[] lineArray = line.split(",", -1); // pass in -1 to capture railing empty strings

                    String id = isBlank(lineArray[0]);
                    String zip = isBlank(lineArray[1]);
                    String fileDate = isBlank(lineArray[2]);
                    String illegalUse = isBlank(lineArray[3]);
                    String neighborhood = isBlank(lineArray[4]);

                    println(id + " | " +  zip + " | " + fileDate + " | " + illegalUse + " | " +  neighborhood);
                }
            } catch (Exception e) {
                println(">>>> Couldnt parse data ");
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return evictionNoticeList;
    }

    /*
        HELPER FUNCTIONS
     */



    public static String isBlank(String str) {
        if (str == null || (str.length() == 0)) { str = "NA"; }
        return str;
    }


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
