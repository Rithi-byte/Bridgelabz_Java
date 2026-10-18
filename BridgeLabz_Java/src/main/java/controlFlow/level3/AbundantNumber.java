package controlFlow.level3;
import java.util.Scanner;
/**
 * Created AbundantNumber to check whether the sum
 * of the proper divisors exceeds the given number.
 */
public class AbundantNumber {

    /**
     * Finds the proper divisors and calculates their sum.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initialize divisor sum to zero
        int sum = 0;

        // Check all numbers smaller than the input
        for (int i = 1; i < number; i++) {
            // Check whether i is a proper divisor
            if (number % i == 0) {
                sum += i;
            }
        }

        // Check whether the divisor sum is greater
        if (sum > number) {
            System.out.println("Abundant Number");
        } else {
            System.out.println("Not an Abundant Number");
        }

        sc.close();
    }
}