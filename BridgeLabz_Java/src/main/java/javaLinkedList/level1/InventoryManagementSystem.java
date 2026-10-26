package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 4. Singly Linked List: Inventory Management System
 *
 * Problem Statement:
 * Design an inventory management system using a singly linked list.
 * Each node stores Item Name, Item ID, Quantity, and Price.
 *
 * Functionalities:
 * 1. Add an item at the beginning, end, or a specific position.
 * 2. Remove an item by Item ID.
 * 3. Update the quantity using Item ID.
 * 4. Search for an item by Item ID or Item Name.
 * 5. Calculate the total inventory value.
 * 6. Sort inventory by Item Name or Price in ascending or descending order.
 */

// Represents an inventory item and its details.
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;

    // Initializes an item with the given details.
    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    // Displays the details of an item.
    void display() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Item ID: " + itemId);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("Item Value: " + (price * quantity));
        System.out.println("----------------------------");
    }
}

// Represents a node in the singly linked list.
class ItemNode {
    Item data;
    ItemNode next;

    // Creates a node containing an inventory item.
    ItemNode(Item data) {
        this.data = data;
        this.next = null;
    }
}

public class InventoryManagementSystem {

    // Head points to the first node of the list.
    ItemNode head;

    /**
     * Adds an item at the beginning of the list.
     */
    void addAtBeginning(Item item) {
        ItemNode newNode = new ItemNode(item);

        // Connect the new node to the current first node.
        newNode.next = head;

        // Make the new node the head.
        head = newNode;

        System.out.println("Item added at the beginning.");
    }

    /**
     * Adds an item at the end of the list.
     */
    void addAtEnd(Item item) {
        ItemNode newNode = new ItemNode(item);

        // If the list is empty, the new node becomes head.
        if (head == null) {
            head = newNode;
            System.out.println("Item added at the end.");
            return;
        }

        ItemNode current = head;

        // Traverse until the last node is reached.
        while (current.next != null) {
            current = current.next;
        }

        // Connect the last node to the new node.
        current.next = newNode;

        System.out.println("Item added at the end.");
    }

    /**
     * Adds an item at a specific position.
     * Positions start from 1.
     */
    void addAtPosition(Item item, int position) {

        // Reject invalid positions.
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        // Position 1 means insertion at the beginning.
        if (position == 1) {
            addAtBeginning(item);
            return;
        }

        ItemNode current = head;

        // Move to the node immediately before the target position.
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        // If current is null, the position is out of range.
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        ItemNode newNode = new ItemNode(item);

        // Insert the new node into the list.
        newNode.next = current.next;
        current.next = newNode;

        System.out.println("Item added at position " + position + ".");
    }

    /**
     * Removes an item using its Item ID.
     */
    void removeByItemId(int itemId) {

        // Handle an empty inventory.
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // Handle deletion of the first node.
        if (head.data.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }

        ItemNode current = head;

        // Find the node immediately before the target item.
        while (current.next != null &&
                current.next.data.itemId != itemId) {
            current = current.next;
        }

        // If the item does not exist, report it.
        if (current.next == null) {
            System.out.println("Item not found.");
            return;
        }

        // Skip the target node to remove it.
        current.next = current.next.next;

        System.out.println("Item removed successfully.");
    }

