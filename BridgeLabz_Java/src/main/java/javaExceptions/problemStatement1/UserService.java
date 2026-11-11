package javaExceptions.problemStatement1;

import java.util.*;

// Custom exception for existing users
class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

// Custom exception for users not found
class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {

    // Store registered usernames
    static Set<String> users = new HashSet<>();

    // Register a new user
    public static void registerUser(String username)
            throws UserAlreadyExistsException {

        // Check whether user already exists
        if (users.contains(username)) {

            // Explicitly throw custom exception
            throw new UserAlreadyExistsException(
                    "User already exists: " + username
            );
        }

        // Add new user
        users.add(username);

        System.out.println("User registered successfully!");
    }

    // Check whether a user exists
    public static void checkUserExistence(String username)
            throws UserNotFoundException {

        // Check whether username is available
        if (!users.contains(username)) {

            // Throw exception if user is not found
            throw new UserNotFoundException(
                    "User not found: " + username
            );
        }

        System.out.println("User exists: " + username);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username to register: ");
        String username = sc.nextLine();

        try {

            // Register the user
            registerUser(username);

        } catch (UserAlreadyExistsException e) {

            System.out.println("Registration Error: " + e.getMessage());
        }

        System.out.print("Enter username to search: ");
        String search = sc.nextLine();

        try {

            // Check user existence
            checkUserExistence(search);

        } catch (UserNotFoundException e) {

            System.out.println("Search Error: " + e.getMessage());
        }

        sc.close();
    }
}
