
package javaStrings.level3;

import java.util.Scanner;

/**
 * Write a program to check whether two texts are anagrams.
 *
 * Hint =>
 * Check whether the lengths are equal.
 * Count the frequency of every ASCII character.
 * Compare the frequency arrays.
 */
public class AnagramCheck {

    /**
     * Checks whether two strings are anagrams.
     *
     * @param text1 first string
     * @param text2 second string
     * @return true if both strings are anagrams
     */
    public static boolean checkAnagram(String text1, String text2) {

        // Anagrams must have equal lengths
        if (text1.length() != text2.length()) {
            return false;
        }

        int[] frequency = new int[256];

        // Count characters in the first string
        for (int i = 0; i < text1.length(); i++) {
            frequency[text1.charAt(i)]++;
        }

        // Subtract characters from the second string
        for (int i = 0; i < text2.length(); i++) {
            frequency[text2.charAt(i)]--;
        }

        // All frequencies must return to zero
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = sc.next();

        System.out.print("Enter second text: ");
        String text2 = sc.next();

        System.out.println("Are the texts anagrams: "
                + checkAnagram(text1, text2));

        sc.close();
    }
}
