package javaExceptions.problemStatement1;

import java.util.*;

// Custom exception for transaction failures
class TransactionException extends Exception {

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class TransactionProcessor {

    // Method to process a transaction
    public static void processTransaction(int amount) {

        // Check transaction amount
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Transaction amount must be positive"
            );
        }

        System.out.println("Transaction processed successfully!");
        System.out.println("Amount: " + amount);
    }

    // Catch and rethrow exception with transaction context
    public static void executeTransaction(int amount)
            throws TransactionException {

        try {

            // Process the transaction
            processTransaction(amount);

        } catch (IllegalArgumentException e) {

            // Rethrow as custom exception with additional context
            throw new TransactionException(
                    "Transaction failed for amount: " + amount,
                    e
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction amount: ");
        int amount = sc.nextInt();

        try {

            // Execute transaction
            executeTransaction(amount);

        } catch (TransactionException e) {

            // Handle custom exception
            System.out.println("Error: " + e.getMessage());

            // Display original exception
            System.out.println("Reason: " + e.getCause().getMessage());
        }

        sc.close();
    }
}

