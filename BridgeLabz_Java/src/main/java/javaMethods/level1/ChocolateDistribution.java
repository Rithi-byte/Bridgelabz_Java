package javaMethods.level1;
import java.util.Scanner;

//Created ChocolateDistribution class to distribute chocolates among children
public class ChocolateDistribution {

    /**
     * Calculates the number of chocolates each child gets and the remaining chocolates.
     *
     * @param number the total number of chocolates
     * @param divisor the number of children
     * @return an integer array containing chocolates per child at index 0
     *         and remaining chocolates at index 1
     */
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        // Calculate chocolates each child gets and remaining chocolates
        int quotient = number / divisor;
        int remainder = number % divisor;

        // Return quotient and remainder as an array
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        // Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Get the number of chocolates and children from the user
        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();

        // Call the method to calculate the distribution
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Display the result
        System.out.println("Each child gets " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);

        // Close the Scanner
        sc.close();
    }
}
