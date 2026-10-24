
package encapsulation_Polymorphism_Interface_Abstract;

import java.util.ArrayList;
import java.util.List;

// Interface for products that support tax calculation
interface Taxable {

    double calculateTax();

    String getTaxDetails();
}

// Abstract parent class for all products
abstract class Product implements Taxable {

    // Encapsulated fields
    private String productId;
    private String name;
    private double price;
    private double taxRate;

    // Constructor to initialize product details
    public Product(String productId, String name,
                   double price, double taxRate) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    // Getter methods
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTaxRate() {
        return taxRate;
    }

    // Setter methods with basic validation
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setTaxRate(double taxRate) {
        if (taxRate >= 0) {
            this.taxRate = taxRate;
        }
    }

    // Calculate tax based on price and tax rate
    @Override
    public double calculateTax() {
        return price * taxRate / 100.0;
    }

    // Return tax information
    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + taxRate + "%"
                + ", Tax Amount: " + calculateTax();
    }

    // Abstract method implemented by each product category
    public abstract double calculateDiscount();

    // Display product information
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println(getTaxDetails());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Final Price: " + calculateFinalPrice());
        System.out.println("--------------------------------");
    }

    // Calculate final price after tax and discount
    public double calculateFinalPrice() {
        return price + calculateTax() - calculateDiscount();
    }
}

// Electronics category: 10% discount
class Electronics extends Product {

    public Electronics(String id, String name,
                       double price, double taxRate) {
        super(id, name, price, taxRate);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }
}

// Clothing category: 15% discount
class Clothing extends Product {

    public Clothing(String id, String name,
                    double price, double taxRate) {
        super(id, name, price, taxRate);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }
}

// Groceries category: 5% discount
class Groceries extends Product {

    public Groceries(String id, String name,
                     double price, double taxRate) {
        super(id, name, price, taxRate);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

// Main class
public class EcommercePlatform {

    // Process products using a parent-class reference
    public static void displayProducts(List<Product> products) {
        for (Product product : products) {
            product.displayDetails();
        }
    }

    public static void main(String[] args) {

        // Store different product types in one list
        List<Product> products = new ArrayList<>();

        Product p1 = new Electronics(
                "E101", "Laptop", 50000, 18);

        Product p2 = new Clothing(
                "C101", "Shirt", 2000, 5);

        Product p3 = new Groceries(
                "G101", "Rice", 1000, 0);

        // Add products to the list
        products.add(p1);
        products.add(p2);
        products.add(p3);

        // Display each product and its calculated final price
        displayProducts(products);
    }
}
