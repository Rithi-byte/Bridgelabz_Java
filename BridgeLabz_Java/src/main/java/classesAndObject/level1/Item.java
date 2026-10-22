package classesAndObject.level1;

import java.util.Scanner;

/**
 * Represents an inventory item and calculates its total cost.
 */
class Item {
    int itemCode;
    String itemName;
    double price;

    /**
     * Displays the item's code, name, and price.
     */
    void displayDetails() {
        // Display item information.
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    /**
     * Calculates the total cost for the specified quantity.
     *
     * @param quantity the number of items
     * @return the total cost
     */
    double calculateTotalCost(int quantity) {
        // Multiply the unit price by the quantity.
        return price * quantity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item i1 = new Item();

        // Read item details from the user.
        System.out.print("Enter item code: ");
        i1.itemCode = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter item name: ");
        i1.itemName = sc.nextLine();

        System.out.print("Enter price: ");
        i1.price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        // Display item details and calculate the total cost.
        i1.displayDetails();
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Cost: %.2f%n",
                i1.calculateTotalCost(quantity));

        sc.close();
    }
}
