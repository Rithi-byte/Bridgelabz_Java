package javaMixedProblems.stringBuilderBuffer;
import java.util.Scanner;

/**
 * Concatenates an array of strings using StringBuffer.
 */
public class StringBufferConcatenate {

    /**
     * Concatenates all strings in an array.
     *
     * @param arr the array of strings
     * @return the concatenated string
     */
    public static String concatenate(String[] arr) {
        StringBuffer sb = new StringBuffer();

        // Append every string to the buffer.
        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * Main method to read and concatenate strings.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];

        // Read each string.
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }

        System.out.println("Concatenated string: " + concatenate(arr));

        sc.close();
    }
}