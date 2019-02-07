import java.math.BigDecimal;

public class SavingsAccount extends CheckingAccount {
    private static BigDecimal accountFee = new BigDecimal(5.99); // M2 HOMEWORK STATIC
    private static int numSavingsAccountInstances = 0;
    private BigDecimal interestRate;
    private BigDecimal savingsTarget;
    private BigDecimal minBalanceThreshold;


    public SavingsAccount(String userId, String accountId, BigDecimal initialDeposit, BigDecimal interestRateInDecimal, BigDecimal minBalanceThreshold, BigDecimal savingsTarget) {
        this(userId, accountId, initialDeposit);

        this.interestRate = interestRateInDecimal;
        this.minBalanceThreshold = minBalanceThreshold;
        this.savingsTarget = savingsTarget;
    }

    public SavingsAccount(String userId, String accountId, BigDecimal initialDeposit) {
        super(userId, accountId, initialDeposit);

        this.setAccountType(AccountType.SAVINGS); // M2 HOMEWORK ENUM USE
        SavingsAccount.numSavingsAccountInstances++;
    }


    /*
        GETTERS & SETTERS
     */


    public static BigDecimal getAccountFee() { // M2 HOMEWORK STATIC
        return SavingsAccount.accountFee;
    }

    public static void setAccountFee(BigDecimal accountFee) { // M2 HOMEWORK STATIC
        SavingsAccount.accountFee = accountFee;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getSavingsTarget() {
        return savingsTarget;
    }

    public void setSavingsTarget(BigDecimal savingsTarget) {
        this.savingsTarget = savingsTarget;
    }

    public BigDecimal getMinBalanceThreshold() {
        return minBalanceThreshold;
    }

    public void setMinBalanceThreshold(BigDecimal minBalanceThreshold) {
        this.minBalanceThreshold = minBalanceThreshold;
    }




    /**
     * Calculates interest on the balance
     * @return interest based on the interest rate and current balance
     */
    public BigDecimal calculateInterest() {
        // calculate compounded interest
        // This is not the correct formula - I will use the correct one in the next iteration
        // Also need to correct for -ive balances

        return this.getBalance().multiply(interestRate);
    }

    /**
     * Checks if the savings target has been met
     * @return if true, then savings target has been met
     */
    public boolean isSavingsTargetMet() {
        return this.getBalance().compareTo(savingsTarget) >= 0;
    }


    /**
     * Checks if the current balance is below required minimum balance
     * @return boolean if true account is below minimum required balance
     */
    public boolean isBelowThreshold() {
        return this.getBalance().compareTo(minBalanceThreshold) < 0;
    }

    /**
     * Get the number of savings account instances
     * @return int indicating the number of savings account instances
     */
    public static int getNumSavingsAccountInstances() { // M2 HOMEWORK STATIC
        return SavingsAccount.numSavingsAccountInstances;
    }

    /*
        OVERRIDES
     */

    @Override
    public String toString() {
        return String.format(
                "Id: "              + getUserId() +
                " | Balance: "      + getBalance() +
                " | Date opened? "  + getAccountOpeningDate() +
                " | Is overdrawn? " + isOverdrawn() +
                " | Saving target Met? " + isSavingsTargetMet() +
                " | Balance below threshold? " + isBelowThreshold()
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SavingsAccount) {
            SavingsAccount otherSavingsAccount = (SavingsAccount) other;

            return this.getAccountId().equals(otherSavingsAccount.getAccountId());
        }

        return false;
    }

}
