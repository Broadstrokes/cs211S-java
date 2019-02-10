import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class Week3Main {

    public static void main(String[] args) {
        println(">>>> Starting Week 3 Main driver");

        testNewAccountFactoryMethod(); // M3 USING FACTORY
        testBuilderPattern(); // M3 USING BUILDER
        testStrategyPattern(); // M3 USING STRATEGY
        testCheckingAccountComparator(); // M3 USING COMPARATOR
    }


    public static void testNewAccountFactoryMethod() {  // M3 USING FACTORY
        println(">>>>>>>>>>> testNewAccountFactoryMethod >>>>>>>>>>>>>>>>>");
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(AccountImpl.newAccount("23", "8", new BigDecimal(300), AccountType.CHECKING));
        accountList.add(AccountImpl.newAccount("9", "33", new BigDecimal(1000), AccountType.SAVINGS));
        accountList.add(AccountImpl.newAccount("30", "33", new BigDecimal(1000), AccountType.BROKERAGE));

        println(accountList);
    }

    public static void testBuilderPattern() {  // M3 USING BUILDER
        println(">>>>>>>>>>> testBuilderPattern >>>>>>>>>>>>>>>>>");
        BigDecimal dummyInterestRate = new BigDecimal(0.75);
        BigDecimal dummySavingsTarget = new BigDecimal(20000);

        AccountBuilder savingsAccount = new AccountBuilder.SavingsAccountBuilder("9", "33", new BigDecimal(1000))
                .interestRate(dummyInterestRate)
                .build();

        println(savingsAccount.toString());
        println(savingsAccount.isSavingsTargetMet());
        println(savingsAccount.getSavingsTarget());


        AccountBuilder savingsAccount2 = new AccountBuilder.SavingsAccountBuilder("21", "88", new BigDecimal(25000))
                .interestRate(dummyInterestRate)
                .savingsTarget(dummySavingsTarget)
                .build();

        println(savingsAccount2.toString());
        println(savingsAccount2.isSavingsTargetMet());
        println(savingsAccount2.getSavingsTarget());
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
