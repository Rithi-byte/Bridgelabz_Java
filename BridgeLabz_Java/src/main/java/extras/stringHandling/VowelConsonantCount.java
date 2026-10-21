package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to count vowels and consonants in a string.
 */
public class VowelConsonantCount {

    /**
     * Counts vowels and consonants.
     *
     * @param text input string
     * @return array containing vowel and consonant counts
     */
    public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        // Check each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return new int[]{vowels, consonants};
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

        int[] result = countVowelsConsonants(text);

        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);

        sc.close();
    }
}
