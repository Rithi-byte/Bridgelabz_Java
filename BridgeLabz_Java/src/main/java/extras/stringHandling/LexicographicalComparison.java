package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to compare two strings lexicographically
 * without built-in comparison methods.
 */
public class LexicographicalComparison {

    /**
     * Compares strings character by character.
     *
     * @param s1 first string
     * @param s2 second string
     * @return negative if s1 comes first, positive if s2 comes first,
     *         zero if equal
     */
    public static int compareStrings(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());

        // Compare corresponding characters
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }

        // If the common part matches, the shorter string comes first
        return s1.length() - s2.length();
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String s1 = sc.nextLine();

        System.out.print("Enter String 2: ");
        String s2 = sc.nextLine();

        int result = compareStrings(s1, s2);

        if (result < 0) {
            System.out.println("\"" + s1
                    + "\" comes before \"" + s2 + "\"");
        } else if (result > 0) {
            System.out.println("\"" + s2
                    + "\" comes before \"" + s1 + "\"");
        } else {
            System.out.println("Both strings are equal");
        }

        sc.close();
    }
}
