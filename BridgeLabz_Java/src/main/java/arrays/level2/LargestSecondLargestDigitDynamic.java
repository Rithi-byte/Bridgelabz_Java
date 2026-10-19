
package arrays.level2;

import java.util.Scanner;

/**
 * Finds the largest and second-largest distinct digits using a
 * dynamically resized array.
 */
public class LargestSecondLargestDigitDynamic {

    /**
     * Extracts every digit, expands the array when necessary,
     * and finds the two largest distinct digits.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        long remaining = Math.abs((long) number);

        // Initialize the digit array and index
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Store zero when the input is zero
        if (remaining == 0) {
            digits[index++] = 0;
        }

        // Extract every digit and resize the array when full
        while (remaining != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];

                // Copy existing digits into the larger array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp;
            }

            // Store the last digit
            digits[index] = (int) (remaining % 10);
            index++;
            remaining /= 10;
        }

        int largest = -1;
        int secondLargest = -1;

        // Find the largest and second-largest distinct digits
        for (int i = 0; i < index; i++) {
            int digit = digits[i];

            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit < largest && digit > secondLargest) {
                secondLargest = digit;
            }
        }

        System.out.println("Largest digit: " + largest);

        if (secondLargest == -1) {
            System.out.println("No second-largest distinct digit exists.");
        } else {
            System.out.println("Second-largest digit: " + secondLargest);
        }

        input.close();
    }
}
