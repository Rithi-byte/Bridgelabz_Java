
package javaStrings.level1;

import java.util.Scanner;

/**
 * Write a program to convert complete text to uppercase and compare
 * the result with the built-in toUpperCase() method.
 *
 * Hint =>
 * Take complete text using Scanner nextLine().
 * Convert lowercase characters to uppercase using ASCII values.
 * Compare both strings using charAt().
 */
public class StringUppercase {

    /**
     * Converts text to uppercase using charAt().
     *
     * @param text the input string
     * @return the uppercase string
     */
    public static String convertUppercase(String text) {
        String result = "";

        // Convert lowercase letters to uppercase
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result += ch;
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
     * Main method to compare uppercase conversion results.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        String text = sc.nextLine();

        // Convert using user-defined and built-in methods
        String result1 = convertUppercase(text);
        String result2 = text.toUpperCase();

        System.out.println("Using charAt(): " + result1);
        System.out.println("Using toUpperCase(): " + result2);
        System.out.println("Both results are equal: "
                + compareStrings(result1, result2));

        sc.close();
    }
}
