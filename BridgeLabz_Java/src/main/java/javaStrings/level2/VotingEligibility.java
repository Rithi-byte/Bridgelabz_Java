
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to check whether 10 students can vote based on age.
 *
 * Hint =>
 * Store the ages in an array.
 * Create a 2D String array containing age and voting eligibility.
 * Display the results in a tabular format.
 */
public class VotingEligibility {

    /**
     * Takes the ages of students as input.
     *
     * @param sc the Scanner object
     * @param n the number of students
     * @return an array containing student ages
     */
    public static int[] getAges(Scanner sc, int n) {
        int[] ages = new int[n];

        // Take age input for each student
        for (int i = 0; i < n; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        return ages;
    }

    /**
     * Checks voting eligibility for each student.
     *
     * @param ages the array of ages
     * @return a 2D array containing age and voting eligibility
     */
    public static String[][] checkEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            // Validate age and check voting eligibility
            if (ages[i] < 0) {
                result[i][1] = "Invalid age";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    /**
     * Displays voting eligibility in a table.
     *
     * @param result the 2D result array
     */
    public static void displayTable(String[][] result) {
        System.out.printf("%-15s %-20s%n", "Age", "Can Vote");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-15s %-20s%n",
                    result[i][0], result[i][1]);
        }
    }

    /**
     * Main method to check voting eligibility.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take ages of 10 students
        int[] ages = getAges(sc, 10);

        // Check eligibility and display results
        String[][] result = checkEligibility(ages);
        displayTable(result);

        sc.close();
    }
}
