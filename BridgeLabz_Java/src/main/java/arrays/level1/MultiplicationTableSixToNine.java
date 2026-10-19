package arrays.level1;

import java.util.Scanner;

/**
 * Generates a multiplication table from 6 to 9 for a given number.
 */
public class MultiplicationTableSixToNine {

    /**
     * Reads a number and displays its multiplication results from 6 to 9.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Store results for multipliers 6, 7, 8, and 9
        int[] multiplicationResult = new int[4];

        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        // Display the results
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = "
                    + multiplicationResult[i - 6]);
        }

        input.close();
    }
}