    /**
     * Updates the quantity of an item using its Item ID.
     */
    void updateQuantity(int itemId, int newQuantity) {

        // Quantity cannot be negative.
        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        ItemNode current = head;

        // Search for the item by its ID.
        while (current != null) {
            if (current.data.itemId == itemId) {

                // Update the quantity.
                current.data.quantity = newQuantity;

                System.out.println("Quantity updated successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Item not found.");
    }

    /**
     * Searches for an item using its Item ID.
     */
    void searchByItemId(int itemId) {
        ItemNode current = head;

        // Traverse the list looking for the specified ID.
        while (current != null) {
            if (current.data.itemId == itemId) {
                System.out.println("Item found:");
                current.data.display();
                return;
            }

            current = current.next;
        }

        System.out.println("Item not found.");
    }

    /**
     * Searches for items using their names.
     */
    void searchByItemName(String itemName) {
        ItemNode current = head;
        boolean found = false;

        // Display every item whose name matches.
        while (current != null) {
            if (current.data.itemName.equalsIgnoreCase(itemName)) {
                current.data.display();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    /**
     * Displays all inventory items.
     */
    void displayAll() {

        // Check whether the inventory is empty.
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        ItemNode current = head;

        // Traverse and display each item.
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }

    /**
     * Calculates the total value of the inventory.
     * Total value = Sum of (Price * Quantity).
     */
    void calculateTotalValue() {
        double total = 0;
        ItemNode current = head;

        // Add the value of each item to the total.
        while (current != null) {
            total += current.data.price * current.data.quantity;
            current = current.next;
        }

        System.out.printf("Total Inventory Value: %.2f%n", total);
    }

    /**
     * Sorts the inventory by item name or price.
     *
     * sortBy = 1: Item Name
     * sortBy = 2: Price
     *
     * order = 1: Ascending
     * order = 2: Descending
     */
    void sortInventory(int sortBy, int order) {

        // Sorting an empty list or a single-node list is unnecessary.
        if (head == null || head.next == null) {
            System.out.println("Inventory sorted successfully.");
            displayAll();
            return;
        }

        // Use bubble sort by swapping item data between nodes.
        for (ItemNode i = head; i.next != null; i = i.next) {

            for (ItemNode j = head; j.next != null; j = j.next) {

                int comparison;

                // Compare items by name.
                if (sortBy == 1) {
                    comparison = j.data.itemName.compareToIgnoreCase(
                            j.next.data.itemName);
                }
                // Compare items by price.
                else {
                    comparison = Double.compare(
                            j.data.price, j.next.data.price);
                }

                // Reverse the comparison for descending order.
                if (order == 2) {
                    comparison = -comparison;
                }

                // Swap item references if the current pair is out of order.
                if (comparison > 0) {
                    Item temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }

        System.out.println("Inventory sorted successfully.");
        displayAll();
    }

    /**
     * Main method: displays the menu and accepts user input.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem inventory =
                new InventoryManagementSystem();

        int choice;

        // Repeat until the user chooses to exit.
        do {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Specific Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Item Quantity");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Sort Inventory");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                case 2:
                case 3: {
                    // Read the item's details.
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    // Validate quantity and price.
                    if (quantity < 0 || price < 0) {
                        System.out.println(
                                "Quantity and price cannot be negative.");
                        break;
                    }

                    Item item = new Item(name, id, quantity, price);

                    // Perform the selected insertion operation.
                    if (choice == 1) {
                        inventory.addAtBeginning(item);
                    } else if (choice == 2) {
                        inventory.addAtEnd(item);
                    } else {
                        System.out.print("Enter position: ");
                        int position = sc.nextInt();
                        sc.nextLine();

                        inventory.addAtPosition(item, position);
                    }

                    break;
                }

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    inventory.removeByItemId(sc.nextInt());
                    sc.nextLine();
                    break;

                case 5:
                    System.out.print("Enter Item ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();

                    inventory.updateQuantity(updateId, newQuantity);
                    break;

                case 6:
                    System.out.print("Enter Item ID to search: ");
                    inventory.searchByItemId(sc.nextInt());
                    sc.nextLine();
                    break;

                case 7:
                    System.out.print("Enter Item Name to search: ");
                    inventory.searchByItemName(sc.nextLine());
                    break;

                case 8:
                    inventory.displayAll();
                    break;

                case 9:
                    inventory.calculateTotalValue();
                    break;

                case 10:
                    System.out.println("Sort by:");
                    System.out.println("1. Item Name");
                    System.out.println("2. Price");
                    System.out.print("Enter choice: ");
                    int sortBy = sc.nextInt();

                    System.out.println("Sort order:");
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.print("Enter choice: ");
                    int order = sc.nextInt();
                    sc.nextLine();

                    // Validate sorting options.
                    if ((sortBy == 1 || sortBy == 2) &&
                            (order == 1 || order == 2)) {
                        inventory.sortInventory(sortBy, order);
                    } else {
                        System.out.println("Invalid sorting option.");
                    }

                    break;

                case 11:
                    System.out.println("Exiting Inventory Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 11);

        sc.close();
    }
}