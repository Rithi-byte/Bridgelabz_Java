package javaMixedProblems.inputOutput;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Counts occurrences of a specified word in a text file.
 */
public class FileReaderWordCount {

    /**
     * Counts exact word occurrences, ignoring case and punctuation.
     *
     * @param fileName the path of the input file
     * @param target the word to count
     * @return the number of occurrences
     * @throws IOException if the file cannot be read
     */
    public static int countWord(String fileName, String target)
            throws IOException {

        int count = 0;

        // Read the file line by line.
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Split the line into words using non-letter/digit characters.
                String[] words = line.split("[^\\p{L}\\p{N}]+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Main method to count a word in a file.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String fileName = sc.nextLine();

        System.out.print("Enter word to search: ");
        String target = sc.nextLine();

        try {
            System.out.println("Word occurrences: "
                    + countWord(fileName, target));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}