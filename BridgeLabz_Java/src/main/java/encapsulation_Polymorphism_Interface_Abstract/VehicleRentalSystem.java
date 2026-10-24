
package encapsulation_Polymorphism_Interface_Abstract;

import java.util.ArrayList;
import java.util.List;

// Interface defining insurance-related operations
interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

// Abstract parent class for all vehicles
abstract class Vehicle implements Insurable {

    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Sensitive information is encapsulated
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type,
                   double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Getter methods
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Setter methods
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRentalRate(double rentalRate) {
        if (rentalRate >= 0) {
            this.rentalRate = rentalRate;
        }
    }

    // Abstract method implemented by subclasses
    public abstract double calculateRentalCost(int days);

    // Calculate insurance using a category-specific rate
    @Override
    public double calculateInsurance() {
        return rentalRate * getInsuranceRate() / 100.0;
    }

    // Subclasses define their insurance rates
    protected abstract double getInsuranceRate();

    // Return insurance details without exposing the full policy number
    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: " + getInsuranceRate()
                + "%, Insurance Cost: " + calculateInsurance()
                + ", Policy: ****"
                + insurancePolicyNumber.substring(
                Math.max(0, insurancePolicyNumber.length() - 4));
    }

    // Display vehicle and cost details
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
        System.out.println("Rental Duration: " + days + " days");
        System.out.println("Rental Cost: " + calculateRentalCost(days));
        System.out.println(getInsuranceDetails());
        System.out.println("--------------------------------");
    }
}

// Car implementation
class Car extends Vehicle {

    public Car(String number, double rate, String policyNumber) {
        super(number, "Car", rate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    protected double getInsuranceRate() {
        return 10.0;
    }
}

// Bike implementation
class Bike extends Vehicle {

    public Bike(String number, double rate, String policyNumber) {
        super(number, "Bike", rate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    protected double getInsuranceRate() {
        return 5.0;
    }
}

// Truck implementation
class Truck extends Vehicle {

    public Truck(String number, double rate, String policyNumber) {
        super(number, "Truck", rate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Trucks have an additional 20% service charge
        return getRentalRate() * days * 1.20;
    }

    @Override
    protected double getInsuranceRate() {
        return 15.0;
    }
}

// Main class
public class VehicleRentalSystem {

    public static void displayVehicles(
            List<Vehicle> vehicles, int days) {

        // Runtime polymorphism
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails(days);
        }
    }

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("TN01AB1234", 2000, "CAR12345"));
        vehicles.add(new Bike("TN02CD5678", 500, "BIKE6789"));
        vehicles.add(new Truck("TN03EF9012", 5000, "TRUCK9876"));

        int rentalDays = 3;

        displayVehicles(vehicles, rentalDays);
    }
}
