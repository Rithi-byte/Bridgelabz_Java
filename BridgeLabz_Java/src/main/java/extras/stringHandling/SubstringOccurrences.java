package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to count occurrences of a substring.
 */
public class SubstringOccurrences {

    /**
     * Counts overlapping occurrences of a substring.
     *
     * @param text original string
     * @param sub substring to search for
     * @return number of occurrences
     */
    public static int countOccurrences(String text, String sub) {
        if (sub.isEmpty() || sub.length() > text.length()) {
            return 0;
        }

        int count = 0;

        // Check each possible starting position
        for (int i = 0; i <= text.length() - sub.length(); i++) {
            boolean match = true;

            for (int j = 0; j < sub.length(); j++) {
                if (text.charAt(i + j) != sub.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        System.out.print("Enter the substring: ");
        String sub = sc.nextLine();

        System.out.println("Occurrences: "
                + countOccurrences(text, sub));

        sc.close();
    }
}
