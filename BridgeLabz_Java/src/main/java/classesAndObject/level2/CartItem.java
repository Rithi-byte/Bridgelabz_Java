package classesAndObject.level2;

import java.util.Scanner;

/**
 * Represents an item in a shopping cart.
 */
class CartItem {
    String itemName;
    double price;
    int quantity;

    /**
     * Adds the specified quantity of an item to the cart.
     *
     * @param count the quantity to add
     */
    void addItem(int count) {
        // Add only a positive quantity.
        if (count > 0) {
            quantity += count;
            System.out.println("Item quantity added.");
        } else {
            System.out.println("Invalid quantity.");
        }
    }

    /**
     * Removes the specified quantity from the cart.
     *
     * @param count the quantity to remove
     */
    void removeItem(int count) {
        // Remove only a valid quantity that is available.
        if (count <= 0) {
            System.out.println("Invalid quantity.");
        } else if (count <= quantity) {
            quantity -= count;
            System.out.println("Item quantity removed.");
        } else {
            System.out.println("Not enough items in the cart.");
        }
    }

    /**
     * Calculates the total cost of the cart item.
     *
     * @return the total cost
     */
    double calculateTotalCost() {
        // Multiply price by the current quantity.
        return price * quantity;
    }

    /**
     * Displays the item details and total cost.
     */
    void displayDetails() {
        // Display the current cart information.
        System.out.println("Item Name: " + itemName);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Cost: %.2f%n", calculateTotalCost());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartItem item = new CartItem();

        // Read item information.
        System.out.print("Enter item name: ");
        item.itemName = sc.nextLine();

        System.out.print("Enter item price: ");
        item.price = sc.nextDouble();

        if (item.price <= 0) {
            System.out.println("Price must be positive.");
            sc.close();
            return;
        }

        int choice;

        // Perform cart operations until the user exits.
        do {
            System.out.println("\n1. Add item quantity");
            System.out.println("2. Remove item quantity");
            System.out.println("3. Display total cost");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity to add: ");
                    item.addItem(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter quantity to remove: ");
                    item.removeItem(sc.nextInt());
                    break;

                case 3:
                    item.displayDetails();
                    break;

                case 4:
                    System.out.println("Exiting shopping cart.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
