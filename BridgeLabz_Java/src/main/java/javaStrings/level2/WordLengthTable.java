
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to split text into words and return the words
 * along with their lengths in a 2D String array.
 *
 * Hint =>
 * Split text using charAt() without split().
 * Find each word's length without length().
 * Store each word and its length in a 2D array.
 */
public class WordLengthTable {

    /**
     * Finds string length without using length().
     *
     * @param text the input string
     * @return the string length
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
     * Splits text into words using charAt().
     *
     * @param text the input text
     * @return an array of words
     */
    public static String[] splitText(String text) {
        int length = findLength(text);
        int wordCount = 0;
        boolean inWord = false;

        // Count the words
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (ch != ' ' && ch != '\t' && ch != '\n'
                    && ch != '\r' && ch != '\f') {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        int start = -1;

        // Extract each word
        for (int i = 0; i <= length; i++) {
            boolean separator = i == length;

            if (i < length) {
                char ch = text.charAt(i);
                separator = ch == ' ' || ch == '\t'
                        || ch == '\n' || ch == '\r' || ch == '\f';
            }

            if (!separator && start == -1) {
                start = i;
            } else if (separator && start != -1) {
                String word = "";

                for (int j = start; j < i; j++) {
                    word += text.charAt(j);
                }

                words[index] = word;
                index++;
                start = -1;
            }
        }

        return words;
    }

    /**
     * Creates a 2D array containing words and their lengths.
     *
     * @param words the array of words
     * @return a 2D array of words and lengths
     */
    public static String[][] createWordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    /**
     * Main method to display the word-length table.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        String text = sc.nextLine();

        // Split text and create the 2D array
        String[] words = splitText(text);
        String[][] result = createWordLengthTable(words);

        // Display the table
        System.out.printf("%-20s %s%n", "Word", "Length");

        for (int i = 0; i < result.length; i++) {
            int length = Integer.parseInt(result[i][1]);
            System.out.printf("%-20s %d%n", result[i][0], length);
        }

        sc.close();
    }
}
