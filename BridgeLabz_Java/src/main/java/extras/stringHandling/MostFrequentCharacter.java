package extras.stringHandling;
import java.util.Scanner;

/**
 * Write a Java program to find the most frequent character in a string.
 */
public class MostFrequentCharacter {

    /**
     * Finds the most frequent character.
     * If tied, returns the first character to reach the highest frequency.
     *
     * @param text input string
     * @return most frequent character, or '\0' for empty input
     */
    public static char findMostFrequent(String text) {
        if (text.isEmpty()) {
            return '\0';
        }

        char mostFrequent = text.charAt(0);
        int maxCount = 0;

        // Count each character's occurrences
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int count = 0;

            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostFrequent = ch;
            }
        }

        return mostFrequent;
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

        char result = findMostFrequent(text);

        if (result == '\0') {
            System.out.println("String is empty");
        } else {
            System.out.println("Most Frequent Character: '" + result + "'");
        }

        sc.close();
    }
}
