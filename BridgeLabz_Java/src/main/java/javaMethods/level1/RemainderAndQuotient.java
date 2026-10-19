package javaMethods.level1;
import java.util.Scanner;

//Created RemainderAndQuotient class to find quotient and remainder
public class RemainderAndQuotient {

    /**
     * Finds the quotient and remainder of two numbers.
     *
     * @param number the integer dividend
     * @param divisor the integer divisor
     * @return an integer array containing quotient at index 0
     *         and remainder at index 1
     */
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        // Calculate quotient and remainder
        int quotient = number / divisor;
        int remainder = number % divisor;

        // Return quotient and remainder as an array
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        // Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Get integer input from the user
        int number = sc.nextInt();
        int divisor = sc.nextInt();

        // Call the method to find quotient and remainder
        int[] result = findRemainderAndQuotient(number, divisor);

        // Display the result
        System.out.println("The quotient is " + result[0]);
        System.out.println("The remainder is " + result[1]);

        // Close the Scanner
        sc.close();
    }
}
