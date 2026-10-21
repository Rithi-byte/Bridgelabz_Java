
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to trim leading and trailing spaces using charAt()
 * and compare the result with the built-in trim() method.
 *
 * Hint =>
 * Find the starting and ending indexes without spaces.
 * Create a substring using charAt() and compare both results.
 */
public class StringTrim {

    /**
     * Finds the start and end indexes after trimming spaces.
     *
     * @param text the input string
     * @return an array containing the start and end indexes
     */
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length();

        // Skip leading spaces
        while (start < end && text.charAt(start) == ' ') {
            start++;
        }

        // Skip trailing spaces
        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    /**
     * Creates a substring using charAt().
     *
     * @param text the original string
     * @param start the starting index
     * @param end the ending index (exclusive)
     * @return the substring
     */
    public static String createSubstring(String text, int start, int end) {
        String result = "";

        // Copy characters within the specified indexes
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    /**
     * Compares two strings using charAt().
     *
     * @param s1 first string
     * @param s2 second string
     * @return true if both strings are equal
     */
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method to compare both trimming methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);

        // Trim using user-defined methods
        String result1 = createSubstring(
                text, indexes[0], indexes[1]);

        // Trim using the built-in method
        String result2 = text.trim();

        System.out.println("Using charAt(): [" + result1 + "]");
        System.out.println("Using trim(): [" + result2 + "]");
        System.out.println("Both results are equal: "
                + compareStrings(result1, result2));

        sc.close();
    }
}
