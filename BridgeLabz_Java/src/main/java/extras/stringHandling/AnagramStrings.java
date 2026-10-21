package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to check whether two strings are anagrams.
 */
public class AnagramStrings {

    /**
     * Checks whether two strings contain the same characters
     * with the same frequencies.
     *
     * @param s1 first string
     * @param s2 second string
     * @return true if the strings are anagrams
     */
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] frequency = new int[65536];

        // Count characters in the first string
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i)]++;
        }

        // Subtract characters in the second string
        for (int i = 0; i < s2.length(); i++) {
            frequency[s2.charAt(i)]--;
        }

        // Check whether all frequencies match
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        System.out.println("Are anagrams: " + areAnagrams(s1, s2));

        sc.close();
    }
}