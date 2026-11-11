package javaExceptions.basics;

import java.util.*;

public class FinallyBlockDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get two integers
        System.out.print("Enter numerator: ");
        int a = sc.nextInt();

        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        try {

            // Perform integer division
            int result = a / b;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            // Handle division by zero
            System.out.println("Cannot divide by zero!");

        } finally {

            // This block executes regardless of exception
            System.out.println("Operation completed");
        }

        sc.close();
    }
}
