
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

class EcommerceProduct {
    String name;
    double price;

    EcommerceProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class EcommerceCustomer {
    String name;

    EcommerceCustomer(String name) {
        this.name = name;
    }

    EcommerceOrder placeOrder() {
        return new EcommerceOrder(this);
    }
}

class EcommerceOrder {
    EcommerceCustomer customer;
    ArrayList<EcommerceProduct> products = new ArrayList<>();

    EcommerceOrder(EcommerceCustomer customer) {
        this.customer = customer;
    }

    void addProduct(EcommerceProduct product) {
        products.add(product);
    }

    void displayOrder() {
        double total = 0;

        System.out.println("\nCustomer: " + customer.name);
        System.out.println("Order Details:");

        for (EcommerceProduct product : products) {
            System.out.println(product.name + " - Rs. " + product.price);
            total += product.price;
        }

        System.out.println("Total Amount: Rs. " + total);
    }
}

public class EcommerceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        EcommerceCustomer customer =
                new EcommerceCustomer(sc.nextLine());

        EcommerceOrder order = customer.placeOrder();

        System.out.print("Enter first product name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first product price: ");
        double price1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter second product name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second product price: ");
        double price2 = sc.nextDouble();

        order.addProduct(new EcommerceProduct(name1, price1));
        order.addProduct(new EcommerceProduct(name2, price2));

        order.displayOrder();

        sc.close();
    }
}
