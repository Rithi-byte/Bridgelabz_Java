package umlDiagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a product in the grocery store.
 * Stores the product name, quantity, and price per unit.
 */
class Product {
    String productName;
    double quantity;
    double pricePerUnit;

    /**
     * Creates a product with the specified details.
     *
     * @param productName the name of the product
     * @param quantity the quantity purchased
     * @param pricePerUnit the price of one unit
     */
    Product(String productName, double quantity, double pricePerUnit) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    /**
     * Calculates the total price of this product.
     *
     * @return the quantity multiplied by the price per unit
     */
    double calculatePrice() {
        return quantity * pricePerUnit;
    }
}

/**
 * Represents a customer and the products purchased by that customer.
 */
class Customer {
    String name;
    int customerId;
    List<Product> products = new ArrayList<>();

    /**
     * Creates a customer with a name and customer ID.
     *
     * @param name the customer's name
     * @param customerId the customer's unique ID
     */
    Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    /**
     * Adds a product to the customer's product list.
     *
     * @param product the product to add
     */
    void addProduct(Product product) {
        products.add(product);
    }
}

/**
 * Generates and displays a grocery bill for a customer.
 */
class BillGenerator {

    /**
     * Calculates and prints the bill for all products purchased
     * by the specified customer.
     *
     * @param customer the customer whose bill is generated
     */
    void generateBill(Customer customer) {
        double total = 0;

        // Display the customer's details.
        System.out.println("\n--- Grocery Bill ---");
        System.out.println("Customer: " + customer.name);
        System.out.println("Customer ID: " + customer.customerId);

        // Calculate and display the price of each product.
        for (Product product : customer.products) {
            double price = product.calculatePrice();

            System.out.printf(
                    "%s: %.2f x $%.2f = $%.2f%n",
                    product.productName,
                    product.quantity,
                    product.pricePerUnit,
                    price
            );

            // Add the product price to the total bill.
            total += price;
        }

        // Display the final bill amount.
        System.out.printf("Total Bill: $%.2f%n", total);
    }
}

/**
 * Runs the grocery store billing application.
 * Accepts customer and product details and generates a bill.
 */
public class GroceryStore {

    /**
     * Starts the application and collects input from the user.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the customer's details.
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter customer ID: ");
        int customerId = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Create a customer object.
        Customer customer = new Customer(name, customerId);

        // Read the number of products to be purchased.
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Collect the details of each product.
        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1));

            System.out.print("Enter product name: ");
            String productName = sc.nextLine();

            System.out.print("Enter quantity: ");
            double quantity = sc.nextDouble();

            System.out.print("Enter price per unit: ");
            double price = sc.nextDouble();
            sc.nextLine(); // Consume the leftover newline.

            // Create the product and add it to the customer.
            Product product = new Product(productName, quantity, price);
            customer.addProduct(product);
        }

        // Generate the bill using the customer's product list.
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(customer);

        // Release the scanner resource.
        sc.close();
    }
}
