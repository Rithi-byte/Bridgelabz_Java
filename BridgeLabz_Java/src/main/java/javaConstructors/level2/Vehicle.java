package javaConstructors.level2;
import java.util.Scanner;

/**
 * Represents a vehicle and its registration fee.
 */
class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 1000.0;

    /**
     * Initializes the vehicle details.
     *
     * @param ownerName the vehicle owner's name
     * @param vehicleType the type of vehicle
     */
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    /**
     * Displays the vehicle details and registration fee.
     */
    void displayVehicleDetails() {
        // Display vehicle-specific and shared information.
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    /**
     * Updates the registration fee for all vehicles.
     *
     * @param fee the new registration fee
     */
    static void updateRegistrationFee(double fee) {
        // Update the shared fee if the value is valid.
        if (fee >= 0) {
            registrationFee = fee;
        } else {
            System.out.println("Registration fee cannot be negative.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read details of the first vehicle.
        System.out.print("Enter first owner's name: ");
        String owner1 = sc.nextLine();

        System.out.print("Enter first vehicle type: ");
        String type1 = sc.nextLine();

        // Read details of the second vehicle.
        System.out.print("Enter second owner's name: ");
        String owner2 = sc.nextLine();

        System.out.print("Enter second vehicle type: ");
        String type2 = sc.nextLine();

        // Create two vehicle objects.
        Vehicle v1 = new Vehicle(owner1, type1);
        Vehicle v2 = new Vehicle(owner2, type2);

        // Update the shared registration fee.
        System.out.print("Enter updated registration fee: ");
        double fee = sc.nextDouble();
        Vehicle.updateRegistrationFee(fee);

        // Both vehicles use the same registration fee.
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        sc.close();
    }
}

