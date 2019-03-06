import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@SuppressWarnings("Duplicates")
public class ListTester {
    public static void main(String[] args) {

        println("");
        printDashes();
        println("Starting ListTester");
        printDashes();


        List<EvictionNotice> evictionNoticeList1 = generateListFromFile("resources/data1.csv");
        List<EvictionNotice> evictionNoticeList2 = generateListFromFile("resources/data2.csv");

        println("Number of eviction records in list generated from data1: " + evictionNoticeList1.size());
        println("Number of eviction records in list generated from data2: " + evictionNoticeList2.size());

        Map<String, Integer> mapOfEvictionCountByZipCode = generateMapOfEvictionCountsByZipCode(evictionNoticeList1);
        Map<String, Integer> mapOfEvictionCountByNeighborhood = generateMapOfEvictionCountsByNeighborhood(evictionNoticeList1);


        println("");
        printDashes();
        println("Queries for Data 1");
        printDashes();
        // Query 1: Count of Eviction notice for a specific zipcode
        println("Evictions notices for ZipCode 94109: " + mapOfEvictionCountByZipCode.get("94109"));
        // Query 2: Count of Eviction notice for a specific neighborhood
        println("Evictions notices for Tenderloin: " + mapOfEvictionCountByNeighborhood.get("Tenderloin"));
        // Query 3: Neighborhood with most notices
        print("Neighborhood with most notices: ");
        printNeighborhoodWithMostEvictionNotices(mapOfEvictionCountByNeighborhood);

        println("");
        printDashes();
        println("Table of Eviction notice count by Neighborhood");
        printDashes();

        for (Map.Entry<String, Integer> entry : mapOfEvictionCountByNeighborhood.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }


    /**
     * Creates a list of eviction notices from a csv file
     *
     * @param filePath path of the cvs file
     * @return ArrayList holding EvictionNotice objects
     */
    private static List<EvictionNotice> generateListFromFile(String filePath) {
        List<EvictionNotice> evictionNoticeList = new ArrayList<>();

        try(Scanner fileScan = new Scanner(new FileReader(new File(filePath)))) {
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
                    evictionNoticeList.add(evictionNotice);
                }
            } catch (Exception e) {
                println(">>>> Couldn't parse data ");
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return evictionNoticeList;
    }


    /**
     * Generate a map of count of eviction notices by ZipCode
     * @param list  list containing EvictionNotice objects
     * @return a map of count of eviction notices by ZipCode
     */
    public static Map<String, Integer> generateMapOfEvictionCountsByZipCode(List<EvictionNotice> list) {
        Map<String, Integer> map = new HashMap<>();
        Iterator<EvictionNotice> itr = list.iterator();

        while(itr.hasNext()) {
            EvictionNotice notice = itr.next();
            String zipcode = notice.getZip();

            map.put(zipcode, map.getOrDefault(zipcode, 0) + 1);
        }

        return map;
    }

    /**
     * Generate a map of count of eviction notices by neighborhood
     * @param list list containing EvictionNotice objects
     * @return a map of count of eviction notices by neighborhood
     */
    public static Map<String, Integer> generateMapOfEvictionCountsByNeighborhood(List<EvictionNotice> list) {
        Map<String, Integer> map = new TreeMap<>();
        Iterator<EvictionNotice> itr = list.iterator();

        while(itr.hasNext()) {
            EvictionNotice notice = itr.next();
            String neighborhood = notice.getNeighborhood();

            map.put(neighborhood, map.getOrDefault(neighborhood, 0) + 1);
        }

        return map;
    }

    /**
     * Display in console the neighborhood with the most eviction notices
     * @param map map of eviction notice counts by neighborhood
     */
    public static void printNeighborhoodWithMostEvictionNotices(Map<String, Integer> map) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        String neighborhood = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int noticeCount = entry.getValue();
            if (noticeCount > max) {
                max = noticeCount;
                neighborhood = entry.getKey();
            }
            if (noticeCount < min) {
                min = noticeCount;
            }
        }

        print(neighborhood + ": " + max);
        println(" | Range for notice count: [" + min + ", " + max + "]");
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
