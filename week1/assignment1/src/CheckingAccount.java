import java.math.BigDecimal;
import java.util.Comparator;

public class CheckingAccount extends AccountImpl implements Comparable<CheckingAccount> { // M2 HOMEWORK COMPARETO
    private AccountType accountType; // M2 HOMEWORK ENUM USE

    public final static Comparator<CheckingAccount> USER_ID_COMPARATOR = new CheckingAccountUserIdComparator();

    private static class CheckingAccountUserIdComparator implements Comparator<CheckingAccount> { // M3 USING COMPARATOR
        @Override
        public  int compare(CheckingAccount a1, CheckingAccount a2) {
            return a1.getUserId().compareTo(a2.getUserId());
        }
    }


    public CheckingAccount(String userId, String accountId, BigDecimal initialDeposit) {
        super(userId, accountId, initialDeposit, new CheckingsFee());
        this.accountType = AccountType.CHECKING; // M2 HOMEWORK ENUM USE
    }


    public AccountType getAccountType() { // M2 HOMEWORK ENUM USE
        return accountType;
    }

    public void setAccountType(AccountType accountType) { // M2 HOMEWORK ENUM USE
        this.accountType = accountType;
    }


    /**
     * Increments current account balance
     * @param amount deposit amount
     */
    public void deposit(BigDecimal amount) {
        this.setBalance(this.getBalance().add(amount));
    }


    /**
     * Decrements the current balance
     * @param amount amount withdrawn
     */
    public void withdraw(BigDecimal amount) {
        this.setBalance(this.getBalance().subtract(amount));
    }

    /**
     * Checks if account is overdrawn
     * @return boolean if true then account is overdrawn
     */
    public boolean isOverdrawn() {
        return this.getBalance().compareTo(new BigDecimal("0")) < 0;
    }

    /*
        OVERRIDES
     */

    @Override
    public String toString() {
        return String.format(
            "UserId: "          + getUserId() +
            " | Account Id: "   + getAccountId() +
            " | Balance: "      + getBalance() +
            " | Date opened? "  + getAccountOpeningDate() +
            " | Is overdrawn? " + isOverdrawn() +
            "\n"
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof CheckingAccount) {
            CheckingAccount otherCheckingAccount = (CheckingAccount) other;

            return this.getAccountId().equals(otherCheckingAccount.getAccountId());
        }

        return false;
    }

    /**
     * Compares based on an account's ID
     * @param otherAccount the account to compare
     * @return int returns the different between the current account's ID
     * and the otherAccount's ID
     */
    @Override
    public int compareTo(CheckingAccount otherAccount) { // M2 HOMEWORK COMPARETO
        int accountId1 = Integer.parseInt(this.getAccountId());
        int accountId2 = Integer.parseInt(otherAccount.getAccountId());

        return Integer.compare(accountId1, accountId2);
    }
}
