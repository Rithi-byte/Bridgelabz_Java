package javaStrings.level3;
import java.util.Scanner;

/**
 * Write a program to find the first non-repeating character in a string.

 * Hint =>
 * Use an array of 256 elements to store ASCII character frequencies.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Finds the first character that occurs only once.
     *
     * @param text input string
     * @return first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];

        // Count character frequencies
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Find the first character with frequency one
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
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

        char result = findFirstNonRepeating(text);

        if (result == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }
}
