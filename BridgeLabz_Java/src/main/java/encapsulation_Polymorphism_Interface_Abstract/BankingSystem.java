
package encapsulation_Polymorphism_Interface_Abstract;

import java.util.ArrayList;
import java.util.List;

// Interface for loan-related operations
interface Loanable {
    void applyForLoan(double amount);

    boolean calculateLoanEligibility(double amount);
}


// Abstract parent class for bank accounts
abstract class BankAccount implements Loanable {

    // Encapsulation: protect account details
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName,
                       double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, balance);
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money only if sufficient balance exists
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful: " + amount);
        }
    }

    // Abstract method for account-specific interest
    public abstract double calculateInterest();

    // Check loan eligibility using the account balance
    @Override
    public boolean calculateLoanEligibility(double amount) {
        return amount > 0 && balance >= amount * 0.20;
    }

    // Process a loan application
    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility(amount)) {
            System.out.println("Loan approved for " + holderName
                    + ": " + amount);
        } else {
            System.out.println("Loan application rejected for "
                    + holderName);
        }
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("-----------------------------");
    }
}

// Savings account with 4% annual interest
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String holderName,
                          double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04;
    }
}

// Current account with 2% annual interest
class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, String holderName,
                          double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02;
    }
}

// Main class
public class BankingSystem {

    public static void main(String[] args) {

        // Parent reference stores different account types
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount a1 =
                new SavingsAccount("SA101", "Rithi", 50000);

        BankAccount a2 =
                new CurrentAccount("CA102", "Raj", 80000);

        accounts.add(a1);
        accounts.add(a2);

        // Perform transactions
        a1.deposit(5000);
        a2.withdraw(10000);

        System.out.println("\nAccount Details");

        // Runtime polymorphism
        for (BankAccount account : accounts) {
            account.displayDetails();
        }

        // Loan applications
        a1.applyForLoan(10000);
        a2.applyForLoan(50000);
    }
}
