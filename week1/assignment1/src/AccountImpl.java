import java.math.BigDecimal;
import java.util.Date;

public class AccountImpl implements Account {

    private String accountId;
    private String userId;
    private BigDecimal balance;
    private Date accountOpeningDate;


    /*
        CONSTRUCTORS
     */

    public AccountImpl(String userId, String accountId, BigDecimal initialBalance) {
        this.userId = userId;
        this.accountId = accountId;
        this.balance = initialBalance;
        this.accountOpeningDate = new Date();
    }

    public AccountImpl(String userId, String accountId) {
        this(userId, accountId, new BigDecimal(0));
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
}