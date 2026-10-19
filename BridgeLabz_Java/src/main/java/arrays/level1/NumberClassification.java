package arrays.level1;

import java.util.Scanner;

/**
 * Classifies five numbers and compares the first and last elements.
 */
public class NumberClassification {

    /**
     * Reads five numbers, classifies them, and compares the first and last.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create an array to store five numbers
        int[] numbers = new int[5];

        // Read five numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Classify each number
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (number > 0) {
                if (number % 2 == 0) {
                    System.out.println(number + " is positive and even.");
                } else {
                    System.out.println(number + " is positive and odd.");
                }
            } else if (number < 0) {
                System.out.println(number + " is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        }

        // Compare the first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            System.out.println("First and last numbers are equal.");
        } else if (first > last) {
            System.out.println("First number is greater than last number.");
        } else {
            System.out.println("First number is less than last number.");
        }

        input.close();
    }
}