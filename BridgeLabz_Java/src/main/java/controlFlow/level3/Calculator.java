package controlFlow.level3;
import java.util.Scanner;

/**
 * Created Calculator to perform arithmetic operations
 * using a switch-case statement.
 */
public class Calculator {

    /**
     * Reads two numbers and an operator, then performs
     * addition, subtraction, multiplication, or division.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the first number
        System.out.print("Enter the first number: ");
        double first = sc.nextDouble();

        // Get the second number
        System.out.print("Enter the second number: ");
        double second = sc.nextDouble();

        // Get the operator
        System.out.print("Enter the operator (+, -, *, /): ");
        String op = sc.next();

        // Select the operation using switch-case
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;

            case "-":
                System.out.println("Result: " + (first - second));
                break;

            case "*":
                System.out.println("Result: " + (first * second));
                break;

            case "/":
                // Prevent division by zero
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;

            default:
                System.out.println("Invalid Operator");
        }

        sc.close();
    }
}