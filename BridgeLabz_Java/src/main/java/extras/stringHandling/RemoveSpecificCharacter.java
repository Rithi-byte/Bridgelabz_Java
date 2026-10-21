package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to remove all occurrences of a specific character.
 */
public class RemoveSpecificCharacter {

    /**
     * Removes all occurrences of a character.
     *
     * @param text input string
     * @param remove character to remove
     * @return modified string
     */
    public static String removeCharacter(String text, char remove) {
        String result = "";

        // Append only characters that do not match the target
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != remove) {
                result += text.charAt(i);
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

        System.out.print("Character to remove: ");
        char remove = sc.nextLine().charAt(0);

        System.out.println("Modified String: "
                + removeCharacter(text, remove));

        sc.close();
    }
}
