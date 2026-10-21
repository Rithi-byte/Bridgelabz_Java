package extras.mixed;

import java.util.Scanner;

/**
 * Performs basic arithmetic operations using separate methods.
 */
public class BasicCalculator {

    /** Adds two numbers. */
    public static double add(double a, double b) {
        return a + b;
    }

    /** Subtracts the second number from the first. */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /** Multiplies two numbers. */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     *
     * @throws ArithmeticException if the divisor is zero
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double b = sc.nextDouble();

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose an operation: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Result: " + add(a, b));
                break;

            case 2:
                System.out.println("Result: " + subtract(a, b));
                break;

            case 3:
                System.out.println("Result: " + multiply(a, b));
                break;

            case 4:
                try {
                    System.out.println("Result: " + divide(a, b));
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid operation.");
        }

        sc.close();
    }
}