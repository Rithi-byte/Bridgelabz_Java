
package javaStrings.level1;

import java.util.Scanner;

/**
 * Write a program to create a substring using charAt() and compare it
 * with the built-in substring() method.
 *
 * Hint =>
 * Take String, start index, and end index as input.
 * Create a substring using charAt().
 * Compare both substrings using charAt() and display the result.
 */
public class StringSubstring {

    /**
     * Creates a substring using the charAt() method.
     *
     * @param text the original string
     * @param start the starting index
     * @param end the ending index (exclusive)
     * @return the created substring
     */
    public static String createSubstring(String text, int start, int end) {
        String result = "";

        // Create substring using charAt()
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
     * Main method to compare both substring methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string and index inputs
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        // Create substring using both methods
        String result1 = createSubstring(text, start, end);
        String result2 = text.substring(start, end);

        System.out.println("Substring using charAt(): " + result1);
        System.out.println("Substring using substring(): " + result2);
        System.out.println("Both results are equal: "
                + compareStrings(result1, result2));

        sc.close();
    }
}
