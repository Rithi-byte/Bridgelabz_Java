package arrays.level1;

import java.util.Scanner;

/**
 * Finds and displays all factors of a positive integer using a resizable array.
 */
public class FactorsOfNumber {

    /**
     * Reads a positive integer, stores its factors, and displays them.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the number
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Validate the input
        if (number <= 0) {
            System.out.println("Error: Enter a positive integer.");
            input.close();
            return;
        }

        // Initialize the factors array and its tracking variables
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Find factors from 1 to the given number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                // Expand the array when it becomes full
                if (index == maxFactor) {
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];

                    // Copy existing factors into the larger array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;
                }

                // Store the factor
                factors[index] = i;
                index++;
            }
        }

        // Display all factors
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        System.out.println();
        input.close();
    }
}
