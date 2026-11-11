package javaExceptions.basics;

import java.util.*;

public class InterestCalculator {

    // Calculate simple interest
    public static double calculateInterest(
            double amount, double rate, int years)
            throws IllegalArgumentException {

        // Validate amount and rate
        if (amount < 0 || rate < 0) {

            // Throw unchecked exception
            throw new IllegalArgumentException(
                    "Invalid input: Amount and rate must be positive"
            );
        }

        // Calculate simple interest
        double interest = (amount * rate * years) / 100;

        return interest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter principal amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter interest rate: ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        try {

            // Call interest calculation method
            double result = calculateInterest(
                    amount, rate, years
            );

            System.out.println("Simple Interest: " + result);

        } catch (IllegalArgumentException e) {

            // Handle invalid input
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
