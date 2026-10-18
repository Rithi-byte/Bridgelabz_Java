
package controlFlow.level1;

import java.util.Scanner;

// Create NumberCheck class to check whether a number is positive, negative, or zero
public class NumberCheck {

    /**
     * Checks whether the given number is positive, negative, or zero.
     *
     * @param number integer value entered by the user
     * @return String representing whether the number is positive, negative, or zero
     */
    public static String checkNumber(int number) {
        if (number > 0) {
            return "positive";
        } else if (number < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    /**
     * Takes an integer input from the user and displays whether
     * the number is positive, negative, or zero.
     *
     * @param args command-line arguments passed to the main method
     */
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Get integer input from the user
        int number = sc.nextInt();

        // Check and display the result
        System.out.println("The number " + number + " is "
                + checkNumber(number));

        // Close the Scanner object
        sc.close();
    }
}
