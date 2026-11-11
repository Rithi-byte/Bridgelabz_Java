package javaExceptions.basics;

import java.util.*;

// Create a custom checked exception
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {

    // Validate the user's age
    public static void validateAge(int age)
            throws InvalidAgeException {

        // Check whether age is below 18
        if (age < 18) {

            // Throw custom exception
            throw new InvalidAgeException(
                    "Age must be 18 or above"
            );
        }

        System.out.println("Access granted!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {

            // Call age validation method
            validateAge(age);

        } catch (InvalidAgeException e) {

            // Handle custom exception
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

