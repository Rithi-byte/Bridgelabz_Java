
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to find vowels and consonants in a string
 * and display each character's type.
 *
 * Hint =>
 * Classify each character as Vowel, Consonant, or Not a Letter.
 * Store the character and its type in a 2D String array.
 * Display the result in a tabular format.
 */
public class CharacterType {

    /**
     * Checks whether a character is a vowel, consonant, or non-letter.
     *
     * @param ch the character to check
     * @return the character type
     */
    public static String checkCharacter(char ch) {

        // Convert uppercase to lowercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check whether it is a letter
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // Check whether it is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        return "Consonant";
    }

    /**
     * Creates a 2D array of characters and their types.
     *
     * @param text the input string
     * @return a 2D array containing characters and types
     */
    public static String[][] getCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];

        // Store each character and its type
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }

        return result;
    }

    /**
     * Displays the character types in a table.
     *
     * @param result the 2D character-type array
     */
    public static void displayTable(String[][] result) {
        System.out.printf("%-15s %-20s%n", "Character", "Type");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-15s %-20s%n",
                    result[i][0], result[i][1]);
        }
    }

    /**
     * Main method to display character classifications.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take complete text input
        String text = sc.nextLine();

        String[][] result = getCharacterTypes(text);

        // Display the table
        displayTable(result);

        sc.close();
    }
}
