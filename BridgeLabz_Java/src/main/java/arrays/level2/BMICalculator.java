
package arrays.level2;

import java.util.Scanner;

/**
 * Calculates BMI and weight status for multiple individuals using arrays.
 */
public class BMICalculator {

    /**
     * Reads weight and height, calculates BMI, and displays each person's
     * weight status according to the provided BMI classification.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int number = input.nextInt();

        // Validate the number of persons
        if (number <= 0) {
            System.out.println("Invalid number of persons.");
            input.close();
            return;
        }

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] weightStatus = new String[number];

        // Read and validate weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter weight in kg: ");
            weight[i] = input.nextDouble();

            System.out.print("Enter height in meters: ");
            height[i] = input.nextDouble();

            // Repeat input if weight or height is invalid
            if (weight[i] <= 0 || height[i] <= 0) {
                System.out.println("Enter positive weight and height again.");
                i--;
            }
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < number; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the BMI report
        System.out.println("\nHeight(m)\tWeight(kg)\tBMI\tStatus");

        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s%n",
                    height[i], weight[i], bmi[i], weightStatus[i]);
        }

        input.close();
    }
}
