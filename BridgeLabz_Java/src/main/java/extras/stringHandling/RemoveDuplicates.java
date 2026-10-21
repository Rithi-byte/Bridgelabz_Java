package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to remove duplicate characters from a string.
 */
public class RemoveDuplicates {

    /**
     * Removes repeated characters while preserving first occurrences.
     *
     * @param text input string
     * @return string without duplicate characters
     */
    public static String removeDuplicates(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean found = false;

            // Check whether the character is already in the result
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result += ch;
            }
        }

        return result;
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("After removing duplicates: "
                + removeDuplicates(text));

        sc.close();
    }
}
