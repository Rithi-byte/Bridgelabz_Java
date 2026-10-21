package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to find the longest word in a sentence.
 */
public class LongestWord {

    /**
     * Finds the longest word in a sentence.
     *
     * @param text input sentence
     * @return longest word, or empty string if no words exist
     */
    public static String findLongestWord(String text) {
        String longest = "";
        String current = "";

        // Process each character and build words
        for (int i = 0; i <= text.length(); i++) {
            char ch = i < text.length() ? text.charAt(i) : ' ';

            if (ch != ' ' && ch != '\t' && ch != '\n') {
                current += ch;
            } else {
                if (current.length() > longest.length()) {
                    longest = current;
                }

                current = "";
            }
        }

        return longest;
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        System.out.println("Longest word: " + findLongestWord(text));

        sc.close();
    }
}
