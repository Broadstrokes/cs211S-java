import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        println(">>>> Starting driver");

        ArrayList<AccountImpl> accounts = new ArrayList<AccountImpl>();

        CheckingAccount checking1 = new CheckingAccount("10", "22", new BigDecimal(300));
        SavingsAccount savings1 = new SavingsAccount("22", "8", new BigDecimal(300), new BigDecimal(0.1), new BigDecimal(5000.0), new BigDecimal(15000));
        BrokerageAccount brokerage1 = new BrokerageAccount("23", "4", new BigDecimal(300));


        accounts.add(checking1);
        accounts.add(savings1);
        accounts.add(brokerage1);

        accounts.forEach(account -> {
            System.out.println("");
            System.out.println("Acccount Info: " + account.toString());
            System.out.println("");

            if (account instanceof CheckingAccount && !(account instanceof SavingsAccount)) {
                println(">>>>>>>> CHECKING ACCOUNT");
                CheckingAccount downCastAccount = (CheckingAccount) account;
                downCastAccount.deposit(new BigDecimal(500));
                println(downCastAccount.toString());

                downCastAccount.withdraw(new BigDecimal(1000));
                println(downCastAccount.toString());

                println("Is account overdrawn? " + downCastAccount.isOverdrawn());
            } else if (account instanceof SavingsAccount) {
                println(">>>>>>>> SAVINGS ACCOUNT");
                SavingsAccount downCastAccount = (SavingsAccount) account;
                println(downCastAccount.toString());

                downCastAccount.deposit(new BigDecimal(500));
                println(downCastAccount.toString());

                println("Interest on account: " + downCastAccount.calculateInterest());

                downCastAccount.deposit(new BigDecimal(500));
                println(downCastAccount.toString());

                downCastAccount.deposit(new BigDecimal(500));
                println(downCastAccount.toString());

                println("Is account overdrawn? " + downCastAccount.isOverdrawn());
                println("Minimum balance required: " + downCastAccount.getMinBalanceThreshold());
            } else if (account instanceof BrokerageAccount) {
                println(">>>>>>>> BROKERAGE ACCOUNT");
                BrokerageAccount downCastAccount = (BrokerageAccount) account;
                println(downCastAccount.toString());
                println("Interest on account: " + downCastAccount.isPortfolioEmpty());

                downCastAccount.addStockToPortfolio("SPY");
                downCastAccount.addStockToPortfolio("AAPL");
                downCastAccount.addStockToPortfolio("SPY");


                println(downCastAccount.toString());
                downCastAccount.printAllStocksInPortfolio();

                downCastAccount.removeStockFromPortfolio("SPY");
                downCastAccount.removeStockFromPortfolio("AAPL");

                println("Is portfolio empty? " +downCastAccount.isPortfolioEmpty());
            } else {
                account.toString();
            }

        });




        // COMMENT OUT TO TEST INDIVIDUAL ACCOUNT TYPES


        // testCheckingAccount();
        // testSavingsAccount();
        // testBrokerageAccount();



        testCheckingAccountCompareToMethod(); // M2 HOMEWORK COMPARETO
    }




    /*
        TESTS FOR INDIVIDUAL ACCOUNTS

        NB: I could have used assertion but I did not have time to fully
        write out my assertions. Work was busy.
     */

    public static void testBasicAccountImpl() {
        println(">>>>>>>>>>> testBasicAccountImpl >>>>>>>>>>>>>>>>>");
        AccountImpl myBasicAcct = new AccountImpl("23", "12",new BigDecimal(100));
        println(myBasicAcct.toString());
    }


    public static void testCheckingAccount() {
        println(">>>>>>>>>>> testCheckingAccount >>>>>>>>>>>>>>>>>");
        CheckingAccount account1 = new CheckingAccount("23", "31", new BigDecimal(300));
        CheckingAccount account2 = new CheckingAccount("23", "12", new BigDecimal(300));
        CheckingAccount account3 = new CheckingAccount("21", "31", new BigDecimal(300));
        println(account1.toString());
        account1.deposit(new BigDecimal(500));
        println(account1.toString());
        account1.withdraw(new BigDecimal(500));
        println(account1.toString());
        account1.withdraw(new BigDecimal(500));
        println(account1.toString());
        println(account1.isOverdrawn());


        println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<");
        println(account1.equals(account2));
        println(account1.equals(account3));
    }



    public static void testSavingsAccount() {
        println(">>>>>>>>>>> testSavingsAccount >>>>>>>>>>>>>>>>>");
        SavingsAccount account1 = new SavingsAccount("23", "18", new BigDecimal(300), new BigDecimal(0.1), new BigDecimal(5000.0), new BigDecimal(15000));
        println(account1.toString());
        account1.deposit(new BigDecimal(500));
        println(account1.toString());
        println(account1.calculateInterest());

        account1.withdraw(new BigDecimal(500));
        println(account1.toString());
        account1.withdraw(new BigDecimal(500));
        println(account1.toString());
        println(account1.isOverdrawn());
        println(account1.getMinBalanceThreshold());
    }




    public static void testBrokerageAccount() {
        println(">>>>>>>>>>> testBrokerageAccount >>>>>>>>>>>>>>>>>");
        BrokerageAccount account1 = new BrokerageAccount("23", "21", new BigDecimal(300));
        println(account1.toString());
        println(account1.isPortfolioEmpty());

        account1.addStockToPortfolio("SPY");
        account1.addStockToPortfolio("AAPL");
        account1.addStockToPortfolio("SPY");


        println(account1.toString());
        account1.printAllStocksInPortfolio();

        account1.removeStockFromPortfolio("SPY");
        account1.removeStockFromPortfolio("AAPL");

        println(account1.isPortfolioEmpty());

    }


    public static void testCheckingAccountCompareToMethod() {
        println(">>>>>>>>>>> testCheckingAccountCompareToMethod >>>>>>>>>>>>>>>>>");
        CheckingAccount account1 = new CheckingAccount("1", "12", new BigDecimal(300));
        CheckingAccount account2 = new CheckingAccount("23", "8", new BigDecimal(300));
        CheckingAccount account3 = new CheckingAccount("21", "31", new BigDecimal(300));
        CheckingAccount account4 = new CheckingAccount("8", "50", new BigDecimal(300));
        CheckingAccount account5 = new CheckingAccount("9", "14", new BigDecimal(300));

        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
        checkingAccounts.add(account1);
        checkingAccounts.add(account2);
        checkingAccounts.add(account3);
        checkingAccounts.add(account4);
        checkingAccounts.add(account5);

        println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<");
        System.out.println(checkingAccounts);
        Collections.sort(checkingAccounts);
        System.out.println(checkingAccounts);
        println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<");
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
