import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class Week3Main {

    public static void main(String[] args) {
        println(">>>> Starting Week 3 Main driver");

        testStrategyPattern(); // M3 USING STRATEGY
        testCheckingAccountComparator(); // M3 USING COMPARATOR
    }

    }


    public static void testStrategyPattern() {  // M3 USING STRATEGY
        println(">>>>>>>>>>> testStrategyPattern >>>>>>>>>>>>>>>>>");

        CheckingAccount checking1 = new CheckingAccount("10", "22", new BigDecimal(300));
        BrokerageAccount brokerage1 = new BrokerageAccount("23", "4", new BigDecimal(300));
        checking1.generateAccountFees();
        brokerage1.generateAccountFees();
    }


    public static void testCheckingAccountComparator() {
        println(">>>>>>>>>>> testCheckingAccountComparator >>>>>>>>>>>>>>>>>");
        CheckingAccount account1 = new CheckingAccount("23", "31", new BigDecimal(300));
        CheckingAccount account2 = new CheckingAccount("23", "12", new BigDecimal(300));
        CheckingAccount account3 = new CheckingAccount("21", "31", new BigDecimal(300));

        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
        checkingAccounts.add(account1);
        checkingAccounts.add(account2);
        checkingAccounts.add(account3);


        println(checkingAccounts);
        Collections.sort(checkingAccounts, CheckingAccount.USER_ID_COMPARATOR);
        println(checkingAccounts);
    }

    /*
        HELPER FUNCTIONS
     */

    public static void println(Object line) { System.out.println(line); }
    public static void print(Object line) { System.out.print(line); }

    /**
     * Function to test an expectation
     * @param expression     Expectation/Expression to test, which returns a boolean
     * @param successMessage String to output to the user if the expectation is met
     * @param errorMessage   String to output to the user if the expectation is not met
     * @param should         String stating what should be tested
     */
    public static void test (boolean expression, String successMessage, String errorMessage, String should) {
        System.out.print(should + ": ");

        if (expression)
            System.out.println(successMessage);
        else
            System.out.println(errorMessage);
    }
}
