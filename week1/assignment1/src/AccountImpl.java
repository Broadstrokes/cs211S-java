import java.math.BigDecimal;
import java.util.Date;

public class AccountImpl implements Account {

    private String accountId;
    private String userId;
    private BigDecimal balance;
    private Date accountOpeningDate;
    private Fees fee;

    /*
        CONSTRUCTORS
     */

    public AccountImpl(String userId, String accountId, BigDecimal initialDeposit, Fees fee) {
        this.userId = userId;
        this.accountId = accountId;
        this.balance = initialDeposit;
        this.accountOpeningDate = new Date();
        this.fee = fee;
    }

    public AccountImpl(String userId, String accountId, Fees fee) {
        this(userId, accountId, new BigDecimal(0), fee);
    }


    /*
        FACTORY METHOD
     */


    public static Account newAccount(String userId, String accountId, BigDecimal initialDeposit, AccountType type) { // M3 USING FACTORY
        Account a;

        if (type.name() == "CHECKING") {
            a = new CheckingAccount(userId, accountId, initialDeposit);
        } else if (type.name() == "SAVINGS") {
            a = new SavingsAccount(userId, accountId, initialDeposit, new BigDecimal(0.25), new BigDecimal(2000), new BigDecimal(5000));
        } else if (type.name() == "BROKERAGE") {
            a = new BrokerageAccount(userId, accountId, initialDeposit);
        } else {
            throw new IllegalArgumentException();
        }

        return a;
    }

    /*
        GETTERS & SETTERS
     */

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        this.balance = amount;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
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
                " | Date opened? "  + getAccountOpeningDate()
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AccountImpl) {
            AccountImpl otherAccountImpl = (AccountImpl) other;
            return this.accountId.equals(otherAccountImpl.accountId);
        }

        return false;
    }

    public void generateAccountFees() {
        fee.generateAccountFees();
    }
}