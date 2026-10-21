package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to reverse a string without built-in
 * reverse functions.
 */
public class ReverseString {

    /**
     * Reverses the given string.
     *
     * @param text input string
     * @return reversed string
     */
    public static String reverse(String text) {
        String result = "";

        // Read characters from the end to the beginning
        for (int i = text.length() - 1; i >= 0; i--) {
            result += text.charAt(i);
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

        System.out.println("Reversed string: " + reverse(text));

        sc.close();
    }
}
