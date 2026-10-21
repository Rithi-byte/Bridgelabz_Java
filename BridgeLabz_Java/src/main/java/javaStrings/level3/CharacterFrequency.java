
package javaStrings.level3;

import java.util.Scanner;

/**
 * Write a program to find the frequency of characters using charAt().
 *
 * Hint =>
 * Store character frequencies in an array of 256 ASCII values.
 * Return the characters and their frequencies in a 2D array.
 */
public class CharacterFrequency {

    /**
     * Finds character frequencies.
     *
     * @param text input string
     * @return 2D array containing characters and frequencies
     */
    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];

        // Count occurrences of each character
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Count distinct characters
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }

        String[][] result = new String[count][2];
        int index = 0;

        // Store each character and its frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                index++;

                // Prevent the same character from being added again
                frequency[ch] = 0;
            }
        }

        return result;
    }

    /**
     * Displays character frequencies.
     *
     * @param result frequency table
     */
    public static void displayTable(String[][] result) {
        System.out.printf("%-15s %-15s%n", "Character", "Frequency");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-15s %-15s%n",result[i][0], result[i][1]);
        }
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

        displayTable(findFrequency(text));

        sc.close();
    }
}
