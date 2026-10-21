
package javaStrings.level3;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a program to find character frequencies using unique characters.
 *
 * Hint =>
 * Find unique characters using nested loops.
 * Count each character's frequency and return a 2D String array.
 */
public class UniqueCharacterFrequency {

    /**
     * Finds unique characters in their original order.
     *
     * @param text input string
     * @return array of unique characters
     */
    public static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;

        // Check whether each character has appeared before
        for (int i = 0; i < text.length(); i++) {
            boolean found = false;

            for (int j = 0; j < count; j++) {
                if (temp[j] == text.charAt(i)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[count++] = text.charAt(i);
            }
        }

        return Arrays.copyOf(temp, count);
    }

    /**
     * Finds the frequency of each unique character.
     *
     * @param text input string
     * @return 2D array containing characters and frequencies
     */
    public static String[][] findFrequency(String text) {
        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        // Count each unique character
        for (int i = 0; i < unique.length; i++) {
            int count = 0;

            for (int j = 0; j < text.length(); j++) {
                if (unique[i] == text.charAt(j)) {
                    count++;
                }
            }

            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(count);
        }

        return result;
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        System.out.printf("%-15s %-15s%n", "Character", "Frequency");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-15s %-15s%n",
                    result[i][0], result[i][1]);
        }

        sc.close();
    }
}
