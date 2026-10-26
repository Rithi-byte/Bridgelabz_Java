package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 3. Circular Linked List: Task Scheduler
 *
 * Problem Statement:
 * Create a task scheduler using a circular linked list.
 * Each node stores Task ID, Task Name, Priority, and Due Date.
 *
 * Functionalities:
 * 1. Add a task at the beginning, end, or a specific position.
 * 2. Remove a task by Task ID.
 * 3. View the current task and move to the next task.
 * 4. Display all tasks starting from the head node.
 * 5. Search for tasks by Priority.
 */

// Represents a task and its details.
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    // Initializes a task with the given details.
    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Displays the details of a task.
    void display() {
        System.out.println("Task ID: " + taskId);
        System.out.println("Task Name: " + taskName);
        System.out.println("Priority: " + priority);
        System.out.println("Due Date: " + dueDate);
        System.out.println("--------------------------");
    }
}

// Represents a node in the circular linked list.
class TaskNode {
    Task data;
    TaskNode next;

    // Creates a node containing a task.
    TaskNode(Task data) {
        this.data = data;
        this.next = null;
    }
}

public class TaskScheduler {

    // Head points to the first node.
    TaskNode head;

    // Current points to the task currently being viewed.
    TaskNode current;

    /**
     * Adds a task at the beginning of the circular linked list.
     */
    void addAtBeginning(Task task) {
        TaskNode newNode = new TaskNode(task);

        // If the list is empty, the node points to itself.
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            // Find the last node in the circular list.
            TaskNode last = head;

            while (last.next != head) {
                last = last.next;
            }

            // Insert the new node before the current head.
            newNode.next = head;
            last.next = newNode;

            // Update head to the new first node.
            head = newNode;
        }

        // Initialize current when the first task is added.
        if (current == null) {
            current = head;
        }

        System.out.println("Task added at the beginning.");
    }

    /**
     * Adds a task at the end of the circular linked list.
     */
    void addAtEnd(Task task) {
        TaskNode newNode = new TaskNode(task);

        // If the list is empty, the node points to itself.
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            // Find the last node.
            TaskNode last = head;

            while (last.next != head) {
                last = last.next;
            }

            // Connect the last node to the new node.
            last.next = newNode;

            // The new node points back to head.
            newNode.next = head;
        }

        // Set the current task if this is the first task.
        if (current == null) {
            current = head;
        }

        System.out.println("Task added at the end.");
    }

    /**
     * Adds a task at a specified position.
     * Positions start from 1.
     */
    void addAtPosition(Task task, int position) {

        // Reject invalid positions.
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        // Position 1 means insertion at the beginning.
        if (position == 1) {
            addAtBeginning(task);
            return;
        }

        // Find the number of nodes in the circular list.
        int size = getSize();

        // Allow insertion only from position 1 to size + 1.
        if (position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }

        // Inserting at size + 1 means adding at the end.
        if (position == size + 1) {
            addAtEnd(task);
            return;
        }

        TaskNode newNode = new TaskNode(task);
        TaskNode temp = head;

        // Move to the node immediately before the target position.
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        // Insert the new node between temp and its next node.
        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Task added at position " + position + ".");
    }

    /**
     * Returns the number of nodes in the circular linked list.
     */
    int getSize() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        TaskNode temp = head;

        // Stop when traversal returns to head.
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    /**
     * Removes a task using its Task ID.
     */
    void removeByTaskId(int taskId) {

        // An empty list has no tasks to remove.
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode currentNode = head;
        TaskNode previous = null;

        // Search for the task by ID.
        do {
            if (currentNode.data.taskId == taskId) {
                break;
            }

            previous = currentNode;
            currentNode = currentNode.next;

        } while (currentNode != head);

        // If traversal returns to head, the task was not found.
        if (currentNode.data.taskId != taskId) {
            System.out.println("Task not found.");
            return;
        }

        // Handle the case where only one node exists.
        if (currentNode.next == currentNode) {
            head = null;
            current = null;
        } else {
            // If deleting head, find the last node first.
            if (currentNode == head) {
                TaskNode last = head;

                while (last.next != head) {
                    last = last.next;
                }

                // Move head to the next node and close the circle.
                head = head.next;
                last.next = head;
            } else {
                // Skip the node being deleted.
                previous.next = currentNode.next;
            }

            // If the current task was deleted, move to the next task.
            if (current == currentNode) {
                current = currentNode.next;
            }
        }

        System.out.println("Task removed successfully.");
    }

    /**
     * Displays the current task and moves to the next task.
     */
    void viewCurrentAndMoveNext() {

        // Check whether the list contains any tasks.
        if (head == null || current == null) {
            System.out.println("No tasks available.");
            return;
        }

        // Display the current task.
        System.out.println("Current Task:");
        current.data.display();

        // Move to the next task.
        current = current.next;

        // The circular link automatically returns to head after the last task.
        System.out.println("Moved to the next task.");
    }

    /**
     * Displays all tasks starting from the head node.
     */
    void displayAll() {

        // Handle an empty list.
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;

        System.out.println("\nAll Tasks:");

        // Traverse until we return to head.
        do {
            temp.data.display();
            temp = temp.next;
        } while (temp != head);
    }

    /**
     * Searches for all tasks with a specified priority.
     */
    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        // Visit each node and check its priority.
        do {
            if (temp.data.priority == priority) {
                temp.data.display();
                found = true;
            }

            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with this priority.");
        }
    }

    /**
     * Main method: displays the menu and accepts user input.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        int choice;

        // Repeat until the user chooses to exit.
        do {
            System.out.println("\n===== Task Scheduler =====");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                case 2:
                case 3: {
                    // Read task details from the user.
                    System.out.print("Enter Task ID: ");
                    int taskId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    String taskName = sc.nextLine();

                    System.out.print("Enter Priority (1 = highest): ");
                    int priority = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Due Date (DD-MM-YYYY): ");
                    String dueDate = sc.nextLine();

                    Task task = new Task(taskId, taskName, priority, dueDate);

                    // Perform the selected insertion operation.
                    if (choice == 1) {
                        scheduler.addAtBeginning(task);
                    } else if (choice == 2) {
                        scheduler.addAtEnd(task);
                    } else {
                        System.out.print("Enter position: ");
                        int position = sc.nextInt();
                        sc.nextLine();

                        scheduler.addAtPosition(task, position);
                    }

                    break;
                }

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    scheduler.removeByTaskId(sc.nextInt());
                    sc.nextLine();
                    break;

                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;

                case 6:
                    scheduler.displayAll();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    scheduler.searchByPriority(sc.nextInt());
                    sc.nextLine();
                    break;

                case 8:
                    System.out.println("Exiting Task Scheduler.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}