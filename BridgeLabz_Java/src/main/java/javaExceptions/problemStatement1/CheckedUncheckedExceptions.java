package javaExceptions.problemStatement1;

import java.io.*;
import java.util.*;

public class CheckedUncheckedExceptions {

    // Method that processes data
    public static void processData(int number)
            throws IOException {

        // Throw checked exception
        if (number < 0) {
            throw new IOException(
                    "Negative numbers are not allowed"
            );
        }

        // Throw unchecked exception
        if (number == 0) {
            throw new ArithmeticException(
                    "Zero is not allowed"
            );
        }

        // Process valid data
        System.out.println("Processed result: " + (100 / number));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        try {

            // Call data processing method
            processData(number);

        } catch (IOException e) {

            // Handle checked exception
            System.out.println("Checked Exception: " + e.getMessage());

        } catch (ArithmeticException e) {

            // Handle unchecked exception
            System.out.println("Unchecked Exception: " + e.getMessage());
        }

        sc.close();
    }
}

