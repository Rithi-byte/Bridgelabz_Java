package classesAndObject.level1;

import java.util.Scanner;

/**
 * Represents a mobile phone and displays its details.
 */
class MobilePhone {
    String brand;
    String model;
    double price;

    /**
     * Displays the phone's brand, model, and price.
     */
    void displayDetails() {
        // Display mobile phone information.
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MobilePhone m1 = new MobilePhone();

        // Read phone details from the user.
        System.out.print("Enter brand: ");
        m1.brand = sc.nextLine();

        System.out.print("Enter model: ");
        m1.model = sc.nextLine();

        System.out.print("Enter price: ");
        m1.price = sc.nextDouble();

        // Display the entered phone details.
        m1.displayDetails();
        sc.close();
    }
}

