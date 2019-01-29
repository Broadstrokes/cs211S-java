import java.math.BigDecimal;

public class CheckingAccount extends AccountImpl {

    public CheckingAccount(String userId, String accountId, BigDecimal initialDeposit) {
        super(userId, accountId, initialDeposit);
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
            " | Is overdrawn? " + isOverdrawn()
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

}
