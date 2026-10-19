
package arrays.level2;

import java.util.Scanner;

/**
 * Reverses a number by storing its digits in an array.
 */
public class ReverseNumberUsingArray {

    /**
     * Extracts the digits of an integer and displays them in reverse order.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        long remaining = Math.abs((long) number);

        // Count the digits
        int count = 0;
        long tempNumber = remaining;

        if (tempNumber == 0) {
            count = 1;
        } else {
            while (tempNumber != 0) {
                count++;
                tempNumber /= 10;
            }
        }

        // Store the digits in an array
        int[] digits = new int[count];

        for (int i = 0; i < count; i++) {
            digits[i] = (int) (remaining % 10);
            remaining /= 10;
        }

        // Create an array containing the digits in reverse order
        int[] reversedDigits = new int[count];

        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[count - 1 - i];
        }

        // Display the reversed number
        System.out.print("Reversed number: ");

        if (number < 0) {
            System.out.print("-");
        }

        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }

        System.out.println();

        // Display the reversed digit array
        System.out.print("Digits in reverse order: ");

        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i] + " ");
        }

        System.out.println();
        input.close();
    }
}
