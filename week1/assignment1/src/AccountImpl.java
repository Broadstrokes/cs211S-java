public class AccountImpl implements Account {

    private String userId;
    private double balance;

    public AccountImpl(String id, double initialBalance) {
        this.userId = id;
        this.balance = initialBalance;
    }

    public AccountImpl(String id) { this(id, 0); }

    public String getUserId() { return userId; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double  amount) { balance -= amount; }

}