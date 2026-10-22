package classesAndObject.level2;

import java.util.Scanner;

/**
 * Checks whether the given text is a palindrome.
 */
class PalindromeChecker {
    String text;

    /**
     * Checks whether the text reads the same forward and backward.
     *
     * @return true if the text is a palindrome, otherwise false
     */
    boolean isPalindrome() {
        // Normalize the text by removing spaces and ignoring case.
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        // Compare the normalized text with its reversed version.
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }

    /**
     * Displays whether the text is a palindrome.
     */
    void displayResult() {
        // Display the verification result.
        if (isPalindrome()) {
            System.out.println("The text is a palindrome.");
        } else {
            System.out.println("The text is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeChecker p1 = new PalindromeChecker();

        // Read the text from the user.
        System.out.print("Enter a string: ");
        p1.text = sc.nextLine();

        // Display the palindrome result.
        p1.displayResult();
        sc.close();
    }
}
