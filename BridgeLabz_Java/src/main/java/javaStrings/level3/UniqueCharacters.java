
package javaStrings.level3;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a program to find unique characters in a string using charAt().
 *
 * Hint =>
 * Find string length without length().
 * Use nested loops to avoid storing duplicate characters.
 */
public class UniqueCharacters {

    /**
     * Finds string length without using length().
     *
     * @param text input string
     * @return length of string
     */
    public static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }

        return count;
    }

    /**
     * Finds unique characters in their original order.
     *
     * @param text input string
     * @return array of unique characters
     */
    public static char[] uniqueCharacters(String text) {
        int length = findLength(text);
        char[] temp = new char[length];
        int count = 0;

        // Check each character against previous characters
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean found = false;

            for (int j = 0; j < count; j++) {
                if (temp[j] == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[count++] = ch;
            }
        }

        // Copy only the unique characters
        return Arrays.copyOf(temp, count);
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        char[] result = uniqueCharacters(text);

        System.out.println("Unique characters: "
                + Arrays.toString(result));

        sc.close();
    }
}
