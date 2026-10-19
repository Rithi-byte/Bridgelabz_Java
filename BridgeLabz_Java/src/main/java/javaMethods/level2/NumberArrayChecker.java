package javaMethods.level2;
import java.util.Scanner;

//Created NumberArrayChecker to analyze numbers
public class NumberArrayChecker {

    /**
     * Checks whether a number is positive.
     * @param number the input number
     * @return true if positive, otherwise false
     */
    public static boolean isPositive(int number) {
        return number > 0;
    }

    /**
     * Checks whether a number is even.
     * @param number the input number
     * @return true if even, otherwise false
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Compares two numbers.
     * @param number1 the first number
     * @param number2 the second number
     * @return 1 if first is greater, 0 if equal, -1 if first is smaller
     */
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an array to store five numbers
        int[] numbers = new int[5];

        // Get five numbers from the user
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        // Check each number
        for (int number : numbers) {
            if (number > 0) {
                if (isEven(number)) {
                    System.out.println(number + " is positive and even.");
                } else {
                    System.out.println(number + " is positive and odd.");
                }
            } else if (isPositive(number)) {
                System.out.println(number + " is positive.");
            } else if (number < 0) {
                System.out.println(number + " is negative.");
            } else {
                System.out.println(number + " is zero.");
            }
        }

        // Compare the first and last array elements
        int result = compare(numbers[0], numbers[numbers.length - 1]);

        if (result == 1) {
            System.out.println("First number is greater than last number.");
        } else if (result == 0) {
            System.out.println("First and last numbers are equal.");
        } else {
            System.out.println("First number is less than last number.");
        }

        sc.close();
    }
}
