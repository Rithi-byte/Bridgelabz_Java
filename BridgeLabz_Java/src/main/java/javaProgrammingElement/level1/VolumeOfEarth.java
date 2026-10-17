package javaProgrammingElement.level1;
//Created VolumeOfEarth Class to compute the volume of Earth in cubic km and cubic miles
public class VolumeOfEarth {
    public static void main(String[] args) {

        // Create variables for Earth's radius in km and the km in one mile
        double radiusInKm = 6378;
        double kmPerMile = 1.6;

        // Create variable to store Volume of a sphere = (4/3) * pi * r^3  (4.0 avoids integer division: 4/3 would be 1)
        double volumeInCubicKm = (4.0 / 3) * Math.PI * Math.pow(radiusInKm, 3);

        // Convert the radius to miles and compute the volume in cubic miles
        double radiusInMiles = radiusInKm / kmPerMile;
        double volumeInCubicMiles = (4.0 / 3) * Math.PI * Math.pow(radiusInMiles, 3);

        // Display the result
        System.out.println("The volume of earth in cubic kilometers is " + volumeInCubicKm
                + " and cubic miles is " + volumeInCubicMiles);
    }
}
