package extras.mixed;

import java.util.Scanner;

/**
 * Checks whether a string is a palindrome.
 */
public class PalindromeChecker {

    /**
     * Reads a string from the user.
     *
     * @param sc Scanner object
     * @return entered string
     */
    public static String getInput(Scanner sc) {
        System.out.print("Enter a word or phrase: ");
        return sc.nextLine();
    }

    /**
     * Checks the palindrome condition, ignoring spaces and case.
     *
     * @param text input string
     * @return true if palindrome, otherwise false
     */
    public static boolean isPalindrome(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Displays the result.
     *
     * @param result palindrome check result
     */
    public static void displayResult(boolean result) {
        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = getInput(sc);
        boolean result = isPalindrome(text);
        displayResult(result);

        sc.close();
    }
}