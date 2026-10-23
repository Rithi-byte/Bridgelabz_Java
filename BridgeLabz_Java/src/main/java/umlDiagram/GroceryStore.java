package umlDiagram;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    String productName;
    double quantity;
    double pricePerUnit;

    Product(String productName, double quantity,
            double pricePerUnit) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    double calculatePrice() {
        return quantity * pricePerUnit;
    }
}

class Customer {
    String name;
    int customerId;
    List<Product> products = new ArrayList<>();

    Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    void addProduct(Product product) {
        products.add(product);
    }
}

class BillGenerator {
    void generateBill(Customer customer) {
        double total = 0;

        System.out.println("\n--- Grocery Bill ---");
        System.out.println("Customer: " + customer.name);
        System.out.println("Customer ID: " + customer.customerId);

        for (Product product : customer.products) {
            double price = product.calculatePrice();

            System.out.printf(
                    "%s: %.2f x $%.2f = $%.2f%n",
                    product.productName,
                    product.quantity,
                    product.pricePerUnit,
                    price
            );

            total += price;
        }

        System.out.printf("Total Bill: $%.2f%n", total);
    }
}

public class GroceryStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter customer ID: ");
        int customerId = sc.nextInt();
        sc.nextLine();

        Customer customer = new Customer(name, customerId);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1));

            System.out.print("Enter product name: ");
            String productName = sc.nextLine();

            System.out.print("Enter quantity: ");
            double quantity = sc.nextDouble();

            System.out.print("Enter price per unit: ");
            double price = sc.nextDouble();
            sc.nextLine();

            Product product =
                    new Product(productName, quantity, price);

            customer.addProduct(product);
        }

        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(customer);

        sc.close();
    }
}
