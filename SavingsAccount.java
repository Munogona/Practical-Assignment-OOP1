public class SavingsAccount extends Account {
    private final double minimumBalance;
    private final double interestRate;

    public SavingsAccount(String accountNumber, double balance,
                          double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        if (!Double.isFinite(minimumBalance) || minimumBalance < 0 || minimumBalance > balance) {
            throw new IllegalArgumentException("Invalid minimum balance.");
        }
        if (!Double.isFinite(interestRate) || interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.printf("Savings %s: Withdrawal rejected. Amount must be positive.%n", accountNumber);
        } else if (balance - amount < minimumBalance) {
            System.out.printf("Savings %s: Withdrawal of $%.2f rejected; minimum balance is $%.2f.%n",
                    accountNumber, amount, minimumBalance);
        } else {
            balance -= amount;
            System.out.printf("Savings %s: Withdrew $%.2f. Balance: $%.2f%n",
                    accountNumber, amount, balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("Savings %s: Month-end interest $%.2f (%.1f%%). Balance: $%.2f%n",
                accountNumber, interest, interestRate * 100, balance);
    }
}
