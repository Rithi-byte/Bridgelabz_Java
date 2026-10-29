package javaMixedProblems.stringBuilderBuffer;
import java.util.Scanner;

/**
 * Reverses a given string using StringBuilder.
 *
 * Problem:
 * Given a string, reverse it using StringBuilder.
 * Example: hello -> olleh
 */
public class StringBuilderReverse {

    /**
     * Reverses the input string.
     *
     * @param str the input string
     * @return the reversed string
     */
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    /**
     * Main method to accept and reverse a string.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("Reversed string: " + reverseString(str));

        sc.close();
    }
}
