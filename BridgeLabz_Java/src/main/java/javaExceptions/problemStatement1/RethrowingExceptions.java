package javaExceptions.problemStatement1;

import java.util.*;

public class RethrowingExceptions {

    // Method performs division
    public static int performDivision(int numerator, int denominator) {

        // Check whether denominator is zero
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return numerator / denominator;
    }

    // Method calls performDivision and rethrows exception
    public static int calculate(int numerator, int denominator) {

        try {

            // Perform division
            return performDivision(numerator, denominator);

        } catch (ArithmeticException e) {

            // Rethrow exception with additional context
            throw new ArithmeticException(
                    "Calculation failed: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int numerator = sc.nextInt();

        System.out.print("Enter denominator: ");
        int denominator = sc.nextInt();

        try {

            // Call calculate method
            int result = calculate(numerator, denominator);

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            // Handle the rethrown exception
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

