package javaCollection.queues;

import java.util.*;

public class ReverseQueue {

    // Method to reverse the queue
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {

        // Create a stack to store queue elements
        Stack<Integer> stack = new Stack<>();

        // Remove elements from queue and push into stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Pop elements from stack and add back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        // Get number of elements
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        // Get queue elements from user
        System.out.println("Enter queue elements:");

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        // Display original queue
        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Display reversed queue
        System.out.println("Reversed Queue: " + queue);

        sc.close();
    }
}
