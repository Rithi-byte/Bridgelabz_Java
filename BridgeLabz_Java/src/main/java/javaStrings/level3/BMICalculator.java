package javaStrings.level3;

import java.util.Scanner;

/**
 * Write a program to calculate BMI for 10 people and display
 * height, weight, BMI, and status.
 *
 * BMI = weight / (height * height), where height is in meters.
 */
public class BMICalculator {

    /**
     * Calculates BMI and status.
     *
     * @param weight weight in kilograms
     * @param height height in centimeters
     * @return an array containing BMI and status
     */
    public static String[] calculateBMI(double weight, double height) {
        double heightMeter = height / 100.0;
        double bmi = weight / (heightMeter * heightMeter);
        String status;

        // Determine BMI status using the reference table
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25.0) {
            status = "Normal";
        } else if (bmi < 40.0) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{
                String.valueOf(Math.round(bmi * 100.0) / 100.0),
                status
        };
    }

    /**
     * Creates a table containing height, weight, BMI, and status.
     *
     * @param people 2D array containing weight and height
     * @return BMI results
     */
    public static String[][] getResults(double[][] people) {
        String[][] result = new String[people.length][4];

        for (int i = 0; i < people.length; i++) {
            String[] bmi = calculateBMI(people[i][0], people[i][1]);

            result[i][0] = String.valueOf(people[i][1]);
            result[i][1] = String.valueOf(people[i][0]);
            result[i][2] = bmi[0];
            result[i][3] = bmi[1];
        }

        return result;
    }

    /**
     * Displays the BMI table.
     *
     * @param result the BMI result array
     */
    public static void displayTable(String[][] result) {
        System.out.printf("%-10s %-12s %-10s %-15s%n",
                "Height(cm)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s %-12s %-10s %-15s%n",
                    result[i][0], result[i][1],
                    result[i][2], result[i][3]);
        }
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] people = new double[10][2];

        // Take weight and height for 10 people
        for (int i = 0; i < people.length; i++) {
            System.out.print("Enter weight (kg) and height (cm): ");
            people[i][0] = sc.nextDouble();
            people[i][1] = sc.nextDouble();
        }

        // Calculate and display BMI
        displayTable(getResults(people));

        sc.close();
    }
}
