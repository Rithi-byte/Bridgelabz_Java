
package javaStrings.level1;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a program to return all characters using a user-defined method
 * and compare the result with toCharArray().
 *
 * Hint =>
 * Take a String input.
 * Return its characters without using toCharArray().
 * Compare both character arrays and display the result.
 */
public class StringToCharacters {

    /**
     * Returns all characters in a string as a character array.
     *
     * @param text the input string
     * @return character array
     */
    public static char[] getCharacters(String text) {
        char[] result = new char[text.length()];

        // Copy each character into the array
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }

        return result;
    }

    /**
     * Compares two character arrays.
     *
     * @param a first character array
     * @param b second character array
     * @return true if both arrays are equal
     */
    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method to compare both character arrays.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string input
        String text = sc.next();

        // Get characters using both methods
        char[] result1 = getCharacters(text);
        char[] result2 = text.toCharArray();

        System.out.println("User-defined method: "+ Arrays.toString(result1));
        System.out.println("Using toCharArray(): "+ Arrays.toString(result2));
        System.out.println("Both arrays are equal: "+ compareArrays(result1, result2));

        sc.close();
    }
}
