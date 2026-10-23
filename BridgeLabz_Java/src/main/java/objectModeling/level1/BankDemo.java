
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a bank customer and stores their account balance.
 */
class Customer {
    String name;
    double balance = 0;

    /**
     * Creates a customer with the specified name.
     *
     * @param name the name of the customer
     */
    Customer(String name) {
        this.name = name;
    }

    /**
     * Displays the customer's current account balance.
     */
    void viewBalance() {
        System.out.println(name + "'s balance: " + balance);
    }
}

/**
 * Represents a bank that manages customer accounts.
 */
class Bank {
    String name;
    ArrayList<Customer> customers = new ArrayList<>();

    /**
     * Creates a bank with the specified name.
     *
     * @param name the name of the bank
     */
    Bank(String name) {
        this.name = name;
    }

    /**
     * Opens an account for a customer and adds the initial deposit.
     *
     * @param customer the customer opening the account
     * @param amount the initial deposit amount
     */
    void openAccount(Customer customer, double amount) {
        // Add the customer to the bank's customer list.
        customers.add(customer);

        // Update the customer's balance with the initial deposit.
        customer.balance += amount;

        System.out.println("Account opened at " + name);
    }
}

/**
 * Demonstrates bank account creation and balance display.
 */
public class BankDemo {

    /**
     * The entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the bank name from the user.
        System.out.print("Enter bank name: ");
        Bank bank = new Bank(sc.nextLine());

        // Read the customer's name.
        System.out.print("Enter customer name: ");
        Customer customer = new Customer(sc.nextLine());

        // Read the initial deposit amount.
        System.out.print("Enter initial deposit: ");
        double amount = sc.nextDouble();

        // Open the customer's account and display the balance.
        bank.openAccount(customer, amount);
        customer.viewBalance();

        // Release the Scanner resource.
        sc.close();
    }
}
