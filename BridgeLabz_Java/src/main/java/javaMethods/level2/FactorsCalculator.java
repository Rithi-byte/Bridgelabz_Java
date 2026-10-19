package javaMethods.level2;
import java.util.Scanner;

//Created FactorsCalculator to find factors and their calculations
public class FactorsCalculator {

    /**
     * Finds and stores all factors of a number in an array.
     * @param number the input number
     * @return an array containing all factors
     */
    public static int[] findFactors(int number) {
        int count = 0;

        // Count the factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize array with the factor count
        int[] factors = new int[count];
        int index = 0;

        // Store the factors in the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    /**
     * Calculates the sum of factors.
     * @param factors the array of factors
     * @return the sum of factors
     */
    public static int findSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    /**
     * Calculates the product of factors.
     * @param factors the array of factors
     * @return the product of factors
     */
    public static long findProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    /**
     * Calculates the sum of squares of factors.
     * @param factors the array of factors
     * @return the sum of squares
     */
    public static double findSumOfSquares(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number from the user
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Enter a positive number.");
            sc.close();
            return;
        }

        // Calculate factors and their properties
        int[] factors = findFactors(number);

        // Display the results
        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println("\nSum: " + findSum(factors));
        System.out.println("Product: " + findProduct(factors));
        System.out.println("Sum of squares: " + findSumOfSquares(factors));

        sc.close();
    }
}