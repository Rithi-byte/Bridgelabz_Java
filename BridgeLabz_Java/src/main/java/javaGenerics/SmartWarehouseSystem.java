package javaGenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Problem:
 * Develop a Smart Warehouse System to manage different types
 * of items such as Electronics, Groceries, and Furniture.
 *
 * Purpose:
 * Store and retrieve different item types dynamically
 * while maintaining type safety using Java Generics.
 */

// 1. Created WarehouseItem: Abstract parent class for all warehouse items.
// Purpose: Stores common item details such as ID and name.
// Special: Uses a static counter to generate unique IDs and an abstract display() method.
abstract class WarehouseItem {

    // Shared counter for generating unique IDs
    static int counter = 100;

    int id;
    String name;

    // Automatically generates a unique ID
    WarehouseItem(String name) {
        this.id = ++counter;
        this.name = name;
    }

    abstract void display();
}

// 2. Created Electronics: Represents electronic products in the warehouse.
// Purpose: Stores and displays electronic item details.
// Special: Inherits common properties from WarehouseItem and overrides display().
class Electronics extends WarehouseItem {

    Electronics(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Electronics : " + id + " - " + name);
    }
}

// 3. Created Groceries: Represents grocery products in the warehouse.
// Purpose: Stores and displays grocery item details.
// Special: Inherits common properties from WarehouseItem and overrides display().
class Groceries extends WarehouseItem {

    Groceries(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Groceries : " + id + " - " + name);
    }
}

// 4. Created Furniture: Represents furniture products in the warehouse.
// Purpose: Stores and displays furniture item details.
// Special: Inherits common properties from WarehouseItem and overrides display().
class Furniture extends WarehouseItem {

    Furniture(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Furniture : " + id + " - " + name);
    }
}

// 5. Created Storage<T>: Generic storage class for warehouse items.
// Purpose: Stores items of a particular type using an ArrayList.
// Special: Uses bounded generics to ensure T is always a WarehouseItem or its subclass.
class Storage<T extends WarehouseItem> {

    ArrayList<T> items = new ArrayList<>();

    // Adds an item to storage
    void addItem(T item) {
        items.add(item);
    }

    // Wildcard method to display different types of warehouse items
    // ? extends WarehouseItem allows lists containing WarehouseItem subclasses.
    void displayItems(List<? extends WarehouseItem> items) {

        for (WarehouseItem item : items) {
            item.display();
        }
    }
}

// 6. Created SmartWarehouseSystem: Main class of the warehouse application.
// Purpose: Provides a menu-driven interface to add and display warehouse items.
// Special: Uses separate generic Storage objects for Electronics, Groceries, and Furniture.
public class SmartWarehouseSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating storage objects for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        int choice;

        // Menu-driven program
        do {

            System.out.println("\n===== SMART WAREHOUSE MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Electronics");
            System.out.println("2. Add Groceries");
            System.out.println("3. Add Furniture");
            System.out.println("4. Display All Items");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number of electronics: ");
                    int e = sc.nextInt();

                    for (int i = 0; i < e; i++) {

                        System.out.print("Enter electronics name: ");
                        String name = sc.next();

                        electronicsStorage.addItem(
                                new Electronics(name)
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter number of groceries: ");
                    int g = sc.nextInt();

                    for (int i = 0; i < g; i++) {

                        System.out.print("Enter grocery name: ");
                        String name = sc.next();

                        groceriesStorage.addItem(
                                new Groceries(name)
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter number of furniture items: ");
                    int f = sc.nextInt();

                    for (int i = 0; i < f; i++) {

                        System.out.print("Enter furniture name: ");
                        String name = sc.next();

                        furnitureStorage.addItem(
                                new Furniture(name)
                        );
                    }
                    break;

                case 4:

                    System.out.println("\n===== WAREHOUSE ITEMS =====");

                    System.out.println("\nElectronics:");
                    electronicsStorage.displayItems(electronicsStorage.items);

                    System.out.println("\nGroceries:");
                    groceriesStorage.displayItems(groceriesStorage.items);

                    System.out.println("\nFurniture:");
                    furnitureStorage.displayItems(furnitureStorage.items);

                    break;

                case 5:
                    System.out.println("Exiting Warehouse System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}