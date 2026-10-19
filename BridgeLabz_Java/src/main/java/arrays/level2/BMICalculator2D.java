
package arrays.level2;

import java.util.Scanner;

/**
 * Calculates BMI and weight status using a two-dimensional array.
 */
public class BMICalculator2D {

    /**
     * Stores height, weight, and BMI in a two-dimensional array,
     * then displays the BMI classification for each person.
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

        // Columns: height, weight, BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Read and validate height and weight
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter height in meters: ");
            double height = input.nextDouble();

            System.out.print("Enter weight in kg: ");
            double weight = input.nextDouble();

            // Repeat input when values are invalid
            if (height <= 0 || weight <= 0) {
                System.out.println("Enter positive values again.");
                i--;
                continue;
            }

            personData[i][0] = height;
            personData[i][1] = weight;
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < number; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];

            personData[i][2] = weight / (height * height);
            double bmi = personData[i][2];

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the BMI report
        System.out.println("\nHeight(m)\tWeight(kg)\tBMI\tStatus");

        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s%n",
                    personData[i][0], personData[i][1],
                    personData[i][2], weightStatus[i]);
        }

        input.close();
    }
}
