
package thisstaticfinalinstanceof.level1;

import java.util.Scanner;

/**
 * Represents a vehicle and demonstrates static, final, this,
 * and instanceof concepts in Java.
 */
class Vehicle {

    // Shared registration fee used by all Vehicle objects.
    static double registrationFee = 1500.0;

    // Instance variables store the vehicle owner's details.
    String ownerName;
    String vehicleType;

    // The registration number is assigned once and cannot be reassigned.
    final String registrationNumber;

    /**
     * Initializes a vehicle with its owner, type, and registration number.
     *
     * @param ownerName the vehicle owner's name
     * @param vehicleType the type of vehicle
     * @param registrationNumber the vehicle's registration number
     */
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    /**
     * Updates the shared vehicle registration fee.
     *
     * @param newFee the new registration fee
     */
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    /**
     * Displays the vehicle details and current registration fee.
     */
    void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }

    /**
     * Executes the vehicle registration demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the vehicle owner's name.
        System.out.print("Enter owner name: ");
        String owner = sc.nextLine();

        // Read the type of vehicle.
        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();

        // Read the vehicle's registration number.
        System.out.print("Enter registration number: ");
        String number = sc.nextLine();

        // Read the registration fee.
        System.out.print("Enter registration fee: ");
        double fee = sc.nextDouble();

        // Create a Vehicle object using the entered details.
        Vehicle vehicle = new Vehicle(owner, type, number);

        // Update the shared registration fee.
        updateRegistrationFee(fee);

        // Store the Vehicle reference in a variable of type Object.
        Object obj = vehicle;

        // Check the object's type before casting and displaying details.
        if (obj instanceof Vehicle) {
            ((Vehicle) obj).displayDetails();
        }

        // Close the Scanner after input is complete.
        sc.close();
    }
}
