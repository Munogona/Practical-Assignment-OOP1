import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        // Interest rates are decimal fractions: 0.02 = 2% per month.
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("S001", 500.00, 100.00, 0.02));
        accounts.add(new CurrentAccount("C001", 100.00, 500.00, 10.00));
        accounts.add(new SavingsAccount("S002", 1000.00, 200.00, 0.02));

        System.out.println("=== BANK ACCOUNT DEMONSTRATION ===");
        System.out.println("\n=== DEPOSIT VALIDATION ===");
        accounts.get(0).deposit(-50.00); // Invalid deposit is rejected.
        accounts.get(0).deposit(50.00);  // Valid deposit is accepted.

        System.out.println("\n=== POLYMORPHIC WITHDRAWALS ===");
        double[] withdrawalAmounts = {500.00, 300.00, 250.00};
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i); // Calls through Account, no casts.
            System.out.printf("Processing %s (%s)%n",
                    account.getAccountNumber(), account.getClass().getSimpleName());
            account.withdraw(withdrawalAmounts[i]);
        }

        System.out.println("\n=== POLYMORPHIC MONTH-END PROCESSING ===");
        for (Account account : accounts) { // Correct subclass method runs automatically.
            account.endOfMonth();
        }

        System.out.println("\n=== FINAL BALANCES ===");
        for (Account account : accounts) {
            System.out.printf("%s (%s): $%.2f%n",
                    account.getAccountNumber(), account.getClass().getSimpleName(),
                    account.getBalance());
        }
    }
}
