package encapsulation_Polymorphism_Interface_Abstract;

import java.util.ArrayList;
import java.util.List;

// Interface for GPS operations
interface GPS {
    String getCurrentLocation();

    void updateLocation(String location);
}

// Abstract parent class for ride-hailing vehicles
abstract class RideVehicle implements GPS {

    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public RideVehicle(String vehicleId, String driverName,
                       double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Getter methods
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Setter with validation
    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm >= 0) {
            this.ratePerKm = ratePerKm;
        }
    }

    // Abstract fare calculation method
    public abstract double calculateFare(double distance);

    // Implement GPS methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        if (location != null && !location.trim().isEmpty()) {
            currentLocation = location;
            System.out.println("Location updated: " + location);
        } else {
            System.out.println("Invalid location.");
        }
    }

    // Display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per KM: " + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
}

// Car implementation
class RideCar extends RideVehicle {

    public RideCar(String id, String driver,
                   double rate, String location) {
        super(id, driver, rate, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }
}

// Bike implementation
class RideBike extends RideVehicle {

    public RideBike(String id, String driver,
                    double rate, String location) {
        super(id, driver, rate, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 10;
    }
}

// Auto implementation
class RideAuto extends RideVehicle {

    public RideAuto(String id, String driver,
                    double rate, String location) {
        super(id, driver, rate, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }
}

// Main class
public class RideHailingApplication {

    // Demonstrate polymorphism
    public static void calculateRides(
            List<RideVehicle> vehicles, double distance) {

        for (RideVehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();

            System.out.println("Distance: " + distance + " km");
            System.out.println(
                    "Total Fare: " + vehicle.calculateFare(distance));
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {

        List<RideVehicle> vehicles = new ArrayList<>();

        RideVehicle v1 =
                new RideCar("CAR101", "Arun", 20, "Chennai");

        RideVehicle v2 =
                new RideBike("BIKE102", "Priya", 10, "Tambaram");

        RideVehicle v3 =
                new RideAuto("AUTO103", "Raj", 15, "Chromepet");

        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        // Update location
        v1.updateLocation("Guindy");

        // Calculate fares
        calculateRides(vehicles, 10);
    }
}
