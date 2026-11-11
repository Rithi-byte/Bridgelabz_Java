package javaJUnit;
import java.util.Scanner;

public class UserRegistration {

    // UC1: Validate first name
    // Must start with uppercase and contain minimum 3 letters
    public static boolean validateFirstName(String firstName) {
        return firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC2: Validate last name
    // Must start with uppercase and contain minimum 3 letters
    public static boolean validateLastName(String lastName) {
        return lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC3: Validate email address
    // Example: abc.xyz@bl.co.in
    public static boolean validateEmail(String email) {
        return email.matches(
                "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@" +
                        "[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$"
        );
    }

    // UC4: Validate mobile number
    // Country code, one space, followed by 10 digits
    public static boolean validateMobile(String mobile) {
        return mobile.matches("^[0-9]{2} [0-9]{10}$");
    }

    // UC5-UC8: Validate password
    // Rule 1: Minimum 8 characters
    // Rule 2: At least one uppercase letter
    // Rule 3: At least one number
    // Rule 4: Exactly one special character
    public static boolean validatePassword(String password) {

        // Check minimum length
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;
        int specialCount = 0;

        // Traverse each character in the password
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            // Check uppercase character
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }

            // Check numeric character
            else if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            // Count special characters
            else if (!Character.isLetterOrDigit(ch)) {
                specialCount++;
            }
        }

        // All password rules must pass
        return hasUpperCase && hasDigit && specialCount == 1;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get user details
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Display validation results
        System.out.println("First Name: " +
                (validateFirstName(firstName) ? "Valid" : "Invalid"));

        System.out.println("Last Name: " +
                (validateLastName(lastName) ? "Valid" : "Invalid"));

        System.out.println("Email: " +
                (validateEmail(email) ? "Valid" : "Invalid"));

        System.out.println("Mobile: " +
                (validateMobile(mobile) ? "Valid" : "Invalid"));

        System.out.println("Password: " +
                (validatePassword(password) ? "Valid" : "Invalid"));

        sc.close();
    }
}

