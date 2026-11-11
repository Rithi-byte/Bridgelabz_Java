package javaExceptions.problemStatement1;

import java.util.*;

// Class representing a resource connection
class MyConnection {

    // Method to establish connection
    public void connect() {
        System.out.println("Connection established.");
    }

    // Method to perform an operation
    public void performOperation() {

        System.out.println("Performing operation...");

        // Simulate an exception
        throw new RuntimeException("Operation failed!");
    }

    // Method to close connection
    public void close() {
        System.out.println("Connection closed.");
    }
}

public class ResourceCleanup {

    public static void main(String[] args) {

        // Create connection object
        MyConnection connection = new MyConnection();

        try {

            // Establish connection
            connection.connect();

            // Perform operation
            connection.performOperation();

        } catch (RuntimeException e) {

            // Handle exception
            System.out.println("Error: " + e.getMessage());

        } finally {

            // Cleanup executes whether exception occurs or not
            connection.close();

            System.out.println("Cleanup completed.");
        }
    }
}
