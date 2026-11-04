
package javaGenerics;

import java.util.ArrayList;
import java.util.Scanner;

// 1. Created ProductCategory: Abstract parent class for all product categories.
// Purpose: Defines a common structure for different product categories.
// Special: Abstract method must be implemented by every child class.
abstract class ProductCategory {

    abstract String getCategoryName();
}

// 2. Created BookCategory: Represents the Books product category.
// Purpose: Identifies products belonging to the Books category.
// Special: Inherits ProductCategory and returns its category name.
class BookCategory extends ProductCategory {

    @Override
    String getCategoryName() {
        return "Books";
    }
}

// 3. Created ClothingCategory: Represents the Clothing product category.
// Purpose: Identifies products belonging to the Clothing category.
// Special: Inherits ProductCategory and returns its category name.
class ClothingCategory extends ProductCategory {

    @Override
    String getCategoryName() {
        return "Clothing";
    }
}

// 4. Created GadgetCategory: Represents the Gadgets product category.
// Purpose: Identifies products belonging to the Gadgets category.
// Special: Inherits ProductCategory and returns its category name.
class GadgetCategory extends ProductCategory {

    @Override
    String getCategoryName() {
        return "Gadgets";
    }
}

// 5. Created Product<T>: Represents an individual marketplace product.
// Purpose: Stores product ID, name, price, and category.
// Special: Generic class with bounded type parameter
// T extends ProductCategory ensures only valid product categories are accepted.
class Product<T extends ProductCategory> {

    // Static counter shared by all Product objects for unique ID generation.
    static int counter = 100;

    int id;
    String name;
    double price;
    T category;

    // Constructor initializes product details and generates a unique ID.
    Product(String name, double price, T category) {

        this.id = ++counter;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Displays complete product details.
    void display() {

        System.out.println(
                "ID: " + id +
                        " | Name: " + name +
                        " | Category: " + category.getCategoryName() +
                        " | Price: Rs." + price
        );
    }
}

// 6. Created Marketplace: Manages all marketplace products.
// Purpose: Adds products, applies discounts, and displays the catalog.
// Special: Uses ArrayList<Product<?>> to store different product categories
// together and a generic method to apply discounts to different product types.
class Marketplace {

    // Stores different Product objects belonging to different categories.
    // ? allows any valid Product category to be stored.
    ArrayList<Product<?>> catalog = new ArrayList<>();

    // Adds any valid Product object to the marketplace catalog.
    void addProduct(Product<?> product) {
        catalog.add(product);
    }

    // Generic method with bounded type parameter.
    // T extends Product<?> restricts the method to Product objects.
    // Accepts products belonging to any valid product category.
    <T extends Product<?>> void applyDiscount(
            T product, double percentage
    ) {

        // Calculates discount amount based on the product price.
        double discount = product.price * percentage / 100;

        // Updates the original product price after applying discount.
        product.price = product.price - discount;

        System.out.println(
                "Discount applied: " + percentage + "%"
        );

        System.out.println(
                "Discount amount: Rs." + discount
        );

        System.out.println(
                "Final price: Rs." + product.price
        );
    }

    // Displays all products stored in the marketplace.
    void displayProducts() {

        // Iterates through products of different categories using wildcard.
        for (Product<?> product : catalog) {
            product.display();
        }
    }
}

// 7. Created OnlineMarketSystem: Main class of the application.
// Purpose: Accepts user input and manages marketplace operations.
// Special: Uses Scanner, switch-case, and a menu-driven loop
// to add products, apply discounts, and display the product catalog.
public class OnlineMarketSystem {

    public static void main(String[] args) {

        // Scanner object to accept user input.
        Scanner sc = new Scanner(System.in);

        // Creating Marketplace object to manage products.
        Marketplace marketplace = new Marketplace();

        int choice;

        // Menu-driven application continues until the user exits.
        do {

            System.out.println("\n===== ONLINE MARKETPLACE =====");

            System.out.println("1. Add Book");
            System.out.println("2. Add Clothing");
            System.out.println("3. Add Gadget");
            System.out.println("4. Apply Discount");
            System.out.println("5. Display Products");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Creates and adds a Book product.
                case 1: {

                    System.out.print("Enter book name: ");
                    String name = sc.next();

                    System.out.print("Enter book price: ");
                    double price = sc.nextDouble();

                    // T is inferred as BookCategory.
                    Product<BookCategory> book =
                            new Product<>(
                                    name,
                                    price,
                                    new BookCategory()
                            );

                    marketplace.addProduct(book);

                    System.out.println("Book added successfully!");
                    break;
                }

                // Creates and adds a Clothing product.
                case 2: {

                    System.out.print("Enter clothing name: ");
                    String name = sc.next();

                    System.out.print("Enter clothing price: ");
                    double price = sc.nextDouble();

                    // T is inferred as ClothingCategory.
                    Product<ClothingCategory> clothing =
                            new Product<>(
                                    name,
                                    price,
                                    new ClothingCategory()
                            );

                    marketplace.addProduct(clothing);

                    System.out.println("Clothing added successfully!");
                    break;
                }

                // Creates and adds a Gadget product.
                case 3: {

                    System.out.print("Enter gadget name: ");
                    String name = sc.next();

                    System.out.print("Enter gadget price: ");
                    double price = sc.nextDouble();

                    // T is inferred as GadgetCategory.
                    Product<GadgetCategory> gadget =
                            new Product<>(
                                    name,
                                    price,
                                    new GadgetCategory()
                            );

                    marketplace.addProduct(gadget);

                    System.out.println("Gadget added successfully!");
                    break;
                }

                // Applies discount to a selected product using its ID.
                case 4: {

                    // Checks whether the catalog is empty.
                    if (marketplace.catalog.isEmpty()) {
                        System.out.println("No products available!");
                        break;
                    }

                    System.out.println("\nAvailable Products:");

                    marketplace.displayProducts();

                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter discount percentage: ");
                    double percentage = sc.nextDouble();

                    // Wildcard reference can hold any Product category.
                    Product<?> selected = null;

                    // Searches for the product using its unique ID.
                    for (Product<?> product : marketplace.catalog) {

                        if (product.id == id) {
                            selected = product;
                            break;
                        }
                    }

                    // Checks whether the product exists.
                    if (selected != null) {

                        // Validates discount percentage.
                        if (percentage < 0 || percentage > 100) {
                            System.out.println("Invalid discount!");
                        } else {

                            // Calls the generic discount method.
                            marketplace.applyDiscount(
                                    selected, percentage
                            );
                        }

                    } else {
                        System.out.println("Product not found!");
                    }

                    break;
                }

                // Displays all products in the marketplace.
                case 5:

                    System.out.println("\n===== PRODUCT CATALOG =====");
                    marketplace.displayProducts();
                    break;

                // Exits the application.
                case 6:

                    System.out.println("Exiting Marketplace...");
                    break;

                // Handles invalid menu choices.
                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        // Closes Scanner after program execution.
        sc.close();
    }
}
