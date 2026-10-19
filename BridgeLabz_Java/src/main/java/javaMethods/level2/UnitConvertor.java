package javaMethods.level2;

//Created UnitConvertor parent class for distance conversions
public class UnitConvertor {

    /**
     * Converts kilometers to miles.
     * @param km distance in kilometers
     * @return distance in miles
     */
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    /**
     * Converts miles to kilometers.
     * @param miles distance in miles
     * @return distance in kilometers
     */
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    /**
     * Converts meters to feet.
     * @param meters distance in meters
     * @return distance in feet
     */
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    /**
     * Converts feet to meters.
     * @param feet distance in feet
     * @return distance in meters
     */
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        // Display distance conversions
        System.out.println("10 km to miles: " + convertKmToMiles(10));
        System.out.println("10 miles to km: " + convertMilesToKm(10));
        System.out.println("10 meters to feet: " + convertMetersToFeet(10));
        System.out.println("10 feet to meters: " + convertFeetToMeters(10));
    }
}
