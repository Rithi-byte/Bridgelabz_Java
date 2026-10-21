package javaStrings.level1;

import java.util.Scanner;

/**
 * Write a program to demonstrate NumberFormatException.
 * Hint =>
 * Take a String input and use Integer.parseInt().
 * Handle NumberFormatException using try-catch.
 */
public class NumberFormatDemo {

    /**
     * Generates NumberFormatException.
     *
     * @param text the input string
     */
    public static void generateException(String text) {
        // Convert text to an integer
        System.out.println(Integer.parseInt(text));
    }

    /**
     * Handles NumberFormatException.
     *
     * @param text the input string
     */
    public static void handleException(String text) {
        try {
            // Convert text to an integer
            System.out.println(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    /**
     * Main method to demonstrate exception handling.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take String input
        String text = sc.next();

        // Uncomment to generate an unhandled exception
        // generateException(text);

        // Handle the exception
        handleException(text);

        sc.close();
    }
}
