public enum AccountType {

    CHECKING(1),
    SAVINGS(2),
    BROKERAGE(3),
    CD(4),
    IRA(5),
    MONEY_MARKET(6);

    private int alertsPriority;

    private AccountType(int alertsPriority) {
        this.alertsPriority = alertsPriority;
    }

    /**
     * Return the priority order of alerts to be displayed to the user
     * @return int alert priority for the account
     */

    public int getAlertsPriority() {
        return alertsPriority;
    }
}

