package thisstaticfinalinstanceof.level1;
import java.util.Scanner;

class Product {
    static double discount = 10.0;

    String productName;
    double price;
    int quantity;
    final int productID;

    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayDetails() {
        double total = price * quantity;
        double finalPrice = total - (total * discount / 100);

        System.out.println("Product: " + productName);
        System.out.println("Product ID: " + productID);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: " + finalPrice);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter discount percentage: ");
        double newDiscount = sc.nextDouble();

        Product product = new Product(name, price, quantity, id);
        updateDiscount(newDiscount);

        Object obj = product;
        if (obj instanceof Product) {
            ((Product) obj).displayDetails();
        }

        sc.close();
    }
}

