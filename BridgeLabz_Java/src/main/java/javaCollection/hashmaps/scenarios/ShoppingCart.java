package javaCollection.hashmaps.scenarios;


import java.util.*;

public class ShoppingCart {

    // HashMap stores product names and prices
    static Map<String, Double> hashMap = new HashMap<>();

    // LinkedHashMap maintains insertion order
    static Map<String, Double> linkedHashMap =
            new LinkedHashMap<>();

    // TreeMap sorts products based on price
    static Map<Double, List<String>> treeMap =
            new TreeMap<>();

    // Add product to shopping cart
    public static void addProduct(String name, double price) {

        // Store product and price in HashMap
        hashMap.put(name, price);

        // Maintain order of product insertion
        linkedHashMap.put(name, price);

        // Store product based on its price
        treeMap.computeIfAbsent(
                price, k -> new ArrayList<>()
        ).add(name);

        System.out.println("Product added successfully!");
    }

    // Display all products
    public static void displayProducts() {

        System.out.println("\nAll Products:");

        for (Map.Entry<String, Double> entry :
                hashMap.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }
    }

    // Display products in insertion order
    public static void displayInsertionOrder() {

        System.out.println("\nProducts in Insertion Order:");

        for (Map.Entry<String, Double> entry :
                linkedHashMap.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }
    }

    // Display products sorted by price
    public static void displaySortedProducts() {

        System.out.println("\nProducts Sorted by Price:");

        for (Map.Entry<Double, List<String>> entry :
                treeMap.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }
    }

    // Calculate total shopping cart price
    public static void calculateTotal() {

        double total = 0;

        for (double price : hashMap.values()) {
            total += price;
        }

        System.out.println("\nTotal Cart Amount: " + total);
    }

    // Remove product from cart
    public static void removeProduct(String name) {

        if (hashMap.containsKey(name)) {

            double price = hashMap.remove(name);

            linkedHashMap.remove(name);

            // Remove product from price-based TreeMap
            List<String> products = treeMap.get(price);

            products.remove(name);

            if (products.isEmpty()) {
                treeMap.remove(price);
            }

            System.out.println("Product removed successfully!");

        } else {
            System.out.println("Product not found!");
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get number of products
        System.out.println("Enter number of products:");
        int n = sc.nextInt();

        // Get product details
        for (int i = 0; i < n; i++) {

            System.out.println("Enter product name:");
            String name = sc.next();

            System.out.println("Enter product price:");
            double price = sc.nextDouble();

            addProduct(name, price);
        }

        // Display all products
        displayProducts();

        // Display insertion order
        displayInsertionOrder();

        // Display sorted products
        displaySortedProducts();

        // Calculate total price
        calculateTotal();

        // Remove a product
        System.out.println("\nEnter product name to remove:");
        removeProduct(sc.next());

        // Display updated cart
        displayProducts();

        calculateTotal();

        sc.close();
    }
}
