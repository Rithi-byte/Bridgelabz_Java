package controlFlow.level3;
import java.util.Scanner;
/**
 * Created CountDigits to count the number of digits
 * in an integer using a while loop.
 */
public class CountDigits {

    /**
     * Reads an integer and counts its digits.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initialize count to zero
        int count = 0;

        // Zero itself contains one digit
        if (number == 0) {
            count = 1;
        } else {
            // Repeat until the number becomes zero
            while (number != 0) {
                // Remove the last digit
                number = number / 10;

                // Increment the digit count
                count++;
            }
        }

        // Display the digit count
        System.out.println("Number of digits: " + count);

        sc.close();
    }
}
