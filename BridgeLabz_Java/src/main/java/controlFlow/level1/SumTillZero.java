
package controlFlow.level1;

import java.util.Scanner;

// Created SumTillZero to find the sum of numbers until the user enters 0
public class SumTillZero {

    /**
     * Takes double values from the user and calculates their sum
     * until the user enters 0.
     *
     * @param args command-line arguments passed to the main method
     */
    public static void main(String[] args) {

        // Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Initialize total to 0.0
        double total = 0.0;

        // Take the first input from the user
        double input = sc.nextDouble();

        // Continue adding numbers until the user enters 0
        while (input != 0) {
            total += input;
            input = sc.nextDouble();
        }

        // Display the total sum
        System.out.println("Total: " + total);

        // Close the Scanner object
        sc.close();
    }
}
