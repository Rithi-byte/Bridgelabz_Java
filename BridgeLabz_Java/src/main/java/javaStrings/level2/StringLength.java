
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to find and return the length of a string
 * without using the built-in length() method.
 *
 * Hint =>
 * Take user input using Scanner next().
 * Count characters using charAt() until an exception occurs.
 * Compare the result with the built-in length() method.
 */
public class StringLength {

    /**
     * Finds the length of a string without using length().
     *
     * @param text the input string
     * @return the number of characters in the string
     */
    public static int findLength(String text) {
        int count = 0;

        try {
            // Count characters until charAt() throws an exception
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception indicates the end of the string
        }

        return count;
    }

    /**
     * Main method to compare both length methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string input
        String text = sc.next();

        // Find length using both methods
        int result1 = findLength(text);
        int result2 = text.length();

        System.out.println("Length using charAt(): " + result1);
        System.out.println("Length using length(): " + result2);
        System.out.println("Both results are equal: "
                + (result1 == result2));

        sc.close();
    }
}
