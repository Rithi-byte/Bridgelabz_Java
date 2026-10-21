package extras.mixed;

import java.util.Scanner;

/**
 * Calculates factorial using recursion.
 */
public class FactorialRecursion {

    /**
     * Calculates the factorial of a number recursively.
     *
     * @param number non-negative integer
     * @return factorial of the number
     */
    public static long factorial(int number) {
        // Base case stops the recursion.
        if (number == 0 || number == 1) {
            return 1;
        }

        // Recursive case reduces the problem by one.
        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer (0-20): ");
        int number = sc.nextInt();

        if (number < 0 || number > 20) {
            System.out.println("Enter a number between 0 and 20.");
        } else {
            System.out.println("Factorial: " + factorial(number));
        }

        sc.close();
    }
}