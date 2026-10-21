package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to toggle uppercase and lowercase characters.
 */
public class ToggleCase {

    /**
     * Toggles the case of English letters.
     *
     * @param text input string
     * @return string with toggled letter case
     */
    public static String toggleCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Convert uppercase to lowercase and vice versa
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result += ch;
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

        System.out.println("Toggled string: " + toggleCase(text));

        sc.close();
    }
}
