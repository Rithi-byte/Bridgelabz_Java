package controlFlow.level3;
import java.util.Scanner;

/**
 * Created ArmstrongNumber to check whether a number
 * is an Armstrong number using the sum of cubes of digits.
 */
public class ArmstrongNumber {

    /**
     * Gets an integer input and checks whether it is
     * an Armstrong number.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Store the original number
        int originalNumber = number;

        // Initialize sum to zero
        int sum = 0;

        // Use a temporary variable to process digits
        int temp = number;

        // Repeat until all digits are processed
        while (temp != 0) {
            // Extract the last digit
            int digit = temp % 10;

            // Add the cube of the digit to sum
            sum += digit * digit * digit;

            // Remove the last digit
            temp = temp / 10;
        }

        // Compare sum with the original number
        if (originalNumber == sum) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }

        sc.close();
    }
}
