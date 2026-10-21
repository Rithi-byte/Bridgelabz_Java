package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a user-defined replace method to replace a character
 * with another character in a string.
 */
public class StringReplace {

    /**
     * Replaces all occurrences of a character.
     *
     * @param text original string
     * @param oldChar character to replace
     * @param newChar replacement character
     * @return modified string
     */
    public static String replace(String text, char oldChar, char newChar) {
        String result = "";

        // Replace matching characters
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == oldChar) {
                result += newChar;
            } else {
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

        System.out.print("Character to replace: ");
        char oldChar = sc.nextLine().charAt(0);

        System.out.print("Replacement character: ");
        char newChar = sc.nextLine().charAt(0);

        System.out.println("Modified string: "
                + replace(text, oldChar, newChar));

        sc.close();
    }
}