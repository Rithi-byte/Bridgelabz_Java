
package javaStrings.level3;

import java.util.Scanner;

/**
 * Write a program to check whether a string is a palindrome using
 * loops, recursion, and character arrays.
 *
 * Hint =>
 * Compare characters from both ends of the string.
 */
public class PalindromeCheck {

    /**
     * Checks palindrome using a loop.
     *
     * @param text input string
     * @return true if the string is a palindrome
     */
    public static boolean checkUsingLoop(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Compare characters from both ends
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    /**
     * Checks palindrome recursively.
     *
     * @param text input string
     * @param start starting index
     * @param end ending index
     * @return true if the string is a palindrome
     */
    public static boolean checkRecursive(
            String text, int start, int end) {

        // Base case: all pairs have matched
        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Check the next pair
        return checkRecursive(text, start + 1, end - 1);
    }

    /**
     * Reverses a string using charAt().
     *
     * @param text input string
     * @return reversed character array
     */
    public static char[] reverseString(String text) {
        char[] reverse = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            reverse[i] = text.charAt(text.length() - 1 - i);
        }

        return reverse;
    }

    /**
     * Checks palindrome using character arrays.
     *
     * @param text input string
     * @return true if the string is a palindrome
     */
    public static boolean checkUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method to compare all three methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.println("Using loop: " + checkUsingLoop(text));
        System.out.println("Using recursion: "
                + checkRecursive(text, 0, text.length() - 1));
        System.out.println("Using arrays: " + checkUsingArray(text));

        sc.close();
    }
}
