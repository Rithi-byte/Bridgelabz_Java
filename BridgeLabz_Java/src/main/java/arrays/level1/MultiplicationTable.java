package arrays.level1;

import java.util.Scanner;

/**
 * Generates and displays the multiplication table of a number from 1 to 10.
 */
public class MultiplicationTable {

    /**
     * Reads a number, stores its multiplication results, and displays them.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Store multiplication results from 1 to 10
        int[] multiplicationTable = new int[10];

        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the multiplication table
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = "
                    + multiplicationTable[i - 1]);
        }

        input.close();
    }
}
