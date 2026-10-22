package javaConstructors.level2;

import java.util.Scanner;

/**
 * Represents a product and tracks the total products created.
 */
class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    /**
     * Initializes a product and increments the product count.
     *
     * @param productName the name of the product
     * @param price the price of the product
     */
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    /**
     * Displays the details of this product.
     */
    void displayProductDetails() {
        // Display instance variables belonging to this product.
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    /**
     * Displays the total number of products created.
     */
    static void displayTotalProducts() {
        // Access the shared class variable.
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read details of the first product.
        System.out.print("Enter first product name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first product price: ");
        double price1 = sc.nextDouble();
        sc.nextLine();

        // Read details of the second product.
        System.out.print("Enter second product name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second product price: ");
        double price2 = sc.nextDouble();

        // Create two product objects.
        Product p1 = new Product(name1, price1);
        Product p2 = new Product(name2, price2);

        // Display product details and the shared count.
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();

        sc.close();
    }
}
