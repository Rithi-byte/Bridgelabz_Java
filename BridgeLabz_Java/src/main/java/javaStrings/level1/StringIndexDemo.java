
package javaStrings.level1;

import java.util.Scanner;

/**
 * Write a program to demonstrate StringIndexOutOfBoundsException.
 * Hint =>
 * Take a String input and access an index beyond its length.
 * Handle the exception using try-catch.
 */
public class StringIndexDemo {

    /**
     * Generates StringIndexOutOfBoundsException.
     *
     * @param text the input string
     */
    public static void generateException(String text) {
        // Access an invalid index
        System.out.println(text.charAt(text.length()));
    }

    /**
     * Handles StringIndexOutOfBoundsException.
     *
     * @param text the input string
     */
    public static void handleException(String text) {
        try {
            // Access an invalid index
            System.out.println(text.charAt(text.length()));
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

        // Take string input
        String text = sc.next();

        // Uncomment to generate an unhandled exception
        // generateException(text);

        // Handle the exception
        handleException(text);

        sc.close();
    }
}
