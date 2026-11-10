package javaCollection.queues;

import java.util.*;

public class CircularBuffer {

    // Array to store buffer elements
    static int[] buffer;

    // Front points to the oldest element
    static int front = 0;

    // Rear points to the next insertion position
    static int rear = 0;

    // Track number of elements
    static int size = 0;

    // Store maximum buffer capacity
    static int capacity;

    // Constructor to initialize circular buffer
    CircularBuffer(int capacity) {

        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Insert element into circular buffer
    public static void insert(int value) {

        // If buffer is full, overwrite oldest element
        if (size == capacity) {

            System.out.println(
                    "Buffer full! Overwriting oldest element: "
                            + buffer[front]
            );

            // Move front to the next oldest element
            front = (front + 1) % capacity;

            // Update rear position
            rear = (rear + 1) % capacity;

        } else {

            // Increase size if buffer is not full
            size++;
        }

        // Insert new element at rear position
        buffer[rear] = value;

        // Move rear circularly
        rear = (rear + 1) % capacity;

        System.out.println(value + " inserted.");
    }

    // Display circular buffer elements
    public static void display() {

        System.out.print("Buffer: [");

        // Traverse elements from front to rear
        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.print(buffer[index]);

            if (i < size - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get buffer capacity
        System.out.println("Enter buffer size:");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Buffer size must be positive.");
            sc.close();
            return;
        }

        // Create circular buffer
        new CircularBuffer(n);

        int choice;

        // Menu-driven operations
        do {

            System.out.println("\n1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Exit");

            System.out.println("Enter choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter value:");
                    int value = sc.nextInt();
                    insert(value);
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}

