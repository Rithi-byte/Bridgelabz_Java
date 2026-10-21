package extras.mixed;

import java.util.Scanner;

/**
 * Converts temperatures between Celsius and Fahrenheit.
 */
public class TemperatureConverter {

    /**
     * Converts Fahrenheit to Celsius.
     *
     * @param fahrenheit temperature in Fahrenheit
     * @return temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    /**
     * Converts Celsius to Fahrenheit.
     *
     * @param celsius temperature in Celsius
     * @return temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        System.out.print("Enter the temperature: ");
        double temperature = sc.nextDouble();

        switch (choice) {
            case 1:
                System.out.printf("Celsius: %.2f%n",
                        fahrenheitToCelsius(temperature));
                break;

            case 2:
                System.out.printf("Fahrenheit: %.2f%n",
                        celsiusToFahrenheit(temperature));
                break;

            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}