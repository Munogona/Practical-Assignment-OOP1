# Bank Account OOP Assignment

## Overview

This is a Java console program that demonstrates object-oriented programming using a simple banking system. It models savings and current accounts, handles deposits and withdrawals, and applies different month-end rules depending on the account type.

## Files in the project

- `Account.java` – Abstract parent class containing shared account information, deposit validation, getters, and abstract methods for withdrawals and month-end processing.
- `SavingsAccount.java` – Savings account implementation that enforces a minimum balance and adds monthly interest.
- `CurrentAccount.java` – Current account implementation that permits withdrawals within an overdraft limit and deducts a monthly maintenance fee when allowed.
- `BankDemo.java` – Main class that creates sample accounts and demonstrates the program's features.
- `SampleOutput.txt` – Example console output for the demonstration.

## OOP concepts demonstrated

- **Abstraction:** `Account` defines the common account structure and requires subclasses to implement `withdraw()` and `endOfMonth()`.
- **Inheritance:** `SavingsAccount` and `CurrentAccount` extend `Account`.
- **Polymorphism:** The demonstration stores both account types in a `List<Account>` and calls their overridden methods without casting.
- **Encapsulation:** Account state is accessed through methods such as `getBalance()` and `getAccountNumber()`, while subclass-specific settings are private.
- **Method overriding:** Each account type has its own withdrawal and month-end behaviour.

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal/command prompt, or a Java-compatible IDE

## How to run

1. Extract the ZIP file and open the `BankOOPAssignment` folder.
2. Open a terminal in that folder.
3. Compile all Java files:

   ```bash
   javac *.java
   ```

4. Run the main class:

   ```bash
   java BankDemo
   ```

On Windows Command Prompt, the same commands work. The output can be compared with `SampleOutput.txt`.

## What the program demonstrates

1. Creates two savings accounts and one current account.
2. Tests an invalid deposit followed by a valid deposit.
3. Processes withdrawals, including one that is rejected because it would break a savings account's minimum balance requirement.
4. Applies monthly interest to savings accounts and a maintenance fee to the current account.
5. Prints the final balances.

## Account rules

**Savings account:** A withdrawal is only allowed if the remaining balance is at least the configured minimum balance. Monthly interest is calculated using `balance * interestRate`.

**Current account:** Withdrawals can take the balance below zero but not past the configured overdraft limit. A monthly maintenance fee is deducted only when doing so would not exceed that limit.

**Deposits:** Deposit amounts must be positive and finite. Invalid amounts are rejected.

## Sample final balances

For the example data in `BankDemo.java`:

```text
S001 (SavingsAccount): $561.00
C001 (CurrentAccount): $-210.00
S002 (SavingsAccount): $765.00
```
