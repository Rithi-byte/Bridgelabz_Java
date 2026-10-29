package javaMixedProblems.linearBinarySearch;
import java.util.Scanner;

/**
 * Finds the first sentence containing a specified word.
 */
public class SearchWordInSentences {

    /**
     * Returns the first sentence containing the target word.
     *
     * @param sentences the array of sentences
     * @param target the word to search for
     * @return the matching sentence or "Not Found"
     */
    public static String searchSentence(String[] sentences, String target) {

        // Search each sentence in order.
        for (String sentence : sentences) {

            // Match the target as a complete word, ignoring case.
            String regex = ".*\\b" + java.util.regex.Pattern.quote(target)
                    + "\\b.*";

            if (sentence.matches("(?i)" + regex)) {
                return sentence;
            }
        }

        return "Not Found";
    }

    /**
     * Main method to search sentences.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sentences: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] sentences = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter sentence " + (i + 1) + ": ");
            sentences[i] = sc.nextLine();
        }

        System.out.print("Enter word to search: ");
        String target = sc.nextLine();

        System.out.println(searchSentence(sentences, target));

        sc.close();
    }
}
