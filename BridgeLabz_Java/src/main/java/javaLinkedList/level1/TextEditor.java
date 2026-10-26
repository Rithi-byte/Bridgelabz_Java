package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 8. Doubly Linked List: Undo/Redo Functionality for Text Editor
 *
 * Problem Statement:
 * Implement undo and redo functionality using a doubly linked list.
 * Each node represents a state of the text after an editing operation.
 *
 * Functionalities:
 * 1. Add a new text state after every editing operation.
 * 2. Undo to the previous text state.
 * 3. Redo to the next text state.
 * 4. Display the current text.
 * 5. Limit history to the most recent 10 states.
 */

// Represents one snapshot of the text.
class TextState {
    String content;

    // Initializes a text snapshot.
    TextState(String content) {
        this.content = content;
    }
}

// Represents a node in the doubly linked list.
class StateNode {
    TextState data;
    StateNode prev;
    StateNode next;

    // Creates a node containing a text state.
    StateNode(TextState data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {

    // Points to the oldest state in the history.
    StateNode head;

    // Points to the newest state in the history.
    StateNode tail;

    // Points to the currently active text state.
    StateNode current;

    // Maximum number of states retained in history.
    final int MAX_HISTORY = 10;

    // Tracks the number of stored states.
    int size = 0;

    /**
     * Initializes the editor with an empty text state.
     */
    TextEditor() {
        TextState initialState = new TextState("");
        StateNode node = new StateNode(initialState);

        head = tail = current = node;
        size = 1;
    }

    /**
     * Adds a new text state after an editing operation.
     */
    void addState(String content) {

        StateNode newNode = new StateNode(new TextState(content));

        // If undo was performed, discard the redo history.
        // A new edit creates a new future, replacing the old one.
        if (current.next != null) {
            StateNode temp = current.next;

            while (temp != null) {
                size--;
                temp = temp.next;
            }

            current.next = null;
            tail = current;
        }

        // Append the new state after the current state.
        newNode.prev = current;
        current.next = newNode;

        // Update current and tail to the new state.
        current = newNode;
        tail = newNode;
        size++;

        // Remove the oldest states if history exceeds the limit.
        while (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text updated successfully.");
    }

    /**
     * Reverts to the previous text state.
     */
    void undo() {

        // Undo is possible only when a previous state exists.
        if (current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        // Move the current pointer one node backward.
        current = current.prev;

        System.out.println("Undo successful.");
        displayCurrentState();
    }

    /**
     * Moves forward to the next state after an undo.
     */
    void redo() {

        // Redo is possible only when a next state exists.
        if (current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }

        // Move the current pointer one node forward.
        current = current.next;

        System.out.println("Redo successful.");
        displayCurrentState();
    }

    /**
     * Displays the currently active text.
     */
    void displayCurrentState() {
        System.out.println("\nCurrent Text:");
        System.out.println(current.data.content);
    }

    /**
     * Displays all stored states from oldest to newest.
     */
    void displayHistory() {

        StateNode temp = head;

        System.out.println("\nText History:");

        // Traverse from head to tail.
        while (temp != null) {

            // Mark the active state.
            if (temp == current) {
                System.out.println("-> [CURRENT] " + temp.data.content);
            } else {
                System.out.println("   " + temp.data.content);
            }

            temp = temp.next;
        }

        System.out.println("Stored states: " + size + "/" + MAX_HISTORY);
    }

    /**
     * Main method: provides a menu-driven text editor.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        int choice;

        // Continue until the user chooses to exit.
        do {
            System.out.println("\n===== Text Editor =====");
            System.out.println("1. Type or Replace Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display Text History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    // Read the new complete text snapshot.
                    System.out.print("Enter the new text: ");
                    String text = sc.nextLine();

                    // Save the new state in the history.
                    editor.addState(text);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrentState();
                    break;

                case 5:
                    editor.displayHistory();
                    break;

                case 6:
                    System.out.println("Exiting Text Editor.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}