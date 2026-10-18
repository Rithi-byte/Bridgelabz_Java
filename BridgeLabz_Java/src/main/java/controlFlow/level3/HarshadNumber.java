package controlFlow.level3;
import java.util.Scanner;
/**
 * Created HarshadNumber to check whether a number
 * is divisible by the sum of its digits.
 */
public class HarshadNumber {

    /**
     * Calculates the sum of digits and checks
     * whether the number is a Harshad number.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Preserve the original number
        int originalNumber = number;

        // Initialize digit sum to zero
        int sum = 0;

        // Extract and add each digit
        while (number != 0) {
            int digit = number % 10;
            sum += digit;
            number = number / 10;
        }

        // Check divisibility by the digit sum
        if (originalNumber > 0 && sum != 0
                && originalNumber % sum == 0) {
            System.out.println("Harshad Number");
        } else {
            System.out.println("Not a Harshad Number");
        }

        sc.close();
    }
}