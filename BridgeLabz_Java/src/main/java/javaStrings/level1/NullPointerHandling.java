package javaStrings.level1;

/**
 * Write a program to handle NullPointerException using try-catch.
 * Hint =>
 * Initialize text to null and handle the exception while accessing
 * a String method.
 */
public class NullPointerHandling {

    /**
     * Generates a NullPointerException.
     */
    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    /**
     * Handles NullPointerException.
     */
    public static void handleException() {
        String text = null;

        try {
            // Access a method using a null reference
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        }
    }

    /**
     * Main method to demonstrate exception handling.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Uncomment to see the unhandled exception
        // generateException();

        // Call the method to handle the exception
        handleException();
    }
}
