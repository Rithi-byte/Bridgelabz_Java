package javaMixedProblems.stringBuilderBuffer;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Removes duplicate characters while preserving their original order.
 *
 * Problem:
 * Given a string, remove repeated characters.
 * Example: programming -> progamin
 */
public class StringBuilderRemoveDuplicates {

    /**
     * Removes duplicate characters from a string.
     *
     * @param str the input string
     * @return a string containing unique characters
     */
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        // Process each character in the input string.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Append only characters not encountered before.
            if (seen.add(ch)) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    /**
     * Main method to remove duplicate characters.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("After removing duplicates: "
                + removeDuplicates(str));

        sc.close();
    }
}