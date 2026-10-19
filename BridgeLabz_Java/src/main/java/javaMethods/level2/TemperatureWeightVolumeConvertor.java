package javaMethods.level2;

//Created TemperatureWeightVolumeConvertor child class
//Inherits methods from DistanceConvertorExtended and UnitConvertor
public class TemperatureWeightVolumeConvertor extends DistanceConvertorExtended {

    /**
     * Converts Fahrenheit to Celsius.
     * @param fahrenheit temperature in Fahrenheit
     * @return temperature in Celsius
     */
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5.0 / 9;
        return fahrenheit2celsius;
    }

    /**
     * Converts Celsius to Fahrenheit.
     * @param celsius temperature in Celsius
     * @return temperature in Fahrenheit
     */
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9.0 / 5) + 32;
        return celsius2fahrenheit;
    }

    /**
     * Converts pounds to kilograms.
     * @param pounds weight in pounds
     * @return weight in kilograms
     */
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    /**
     * Converts kilograms to pounds.
     * @param kilograms weight in kilograms
     * @return weight in pounds
     */
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    /**
     * Converts gallons to liters.
     * @param gallons volume in US gallons
     * @return volume in liters
     */
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    /**
     * Converts liters to gallons.
     * @param liters volume in liters
     * @return volume in US gallons
     */
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        // Call inherited methods from the parent classes
        System.out.println("10 km to miles: " + convertKmToMiles(10));
        System.out.println("10 yards to feet: " + convertYardsToFeet(10));

        // Call temperature conversion methods
        System.out.println("98.6 Fahrenheit to Celsius: "
                + convertFahrenheitToCelsius(98.6));
        System.out.println("37 Celsius to Fahrenheit: "
                + convertCelsiusToFahrenheit(37));

        // Call weight conversion methods
        System.out.println("10 pounds to kilograms: "
                + convertPoundsToKilograms(10));
        System.out.println("10 kilograms to pounds: "
                + convertKilogramsToPounds(10));

        // Call volume conversion methods
        System.out.println("10 gallons to liters: "
                + convertGallonsToLiters(10));
        System.out.println("10 liters to gallons: "
                + convertLitersToGallons(10));
    }
}
