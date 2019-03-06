import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@SuppressWarnings("Duplicates")
public class MapTester {
    public static void main(String[] args) {
        Map<String, EvictionNotice> evictionNoticeMap = generateMapFromFile();

        println("Number of eviction records in the map: " + evictionNoticeMap.size());



        /*  COMMENT OUT TO PRINT CONTENTS OF evictionNoticeMap

        for (Map.Entry<String, EvictionNotice> entry : evictionNoticeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }

        */
    }

    /**
     * Create a hashmap of eviction notices from a csv file
     * @return HashMap holding EvictionNotice objects
     */
    private static Map<String, EvictionNotice> generateMapFromFile() {
        Map<String, EvictionNotice> evictionNoticeMap = new HashMap<>();

        try(Scanner fileScan = new Scanner(new FileReader(new File("resources/data1.csv")))) {
            String line = fileScan.nextLine(); // read column headers


            try {
                while (fileScan.hasNextLine()) {
                    line = fileScan.nextLine();
                    String[] lineArray = line.split(",", -1); // pass in -1 to capture railing empty strings

                    String id = isBlank(lineArray[0]);
                    String zip = isBlank(lineArray[1]);
                    String fileDate = isBlank(lineArray[2]);
                    // https://stackoverflow.com/questions/1538755/how-to-convert-string-object-to-boolean-object
                    boolean illegalUse = Boolean.valueOf(isBlank(lineArray[3])); // if item is NA - boolean is false
                    String neighborhood = isBlank(lineArray[4]);

                    EvictionNotice evictionNotice = new EvictionNotice(id, zip, neighborhood, illegalUse, fileDate);
                    evictionNoticeMap.put(id, evictionNotice);
                }
            } catch (Exception e) {
                println(">>>> Couldn't parse data ");
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return evictionNoticeMap;
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
