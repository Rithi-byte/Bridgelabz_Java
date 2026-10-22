package javaConstructors.level1;

import java.util.Scanner;

/**
 * Represents a car rental and calculates the rental cost.
 */
class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    static final double RATE_PER_DAY = 1500.0;

    /**
     * Initializes a rental with default values.
     */
    CarRental() {
        this("Guest", "Not Selected", 1);
    }

    /**
     * Initializes a rental with user-provided details.
     *
     * @param customerName the customer's name
     * @param carModel the rented car model
     * @param rentalDays the number of rental days
     */
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    /**
     * Calculates the total rental cost.
     *
     * @return the total rental cost
     */
    double calculateTotalCost() {
        // Multiply the daily rate by the number of days.
        return RATE_PER_DAY * rentalDays;
    }

    /**
     * Displays the rental details and total cost.
     */
    void displayDetails() {
        // Print the rental information.
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.printf("Total Cost: %.2f%n", calculateTotalCost());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the rental information.
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter car model: ");
        String model = sc.nextLine();

        System.out.print("Enter rental days: ");
        int days = sc.nextInt();

        if (days <= 0) {
            System.out.println("Rental days must be positive.");
            sc.close();
            return;
        }

        // Create the rental and display its cost.
        CarRental rental = new CarRental(name, model, days);
        rental.displayDetails();

        sc.close();
    }
}
