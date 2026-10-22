package classesAndObject.level2;

import java.util.Scanner;

/**
 * Simulates basic banking operations on a bank account.
 */
class BankAccount {
    String accountHolder;
    long accountNumber;
    double balance;

    /**
     * Deposits money into the account.
     *
     * @param amount the amount to deposit
     */
    void deposit(double amount) {
        // Deposit only a positive amount.
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    /**
     * Withdraws money if sufficient balance exists.
     *
     * @param amount the amount to withdraw
     */
    void withdraw(double amount) {
        // Check the amount and available balance.
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    /**
     * Displays the current account balance.
     */
    void displayBalance() {
        // Display the available balance.
        System.out.printf("Current Balance: %.2f%n", balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        // Read account details.
        System.out.print("Enter account holder name: ");
        account.accountHolder = sc.nextLine();

        System.out.print("Enter account number: ");
        account.accountNumber = sc.nextLong();

        System.out.print("Enter initial balance: ");
        account.balance = sc.nextDouble();

        if (account.balance < 0) {
            System.out.println("Initial balance cannot be negative.");
            sc.close();
            return;
        }

        int choice;

        // Display the ATM menu until the user exits.
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
