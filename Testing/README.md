# Bank Account OOP Assignment – Testing

## 1. Testing Objectives

The purpose of testing was to check whether the banking system performs transactions correctly and handles invalid operations.

## 2. Test Cases

| Test | Expected Result | Actual Result | Status |
|------|-----------------|---------------|--------|
| Negative deposit | Reject deposit | Deposit rejected | PASS |
| Valid deposit | Increase balance | Balance increased to $550 | PASS |
| Savings withdrawal | Maintain minimum balance of $100 | Withdrawal rejected | PASS |
| Current account withdrawal | Allow overdraft | Negative balance allowed | PASS |
| Savings interest | Add 2% interest | Interest added | PASS |
| Current account fee | Deduct $10 | Fee deducted | PASS |
| Final balances | Display updated balances | Balances displayed | PASS |

## 3. OOP Concepts Tested

### Encapsulation
Account information is managed through methods within the account classes.

### Inheritance
SavingsAccount and CurrentAccount extend the Account class.

### Polymorphism
Different account types implement withdrawal and month-end processing differently.

### Abstraction
The Account class provides a common structure for different account types.

## 4. Test Results

The program executed successfully, and the tested operations produced the expected results.

## 5. Conclusion

The testing demonstrated that the banking system handles deposits, withdrawals, interest calculations, and account fees correctly. It also shows how object-oriented programming concepts can be applied in a banking application.
