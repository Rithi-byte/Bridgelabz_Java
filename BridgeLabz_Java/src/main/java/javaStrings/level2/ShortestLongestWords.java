
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to split text into words and find the shortest
 * and longest strings in the given text.
 *
 * Hint =>
 * Split text using charAt() without split().
 * Find word lengths without length().
 * Return the shortest and longest word indexes.
 */
public class ShortestLongestWords {

    /**
     * Finds string length without using length().
     *
     * @param text the input string
     * @return the number of characters
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

        // Count words
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
        int wordIndex = 0;
        int start = -1;

        // Extract words
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

                words[wordIndex++] = word;
                start = -1;
            }
        }

        return words;
    }

    /**
     * Creates a 2D array containing each word and its length.
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
     * Finds the indexes of the shortest and longest words.
     *
     * @param table the word-length table
     * @return an array containing shortest and longest word indexes
     */
    public static int[] findShortestLongest(String[][] table) {
        int[] result = {-1, -1};

        if (table.length == 0) {
            return result;
        }

        int shortest = Integer.MAX_VALUE;
        int longest = Integer.MIN_VALUE;

        for (int i = 0; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);

            if (length < shortest) {
                shortest = length;
                result[0] = i;
            }

            if (length > longest) {
                longest = length;
                result[1] = i;
            }
        }

        return result;
    }

    /**
     * Main method to display the shortest and longest words.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        String text = sc.nextLine();

        String[] words = splitText(text);
        String[][] table = createWordLengthTable(words);
        int[] result = findShortestLongest(table);

        if (result[0] == -1) {
            System.out.println("No words found.");
        } else {
            System.out.println("Shortest word: "
                    + table[result[0]][0]);
            System.out.println("Longest word: "
                    + table[result[1]][0]);
        }

        sc.close();
    }
}
