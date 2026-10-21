package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to check whether a string is a palindrome.
 */
public class PalindromeString {

    /**
     * Checks whether a string reads the same forward and backward.
     *
     * @param text input string
     * @return true if palindrome
     */
    public static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Compare characters from both ends
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
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

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("Is palindrome: " + isPalindrome(text));

        sc.close();
    }
}
