package javaMethods.level1;
import java.util.Scanner;

//Created TrigonometricFunctions class to calculate sine, cosine and tangent
public class TrigonometricFunctions {

    /**
     * Calculates sine, cosine and tangent for a given angle in degrees.
     *
     * @param angle the angle in degrees
     * @return a double array containing sine at index 0,
     *         cosine at index 1 and tangent at index 2
     */
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert the angle from degrees to radians
        double radians = Math.toRadians(angle);

        // Calculate sine, cosine and tangent
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        // Return the trigonometric values as an array
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        // Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Get angle in degrees from the user
        double angle = sc.nextDouble();

        // Call the method to calculate trigonometric functions
        double[] result = calculateTrigonometricFunctions(angle);

        // Display the results
        System.out.println("Sine: " + result[0]);
        System.out.println("Cosine: " + result[1]);
        System.out.println("Tangent: " + result[2]);

        // Close the Scanner
        sc.close();
    }
}