
package javaStrings.level2;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a program to split text into words using charAt()
 * and compare the result with the built-in split() method.
 *
 * Hint =>
 * Take complete text using Scanner nextLine().
 * Find word boundaries using spaces and extract each word.
 * Compare both String arrays.
 */
public class SplitWords {

    /**
     * Finds the length of a string without using length().
     *
     * @param text the input string
     * @return the length of the string
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
     * Splits text into words using charAt(), treating whitespace
     * as a word separator.
     *
     * @param text the input text
     * @return an array containing the words
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

        // Extract words using their starting and ending indexes
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

                words[wordIndex] = word;
                wordIndex++;
                start = -1;
            }
        }

        return words;
    }

    /**
     * Compares two String arrays.
     *
     * @param a first array
     * @param b second array
     * @return true if both arrays contain the same words in order
     */
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method to compare both splitting methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        String text = sc.nextLine();

        // Split using user-defined and built-in methods
        String[] result1 = splitText(text);
        String trimmedText = text.trim();
        String[] result2 = trimmedText.isEmpty()
                ? new String[0] : trimmedText.split("\\s+");

        System.out.println("Using charAt(): "
                + Arrays.toString(result1));
        System.out.println("Using split(): "
                + Arrays.toString(result2));
        System.out.println("Both results are equal: "
                + compareArrays(result1, result2));

        sc.close();
    }
}
