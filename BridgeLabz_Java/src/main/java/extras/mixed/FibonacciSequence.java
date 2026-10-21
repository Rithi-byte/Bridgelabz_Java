package extras.mixed;

import java.util.Scanner;

/**
 * Generates the Fibonacci sequence for the requested number of terms.
 */
public class FibonacciSequence {

    /**
     * Prints the Fibonacci sequence.
     *
     * @param terms number of terms to print
     */
    public static void printFibonacci(int terms) {
        int first = 0;
        int second = 1;

        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");

            // Calculate the next term.
            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int terms = sc.nextInt();

        if (terms < 0) {
            System.out.println("Number of terms cannot be negative.");
        } else {
            printFibonacci(terms);
        }

        sc.close();
    }
}