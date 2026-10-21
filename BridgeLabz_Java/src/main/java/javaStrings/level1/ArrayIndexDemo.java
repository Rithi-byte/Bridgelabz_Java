
package javaStrings.level1;

import java.util.Scanner;

/**
 * Write a program to demonstrate ArrayIndexOutOfBoundsException.
 * Hint =>
 * Create an array of names and take input from the user.
 * Access an invalid index and handle the exception using try-catch.
 */
public class ArrayIndexDemo {

    /**
     * Generates ArrayIndexOutOfBoundsException.
     *
     * @param names the array of names
     */
    public static void generateException(String[] names) {
        // Access an index beyond the array length
        System.out.println(names[names.length]);
    }

    /**
     * Handles ArrayIndexOutOfBoundsException.
     *
     * @param names the array of names
     */
    public static void handleException(String[] names) {
        try {
            // Access an index beyond the array length
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
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

        // Create an array and take input
        String[] names = new String[3];

        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }

        // Uncomment to generate an unhandled exception
        // generateException(names);

        // Handle the exception
        handleException(names);

        sc.close();
    }
}
