
package encapsulation_Polymorphism_Interface_Abstract;

import java.util.ArrayList;
import java.util.List;

// Interface for items that support discounts
interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

// Abstract parent class
abstract class FoodItem implements Discountable {

    // Encapsulated fields
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter methods
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter methods with basic validation
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    // Abstract method implemented by subclasses
    public abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + applyDiscount());
        System.out.println(getDiscountDetails());
        System.out.println("Total Price: " + calculateTotalPrice());
        System.out.println("----------------------------");
    }
}

// Veg food item with a 5% discount
class VegItem extends FoodItem {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // Total after applying discount
        return getPrice() * getQuantity() - applyDiscount();
    }

    @Override
    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg discount: 5%";
    }
}

// Non-veg food item with an additional charge and 10% discount
class NonVegItem extends FoodItem {

    private double additionalCharge;

    public NonVegItem(String itemName, double price,
                      int quantity, double additionalCharge) {
        super(itemName, price, quantity);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double calculateTotalPrice() {
        double subtotal = getPrice() * getQuantity();
        return subtotal + additionalCharge * getQuantity()
                - applyDiscount();
    }

    @Override
    public double applyDiscount() {
        double subtotal = getPrice() * getQuantity()
                + additionalCharge * getQuantity();
        return subtotal * 0.10;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-veg discount: 10%"
                + ", Additional charge per item: "
                + additionalCharge;
    }
}

// Main class
public class OnlineFoodDeliverySystem {

    // Process different food items using polymorphism
    public static void processOrder(List<FoodItem> items) {
        double grandTotal = 0;

        for (FoodItem item : items) {
            item.getItemDetails();
            grandTotal += item.calculateTotalPrice();
        }

        System.out.println("Grand Total: " + grandTotal);
    }

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        // Create different food items
        FoodItem item1 = new VegItem("Paneer Fried Rice", 200, 2);

        FoodItem item2 = new NonVegItem(
                "Chicken Biryani", 300, 2, 30);

        // Add items to the order
        order.add(item1);
        order.add(item2);

        // Process the complete order
        processOrder(order);
    }
}
