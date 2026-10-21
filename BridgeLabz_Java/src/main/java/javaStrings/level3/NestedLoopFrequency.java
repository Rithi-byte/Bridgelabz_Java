
package javaStrings.level3;

import java.util.Scanner;

/**
 * Write a program to find character frequencies using nested loops.
 *
 * Hint =>
 * Convert the string to a character array.
 * Count duplicates and mark counted characters as '0'.
 * Store characters and frequencies in a 1D String array.
 */
public class NestedLoopFrequency {

    /**
     * Finds the frequency of each character using nested loops.
     *
     * @param text input string
     * @return 1D array containing character-frequency pairs
     */
    public static String[] findFrequency(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];

        // Count frequencies and mark duplicates
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '\0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '\0';
                }
            }
        }

        // Count distinct characters
        int count = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '\0') {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;

        // Store character and frequency pairs
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '\0') {
                result[index++] = characters[i] + " : " + frequency[i];
            }
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

        String[] result = findFrequency(text);

        System.out.println("Character : Frequency");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}
