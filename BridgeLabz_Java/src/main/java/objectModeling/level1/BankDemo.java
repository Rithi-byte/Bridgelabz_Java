package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    String name;
    double balance = 0;

    Customer(String name) {
        this.name = name;
    }

    void viewBalance() {
        System.out.println(name + "'s balance: " + balance);
    }
}

class Bank {
    String name;
    ArrayList<Customer> customers = new ArrayList<>();

    Bank(String name) {
        this.name = name;
    }

    void openAccount(Customer customer, double amount) {
        customers.add(customer);
        customer.balance += amount;
        System.out.println("Account opened at " + name);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bank name: ");
        Bank bank = new Bank(sc.nextLine());

        System.out.print("Enter customer name: ");
        Customer customer = new Customer(sc.nextLine());

        System.out.print("Enter initial deposit: ");
        double amount = sc.nextDouble();

        bank.openAccount(customer, amount);
        customer.viewBalance();

        sc.close();
    }
}
