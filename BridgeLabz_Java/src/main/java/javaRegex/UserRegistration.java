package javaRegex;

import java.util.Scanner;

public class UserRegistration {

    // UC 1: First name must start with uppercase
    // Minimum 3 characters
    public static boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]{2,}");
    }

    // UC 2: Last name must start with uppercase
    // Minimum 3 characters
    public static boolean validateLastName(String lastName) {
        return lastName.matches("[A-Z][a-zA-Z]{2,}");
    }

    // UC 3 and UC 9: Email validation
    // Allows letters, digits, underscore, dot, hyphen and plus
    // Local part cannot start/end with dot or contain consecutive dots
    // Domain allows one or two suffix sections
    // Final TLD must contain at least 2 letters
    public static boolean validateEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9_+-]+(\\.[A-Za-z0-9_+-]+)*"
                        + "@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)?"
                        + "\\.[A-Za-z]{2,}$";

        return email.matches(emailRegex);
    }

    // UC 4: Mobile number validation
    // Two-digit country code, space and 10-digit mobile number
    public static boolean validateMobile(String mobile) {
        return mobile.matches("[0-9]{2} [0-9]{10}");
    }

    // UC 5 to UC 8: Password validation
    // Minimum 8 characters
    // At least one uppercase letter
    // At least one numeric digit
    // Exactly one special character
    public static boolean validatePassword(String password) {

        boolean minimumLength = password.length() >= 8;

        boolean uppercase = password.matches(".*[A-Z].*");

        boolean digit = password.matches(".*[0-9].*");

        // Count special characters
        int specialCount = password.replaceAll(
                "[a-zA-Z0-9]", ""
        ).length();

        return minimumLength && uppercase && digit
                && specialCount == 1;
    }

    // Test all email samples provided in the PDF
    public static void testEmailSamples() {

        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        String[] invalidEmails = {
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };

        System.out.println("\n===== VALID EMAIL TEST CASES =====");

        for (String email : validEmails) {
            System.out.println(email + " : "
                    + (validateEmail(email) ? "PASS" : "FAIL"));
        }

        System.out.println("\n===== INVALID EMAIL TEST CASES =====");

        for (String email : invalidEmails) {
            System.out.println(email + " : "
                    + (!validateEmail(email) ? "PASS" : "FAIL"));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

        System.out.println("\n===== VALIDATION RESULTS =====");

        // Validate each user detail
        boolean firstNameValid = validateFirstName(firstName);
        boolean lastNameValid = validateLastName(lastName);
        boolean emailValid = validateEmail(email);
        boolean mobileValid = validateMobile(mobile);
        boolean passwordValid = validatePassword(password);

        System.out.println("First Name: "
                + (firstNameValid ? "Valid" : "Invalid"));

        System.out.println("Last Name: "
                + (lastNameValid ? "Valid" : "Invalid"));

        System.out.println("Email: "
                + (emailValid ? "Valid" : "Invalid"));

        System.out.println("Mobile: "
                + (mobileValid ? "Valid" : "Invalid"));

        System.out.println("Password: "
                + (passwordValid ? "Valid" : "Invalid"));

        // Check whether all validations passed
        if (firstNameValid && lastNameValid && emailValid
                && mobileValid && passwordValid) {

            System.out.println("\nUser Registration Successful!");

        } else {

            System.out.println("\nUser Registration Failed!");
        }

        // Test all email samples from the second PDF
        testEmailSamples();

        sc.close();
    }
}

