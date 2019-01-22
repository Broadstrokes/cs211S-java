public interface Account {
    public String getUserId();
    public double getBalance();
    public void deposit(double amount);
    public void withdraw(double amount);
}
