package javaExceptions.basics;

import java.util.*;

public class UncheckedExceptionDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Get two numbers from the user
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();

            System.out.print("Enter denominator: ");
            int b = sc.nextInt();

            // Perform division
            int result = a / b;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            // Handle division by zero
            System.out.println("Cannot divide by zero!");

        } catch (InputMismatchException e) {

            // Handle non-numeric input
            System.out.println("Please enter valid numbers!");

        }

        sc.close();
    }
}

