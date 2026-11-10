package javaCollection.queues;

import java.util.*;

public class GenerateBinaryNumbers {

    // Method to generate first N binary numbers
    public static void generateBinary(int n) {

        // Create a queue to store binary numbers
        Queue<String> queue = new LinkedList<>();

        // Insert the first binary number
        queue.add("1");

        System.out.println("Binary Numbers:");

        // Generate N binary numbers
        for (int i = 0; i < n; i++) {

            // Remove the front binary number
            String current = queue.remove();

            // Display current binary number
            System.out.print(current + " ");

            // Generate next two binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get N from user
        System.out.println("Enter N:");
        int n = sc.nextInt();

        // Generate binary numbers
        if (n > 0) {
            generateBinary(n);
        } else {
            System.out.println("Enter a positive number.");
        }

        sc.close();
    }
}

