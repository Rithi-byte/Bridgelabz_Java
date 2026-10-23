
package thisstaticfinalinstanceof.level1;

import java.util.Scanner;

/**
 * Represents a product and demonstrates static, final, and instanceof concepts.
 */
class Product {

    // Shared discount percentage applied to products.
    static double discount = 10.0;

    // Instance variables store individual product details.
    String productName;
    double price;
    int quantity;

    // The product ID is assigned once and cannot be reassigned.
    final int productID;

    /**
     * Initializes a product with its details.
     *
     * @param productName the product's name
     * @param price the price per unit
     * @param quantity the quantity purchased
     * @param productID the product's unique ID
     */
    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    /**
     * Updates the shared discount percentage.
     *
     * @param newDiscount the new discount percentage
     */
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    /**
     * Calculates and displays the product details and final price
     * after applying the discount.
     */
    void displayDetails() {
        // Calculate the total price before applying the discount.
        double total = price * quantity;

        // Subtract the discount amount from the total price.
        double finalPrice = total - (total * discount / 100);

        System.out.println("Product: " + productName);
        System.out.println("Product ID: " + productID);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: " + finalPrice);
    }

    /**
     * Executes the product discount demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the product name.
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        // Read the price per unit.
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        // Read the quantity purchased.
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        // Read the product ID.
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        // Read the discount percentage to apply.
        System.out.print("Enter discount percentage: ");
        double newDiscount = sc.nextDouble();

        // Create the product object.
        Product product = new Product(name, price, quantity, id);

        // Update the shared discount before displaying the product.
        updateDiscount(newDiscount);

        // Store the Product reference in a variable of type Object.
        Object obj = product;

        // Check the object's type before casting and displaying details.
        if (obj instanceof Product) {
            ((Product) obj).displayDetails();
        }

        // Close the Scanner after input is complete.
        sc.close();
    }
}
