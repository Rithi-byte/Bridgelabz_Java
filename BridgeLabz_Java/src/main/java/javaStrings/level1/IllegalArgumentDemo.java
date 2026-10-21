package javaStrings.level1;

import java.util.Scanner;

/**
 * Write a program to demonstrate an invalid substring range.
 * Hint =>
 * Use substring() with the start index greater than the end index.
 * Handle the exception using try-catch.
 */
public class IllegalArgumentDemo {

    /**
     * Generates an exception using an invalid substring range.
     *
     * @param text the input string
     */
    public static void generateException(String text) {
        // Start index is greater than end index
        System.out.println(text.substring(4, 2));
    }

    /**
     * Handles exceptions caused by the invalid substring range.
     *
     * @param text the input string
     */
    public static void handleException(String text) {
        try {
            // Start index is greater than end index
            System.out.println(text.substring(4, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
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

        // Enter a string with at least 5 characters
        String text = sc.next();

        // Uncomment to generate an unhandled exception
        // generateException(text);

        // Handle the exception
        handleException(text);

        sc.close();
    }
}
