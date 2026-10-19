package javaMethods.level1;
import java.util.Scanner;

//Created WindChill class to calculate wind chill temperature
public class WindChill {

    /**
     * Calculates the wind chill temperature using temperature and wind speed.
     *
     * @param temperature the air temperature in Fahrenheit
     * @param windSpeed the wind speed in miles per hour
     * @return the calculated wind chill temperature
     */
    public static double calculateWindChill(double temperature, double windSpeed) {
        // Calculate wind chill temperature using the given formula
        double wind_Chill = 35.74 + (0.6215 * temperature)
                + ((0.4275 * temperature) - 35.75) * Math.pow(windSpeed, 0.16);

        // Return the calculated wind chill temperature
        return wind_Chill;
    }

    public static void main(String[] args) {
        // Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Get temperature and wind speed from the user
        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();

        // Call the method to calculate wind chill
        double windChill = calculateWindChill(temperature, windSpeed);

        // Display the result
        System.out.println("Wind chill temperature: " + windChill);

        // Close the Scanner
        sc.close();
    }
}
