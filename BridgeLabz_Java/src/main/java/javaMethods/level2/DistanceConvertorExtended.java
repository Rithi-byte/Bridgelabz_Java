package javaMethods.level2;

//Created DistanceConvertorExtended child class
//Inherited distance conversion methods from UnitConvertor
public class DistanceConvertorExtended extends UnitConvertor {

    /**
     * Converts yards to feet.
     * @param yards distance in yards
     * @return distance in feet
     */
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    /**
     * Converts feet to yards.
     * @param feet distance in feet
     * @return distance in yards
     */
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    /**
     * Converts meters to inches.
     * @param meters distance in meters
     * @return distance in inches
     */
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    /**
     * Converts inches to meters.
     * @param inches distance in inches
     * @return distance in meters
     */
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    /**
     * Converts inches to centimeters.
     * @param inches distance in inches
     * @return distance in centimeters
     */
    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        // Call inherited methods from UnitConvertor
        System.out.println("10 km to miles: "
                + UnitConvertor.convertKmToMiles(10));

        // Call methods defined in this child class
        System.out.println("10 yards to feet: " + convertYardsToFeet(10));
        System.out.println("10 feet to yards: " + convertFeetToYards(10));
        System.out.println("10 meters to inches: " + convertMetersToInches(10));
        System.out.println("10 inches to meters: " + convertInchesToMeters(10));
        System.out.println("10 inches to cm: " + convertInchesToCm(10));
    }
}
