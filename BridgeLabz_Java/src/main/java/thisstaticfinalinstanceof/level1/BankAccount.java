
package thisstaticfinalinstanceof.level1;

import java.util.Scanner;

/**
 * Represents a bank account and demonstrates static, final,
 * and instanceof concepts in Java.
 */
class BankAccount {

    // Shared by all BankAccount objects.
    static String bankName = "SBI";
    static int totalAccounts = 0;

    // Instance variable stores the account holder's name.
    String accountHolderName;

    // Final variable can be assigned only once during initialization.
    final long accountNumber;

    /**
     * Initializes a bank account and increments the account count.
     *
     * @param accountHolderName the account holder's name
     * @param accountNumber the unique account number
     */
    BankAccount(String accountHolderName, long accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;

        // Increment the shared account counter for each new account.
        totalAccounts++;
    }

    /**
     * Displays the total number of accounts created.
     */
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    /**
     * Displays the bank name and account details.
     */
    void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    /**
     * Demonstrates account creation and runtime type checking.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the account holder's name.
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        // Read the account number.
        System.out.print("Enter account number: ");
        long number = sc.nextLong();

        // Create a BankAccount object.
        BankAccount account = new BankAccount(name, number);

        // Store the account reference in a variable of type Object.
        Object obj = account;

        // Check the object's actual type before casting.
        if (obj instanceof BankAccount) {
            ((BankAccount) obj).displayDetails();
        }

        // Display the total number of accounts created.
        getTotalAccounts();

        sc.close();
    }
}
