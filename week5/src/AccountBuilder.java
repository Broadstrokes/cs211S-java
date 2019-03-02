import java.math.BigDecimal;

public class AccountBuilder extends SavingsAccount {
    private String userId;
    private String accountId;
    private BigDecimal initialDeposit;
    private BigDecimal interestRate;
    private BigDecimal savingsTarget;
    private BigDecimal minBalanceThreshold;
    private static final BigDecimal DEFAULT_INTEREST_RATE = new BigDecimal(0.25);
    private static final BigDecimal DEFAULT_MIN_BALANCE_THRESHOLD = new BigDecimal(2000);
    private static final BigDecimal DEFAULT_SAVINGS_TARGET = new BigDecimal(5000);

    private AccountBuilder(SavingsAccountBuilder savingsAccountBuilder) {
        super(savingsAccountBuilder.userId, savingsAccountBuilder.accountId, savingsAccountBuilder.initialDeposit);
        super.setInterestRate(savingsAccountBuilder.interestRate);
        super.setSavingsTarget(savingsAccountBuilder.savingsTarget);
        super.setMinBalanceThreshold(savingsAccountBuilder.minBalanceThreshold);
    }


    public static class SavingsAccountBuilder {
        private String userId, accountId;
        private BigDecimal initialDeposit;
        private BigDecimal interestRate = DEFAULT_INTEREST_RATE;
        private BigDecimal minBalanceThreshold = DEFAULT_MIN_BALANCE_THRESHOLD;
        private BigDecimal savingsTarget = DEFAULT_SAVINGS_TARGET;
        private Fees fee;


        public SavingsAccountBuilder(String userId, String accountId, BigDecimal initialDeposit) {
            this.userId = userId;
            this.accountId = accountId;
            this.initialDeposit = initialDeposit;
            this.fee = new CheckingsFee();
        }


        public SavingsAccountBuilder interestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public SavingsAccountBuilder minBalanceThreshold(BigDecimal minBalanceThreshold) {
            this.minBalanceThreshold = minBalanceThreshold;
            return this;
        }

        public SavingsAccountBuilder savingsTarget(BigDecimal savingsTarget) {
            this.savingsTarget = savingsTarget;
            return this;
        }

        /**
         * Builds an AccountBuilder Object
         * @return AccountBuilder
         */
        public AccountBuilder build() {
            AccountBuilder accountBuilder = new AccountBuilder(this);

            if (userId == null || accountId == null || initialDeposit == null) {
                throw new IllegalStateException();
            }

            return accountBuilder;
        }

    }
}
