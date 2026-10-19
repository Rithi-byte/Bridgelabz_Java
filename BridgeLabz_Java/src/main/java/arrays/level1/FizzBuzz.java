package arrays.level1;
import java.util.Scanner;

/**
 * Generates FizzBuzz results from 1 to a user-provided positive integer.
 */
public class FizzBuzz {

    /**
     * Stores FizzBuzz results in an array and displays each position.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the upper limit
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Validate the input
        if (number <= 0) {
            System.out.println("Error: Enter a positive integer.");
            input.close();
            return;
        }

        // Create an array to store the results from 1 to number
        String[] results = new String[number];

        // Generate the FizzBuzz results
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                results[i - 1] = "Buzz";
            } else {
                results[i - 1] = String.valueOf(i);
            }
        }

        // Display each result with its position
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }

        input.close();
    }
}
