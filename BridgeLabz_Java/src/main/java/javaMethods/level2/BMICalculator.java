package javaMethods.level2;
import java.util.Scanner;

//Created BMICalculator to calculate BMI and status for 10 people
public class BMICalculator {

    /**
     * Calculates BMI for every person and stores it in column 2.
     * @param people 2D array storing weight, height and BMI
     */
    public static void calculateBMI(double[][] people) {
        for (int i = 0; i < people.length; i++) {
            // Convert height from centimeters to meters
            double heightInMeters = people[i][1] / 100.0;

            // Calculate BMI = weight / height squared
            people[i][2] = people[i][0]
                    / Math.pow(heightInMeters, 2);
        }
    }

    /**
     * Determines the BMI status of each person.
     * @param people 2D array containing BMI values
     * @return an array containing each person's BMI status
     */
    public static String[] findBMIStatus(double[][] people) {
        String[] status = new String[people.length];

        for (int i = 0; i < people.length; i++) {
            double bmi = people[i][2];

            // Determine status using the given BMI ranges
            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a 2D array: weight, height in cm and BMI
        double[][] people = new double[10][3];

        // Get weight and height for all 10 people
        for (int i = 0; i < people.length; i++) {
            System.out.print("Enter weight in kg for person "
                    + (i + 1) + ": ");
            people[i][0] = sc.nextDouble();

            System.out.print("Enter height in cm for person "
                    + (i + 1) + ": ");
            people[i][1] = sc.nextDouble();
        }

        // Calculate BMI and determine status
        calculateBMI(people);
        String[] status = findBMIStatus(people);

        // Display each person's details
        System.out.println("\nWeight(kg)\tHeight(cm)\tBMI\tStatus");
        for (int i = 0; i < people.length; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s%n",
                    people[i][0], people[i][1],
                    people[i][2], status[i]);
        }

        sc.close();
    }
}
