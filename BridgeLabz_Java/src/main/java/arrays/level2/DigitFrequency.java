
package arrays.level2;

import java.util.Scanner;

/**
 * Calculates the frequency of each digit in an integer.
 */
public class DigitFrequency {

    /**
     * Extracts the digits of a number, counts their frequencies,
     * and displays the frequency of every digit from 0 to 9.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Convert to long to safely handle the absolute value
        long remaining = Math.abs((long) number);

        // Count the number of digits
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

        if (remaining == 0) {
            digits[0] = 0;
        } else {
            for (int i = 0; i < count; i++) {
                digits[i] = (int) (remaining % 10);
                remaining /= 10;
            }
        }

        // Create a frequency array for digits 0 through 9
        int[] frequency = new int[10];

        // Count the occurrences of each digit
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        // Display the frequency of each digit that appears
        System.out.println("Digit frequencies:");

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + ": " + frequency[i]);
            }
        }

        input.close();
    }
}
