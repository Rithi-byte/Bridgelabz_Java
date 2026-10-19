package javaMethods.level2;
import java.util.Scanner;

//Created NaturalNumberSum to compare recursive and formula results
public class NaturalNumberSum {

    /**
     * Calculates the sum of natural numbers using recursion.
     * @param number the positive integer
     * @return the sum from 1 to number
     */
    public static int findSumUsingRecursion(int number) {
        if (number == 1) {
            return 1;
        }
        return number + findSumUsingRecursion(number - 1);
    }

    /**
     * Calculates the sum using the mathematical formula.
     * @param number the positive integer
     * @return the sum from 1 to number
     */
    public static int findSumUsingFormula(int number) {
        return number * (number + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get a natural number
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input. Enter a natural number.");
            sc.close();
            return;
        }

        // Calculate sum using both methods
        int recursiveSum = findSumUsingRecursion(number);
        int formulaSum = findSumUsingFormula(number);

        // Display and compare the results
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Both results are correct: "
                + (recursiveSum == formulaSum));

        sc.close();
    }
}
