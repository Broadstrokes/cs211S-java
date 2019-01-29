import java.math.BigDecimal;
import java.util.*;

public class BrokerageAccount extends AccountImpl{
    private AccountType accountType;

    Set<String> stocksInPortfolio = new HashSet<String>();

    public BrokerageAccount(String userId, String accountId, BigDecimal initialDeposit) {
        super(userId, accountId, initialDeposit);
        this.accountType = AccountType.BROKERAGE; // M2 HOMEWORK ENUM USE
    }


    /*
        GETTERS & SETTERS
     */

    public AccountType getAccountType() { // M2 HOMEWORK ENUM USE
        return accountType;
    }

    /**
     * Add a stock to the portfolio
     * @param symbol
     */
    public void addStockToPortfolio(String symbol) {
        if (stocksInPortfolio.contains(symbol)) {
            System.out.println("Stock is already in portfolio");
        } else {
            stocksInPortfolio.add(symbol);
        }
    }

    /**
     * Remove a stock from the portfolio
     * @param symbol
     */
    public void removeStockFromPortfolio(String symbol) {
        if (!stocksInPortfolio.contains(symbol)) {
            System.out.println("Nothing to remove. Stock is not portfolio");
        } else {
            stocksInPortfolio.remove(symbol);
        }
    }

    /**
     * Indicates if the portfolio is empty
     * @return boolean if true, not stocks in portfolio
     */
    public boolean isPortfolioEmpty() {
        return stocksInPortfolio.size() < 1;
    }

    /**
     * Prints all stocks in the portfolio to the console
     */
    public void printAllStocksInPortfolio() {
        if (!isPortfolioEmpty()) {
            System.out.println("Listing all stocks in the portfolio");
            for(String stock : stocksInPortfolio){
                System.out.println(stock);
            }
        } else {
            System.out.println("Portfolio is empty");
        }
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
                " | Is portfolio empty? " + isPortfolioEmpty()
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof BrokerageAccount) {
            BrokerageAccount otherBrokerageAccount = (BrokerageAccount) other;

            return this.getAccountId().equals(otherBrokerageAccount.getAccountId());
        }

        return false;
    }

}
