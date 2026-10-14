public class CurrentAccount extends Account {
    private final double overdraftLimit;
    private final double maintenanceFee;

    public CurrentAccount(String accountNumber, double balance,
                          double overdraftLimit, double maintenanceFee) {
        super(accountNumber, balance);
        if (!Double.isFinite(overdraftLimit) || overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative.");
        }
        if (!Double.isFinite(maintenanceFee) || maintenanceFee < 0) {
            throw new IllegalArgumentException("Maintenance fee cannot be negative.");
        }
        this.overdraftLimit = overdraftLimit;
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.printf("Current %s: Withdrawal rejected. Amount must be positive.%n", accountNumber);
        } else if (balance - amount < -overdraftLimit) {
            System.out.printf("Current %s: Withdrawal of $%.2f rejected; overdraft limit is $%.2f.%n",
                    accountNumber, amount, overdraftLimit);
        } else {
            balance -= amount;
            System.out.printf("Current %s: Withdrew $%.2f. Balance: $%.2f%n",
                    accountNumber, amount, balance);
        }
    }

    @Override
    public void endOfMonth() {
        // A maintenance charge cannot push the account beyond its overdraft limit.
        if (balance - maintenanceFee < -overdraftLimit) {
            System.out.printf("Current %s: Maintenance fee of $%.2f not charged; overdraft limit would be exceeded.%n",
                    accountNumber, maintenanceFee);
            return;
        }
        balance -= maintenanceFee;
        System.out.printf("Current %s: Month-end fee $%.2f deducted. Balance: $%.2f%n",
                accountNumber, maintenanceFee, balance);
    }
}
