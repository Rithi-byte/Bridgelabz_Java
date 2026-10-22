package javaConstructors.level3;

import java.util.Scanner;

/**
 * Represents a bank account.
 */
class BankAccount {
    public long accountNumber;
    protected String accountHolder;
    private double balance;

    /**
     * Initializes the bank account.
     *
     * @param accountNumber the account number
     * @param accountHolder the account holder's name
     * @param balance the initial balance
     */
    BankAccount(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        setBalance(balance);
    }

    /**
     * Sets the account balance.
     *
     * @param balance the new balance
     */
    public void setBalance(double balance) {
        // Reject negative balance values.
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance.");
        }
    }

    /**
     * Returns the current account balance.
     *
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read bank account details.
        System.out.print("Enter account number: ");
        long number = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter account holder: ");
        String holder = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        SavingsAccount account = new SavingsAccount(number, holder, balance);
        account.displayDetails();

        // Modify and retrieve the private balance.
        System.out.print("Enter updated balance: ");
        account.setBalance(sc.nextDouble());

        System.out.println("Updated Balance: " + account.getBalance());

        sc.close();
    }
}

/**
 * Represents a savings account.
 */
class SavingsAccount extends BankAccount {

    /**
     * Initializes the savings account.
     *
     * @param number the account number
     * @param holder the account holder's name
     * @param balance the initial balance
     */
    SavingsAccount(long number, String holder, double balance) {
        super(number, holder, balance);
    }

    /**
     * Displays the savings account details.
     */
    void displayDetails() {
        // Access public and protected fields directly.
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);

        // Access private balance through the getter.
        System.out.println("Balance: " + getBalance());
    }
}

