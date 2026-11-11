package javaExceptions.basics;

import java.util.*;

// Custom checked exception
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank account class
class BankAccount {

    // Store account balance
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Withdraw money from account
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        // Check for negative withdrawal amount
        if (amount < 0) {

            throw new IllegalArgumentException(
                    "Invalid amount!"
            );
        }

        // Check whether sufficient balance is available
        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient balance!"
            );
        }

        // Deduct withdrawal amount
        balance = balance - amount;

        // Display updated balance
        System.out.println(
                "Withdrawal successful, new balance: " + balance
        );
    }
}

public class BankTransactionSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create bank account with initial balance
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(initialBalance);

        // Get withdrawal amount
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {

            // Perform withdrawal
            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {

            // Handle insufficient balance
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            // Handle negative withdrawal amount
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
