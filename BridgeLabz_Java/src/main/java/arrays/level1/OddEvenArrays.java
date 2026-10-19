package arrays.level1;

import java.util.Scanner;

/**
 * Separates natural numbers into odd and even arrays.
 */
public class OddEvenArrays {

    /**
     * Reads a natural number and stores odd and even numbers up to that value.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the upper limit
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Validate the input
        if (number < 1) {
            System.out.println("Error: Enter a natural number.");
            input.close();
            return;
        }

        // Create arrays large enough to store odd and even numbers
        int size = number / 2 + 1;
        int[] odd = new int[size];
        int[] even = new int[size];

        int oddIndex = 0;
        int evenIndex = 0;

        // Separate numbers into odd and even arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // Display odd numbers
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        // Display even numbers
        System.out.print("\nEven numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }

        System.out.println();
        input.close();
    }
}
