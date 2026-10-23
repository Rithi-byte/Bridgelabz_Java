
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a product available for purchase.
 */
class EcommerceProduct {
    String name;
    double price;

    /**
     * Initializes a product with its name and price.
     *
     * @param name the product's name
     * @param price the product's price
     */
    EcommerceProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

/**
 * Represents a customer who can place an order.
 */
class EcommerceCustomer {
    String name;

    /**
     * Initializes a customer with the given name.
     *
     * @param name the customer's name
     */
    EcommerceCustomer(String name) {
        this.name = name;
    }

    /**
     * Creates a new order for this customer.
     *
     * @return a new order associated with this customer
     */
    EcommerceOrder placeOrder() {
        return new EcommerceOrder(this);
    }
}

/**
 * Represents an order containing products purchased by a customer.
 */
class EcommerceOrder {
    EcommerceCustomer customer;
    ArrayList<EcommerceProduct> products = new ArrayList<>();

    /**
     * Initializes an order for the specified customer.
     *
     * @param customer the customer placing the order
     */
    EcommerceOrder(EcommerceCustomer customer) {
        this.customer = customer;
    }

    /**
     * Adds a product to the order.
     *
     * @param product the product to add
     */
    void addProduct(EcommerceProduct product) {
        products.add(product);
    }

    /**
     * Displays the customer name, ordered products, and total amount.
     */
    void displayOrder() {
        double total = 0;

        System.out.println("\nCustomer: " + customer.name);
        System.out.println("Order Details:");

        // Display each product and calculate the total price.
        for (EcommerceProduct product : products) {
            System.out.println(product.name + " - Rs. " + product.price);
            total += product.price;
        }

        // Display the final amount for all products.
        System.out.println("Total Amount: Rs. " + total);
    }
}

/**
 * Demonstrates creating an e-commerce order with two products.
 */
public class EcommerceDemo {

    /**
     * Executes the e-commerce order demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the customer's name and create the customer.
        System.out.print("Enter customer name: ");
        EcommerceCustomer customer =
                new EcommerceCustomer(sc.nextLine());

        // Create a new order for the customer.
        EcommerceOrder order = customer.placeOrder();

        // Read the first product's details.
        System.out.print("Enter first product name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first product price: ");
        double price1 = sc.nextDouble();
        sc.nextLine(); // Consume the leftover newline.

        // Read the second product's details.
        System.out.print("Enter second product name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second product price: ");
        double price2 = sc.nextDouble();

        // Create both products and add them to the order.
        order.addProduct(new EcommerceProduct(name1, price1));
        order.addProduct(new EcommerceProduct(name2, price2));

        // Display the order summary and total amount.
        order.displayOrder();

        // Close the Scanner after input is complete.
        sc.close();
    }
}
