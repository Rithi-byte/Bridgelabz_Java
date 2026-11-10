package lambdaExpression;


import java.util.Scanner;
import java.util.function.Predicate;

// Custom exception for invalid user details
class InvalidUserDetailsException extends Exception {
    public InvalidUserDetailsException(String message) {
        super(message);
    }
}

public class UserRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Lambda expression to validate first name
        // Must start with uppercase and contain at least 3 characters
        Predicate<String> firstNameValidator =
                name -> name.matches("[A-Z][a-zA-Z]{2,}");

        // Lambda expression to validate last name
        Predicate<String> lastNameValidator =
                name -> name.matches("[A-Z][a-zA-Z]{2,}");

        // Lambda expression to validate email
        // Format: abc.xyz@bl.co.in
        // xyz and in are optional
        Predicate<String> emailValidator =
                email -> email.matches(
                        "^[A-Za-z0-9]+(\\.[A-Za-z0-9]+)?@[A-Za-z0-9]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})?$"
                );

        // Lambda expression to validate mobile number
        // Country code, space, and 10-digit mobile number
        Predicate<String> mobileValidator =
                mobile -> mobile.matches("[0-9]{2} [0-9]{10}");

        // Lambda expression to validate password
        // Minimum 8 characters
        // At least one uppercase letter
        // At least one digit
        // Exactly one special character
        Predicate<String> passwordValidator =
                password -> password.length() >= 8
                        && password.matches(".*[A-Z].*")
                        && password.matches(".*[0-9].*")
                        && password.replaceAll("[a-zA-Z0-9]", "").length() == 1;

        try {

            // Get user details
            System.out.print("Enter First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobile = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            // Validate first name
            if (!firstNameValidator.test(firstName)) {
                throw new InvalidUserDetailsException(
                        "Invalid First Name"
                );
            }

            // Validate last name
            if (!lastNameValidator.test(lastName)) {
                throw new InvalidUserDetailsException(
                        "Invalid Last Name"
                );
            }

            // Validate email
            if (!emailValidator.test(email)) {
                throw new InvalidUserDetailsException(
                        "Invalid Email"
                );
            }

            // Validate mobile number
            if (!mobileValidator.test(mobile)) {
                throw new InvalidUserDetailsException(
                        "Invalid Mobile Number"
                );
            }

            // Validate password
            if (!passwordValidator.test(password)) {
                throw new InvalidUserDetailsException(
                        "Invalid Password"
                );
            }

            // Registration successful
            System.out.println("\nUser Registration Successful!");
            System.out.println("Name: " + firstName + " " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Mobile: " + mobile);

        } catch (InvalidUserDetailsException e) {

            // Display validation error
            System.out.println("Registration Failed: " + e.getMessage());

        }

        sc.close();
    }
}

