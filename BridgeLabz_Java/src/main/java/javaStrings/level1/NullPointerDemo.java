
package javaStrings.level1;

/**
 * Write a program to demonstrate NullPointerException.
 *
 * Hint =>
 * Initialize a String variable to null and call a String method.
 */
public class NullPointerDemo {

    /**
     * Generates a NullPointerException.
     */
    public static void generateException() {
        String text = null;

        // Access a method using a null reference
        System.out.println(text.length());
    }

    /**
     * Main method to demonstrate the exception.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Call this method to generate the exception
        generateException();
    }
}
