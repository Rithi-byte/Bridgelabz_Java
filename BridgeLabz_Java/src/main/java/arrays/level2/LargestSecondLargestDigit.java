
package arrays.level2;

import java.util.Scanner;

/**
 * Finds the largest and second-largest distinct digits of a number.
 */
public class LargestSecondLargestDigit {

    /**
     * Extracts up to 10 digits and identifies the two largest distinct digits.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Convert to long to safely handle the absolute value of an int
        long remaining = Math.abs((long) number);

        // Store digits in an array with a maximum size of 10
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Handle zero as a single digit
        if (remaining == 0) {
            digits[index++] = 0;
        }

        // Extract and store digits
        while (remaining != 0) {
            if (index == maxDigit) {
                break;
            }

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
