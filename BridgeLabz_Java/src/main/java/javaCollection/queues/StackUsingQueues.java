package javaCollection.queues;

import java.util.*;

public class StackUsingQueues {

    // Create two queues
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public static void push(int value) {

        // Add new element to second queue
        q2.add(value);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println(value + " pushed into stack.");
    }

    // Pop operation
    public static void pop() {

        // Check whether stack is empty
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        // Remove the front element
        System.out.println("Popped: " + q1.remove());
    }

    // Top operation
    public static void top() {

        // Check whether stack is empty
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        // Display the top element
        System.out.println("Top Element: " + q1.peek());
    }

    // Display stack elements
    public static void display() {

        System.out.println("Stack: " + q1);
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        // Menu-driven stack operations
        do {

            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter value:");
                    int value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    top();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

