package thisstaticfinalinstanceof.level1;
import java.util.Scanner;

class Vehicle {
    static double registrationFee = 1500.0;

    String ownerName;
    String vehicleType;
    final String registrationNumber;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter owner name: ");
        String owner = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();

        System.out.print("Enter registration number: ");
        String number = sc.nextLine();

        System.out.print("Enter registration fee: ");
        double fee = sc.nextDouble();

        Vehicle vehicle = new Vehicle(owner, type, number);
        updateRegistrationFee(fee);

        Object obj = vehicle;
        if (obj instanceof Vehicle) {
            ((Vehicle) obj).displayDetails();
        }

        sc.close();
    }
}
