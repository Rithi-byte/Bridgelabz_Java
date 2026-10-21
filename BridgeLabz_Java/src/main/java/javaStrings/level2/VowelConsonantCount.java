
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to find vowels and consonants in a string
 * and display their counts.
 *
 * Hint =>
 * Convert uppercase letters to lowercase using ASCII values.
 * Identify vowels, consonants, and non-letter characters.
 * Return the vowel and consonant counts in an array.
 */
public class VowelConsonantCount {

    /**
     * Identifies whether a character is a vowel, consonant, or non-letter.
     *
     * @param ch the character to check
     * @return Vowel, Consonant, or Not a Letter
     */
    public static String checkCharacter(char ch) {

        // Convert uppercase letters to lowercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check whether the character is a letter
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // Check whether the character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        return "Consonant";
    }

    /**
     * Counts vowels and consonants using charAt().
     *
     * @param text the input string
     * @return an array containing vowel and consonant counts
     */
    public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        // Check each character
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacter(text.charAt(i));

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    /**
     * Main method to display vowel and consonant counts.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string input
        String text = sc.nextLine();

        int[] result = countVowelsConsonants(text);

        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);

        sc.close();
    }
}
