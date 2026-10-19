package arrays.level1;

import java.util.Scanner;

/**
 * Stores positive numbers until zero, a negative number, or the array limit.
 */
public class SumOfPositiveNumbers {

    /**
     * Reads up to 10 positive numbers and displays the numbers and their sum.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create an array to store up to 10 positive numbers
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Read numbers until a stopping condition is reached
        while (true) {
            if (index == numbers.length) {
                break;
            }

            System.out.print("Enter a positive number: ");
            double number = input.nextDouble();

            // Stop if the number is zero or negative
            if (number <= 0) {
                break;
            }

            numbers[index] = number;
            index++;
        }

        // Display the stored numbers and calculate their sum
        System.out.println("Numbers entered:");

        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        // Display the total
        System.out.println("Sum = " + total);

        input.close();
    }
}
