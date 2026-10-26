package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 1. Singly Linked List: Student Record Management
 *
 * Problem Statement:
 * Create a program to manage student records using a singly linked list.
 * Each node stores a student's Roll Number, Name, Age, and Grade.
 *
 * Operations:
 * 1. Add a student at the beginning, end, or a specific position.
 * 2. Delete a student record by Roll Number.
 * 3. Search for a student record by Roll Number.
 * 4. Display all student records.
 * 5. Update a student's grade using their Roll Number.
 */
class Student {

    // Stores the student's details.
    int rollNumber;
    String name;
    int age;
    String grade;

    // Initializes a student object with the given details.
    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Displays the student's information.
    void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------");
    }
}

// Represents one node in the singly linked list.
class Node {

    Student data;
    Node next;

    // Creates a node containing a student record.
    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

public class StudentRecordManagement {

    // Head points to the first node of the linked list.
    Node head;

    /**
     * Adds a student record at the beginning of the list.
     */
    void addAtBeginning(Student student) {
        Node newNode = new Node(student);

        // Connect the new node to the current first node.
        newNode.next = head;

        // Make the new node the first node.
        head = newNode;

        System.out.println("Student added at the beginning.");
    }

    /**
     * Adds a student record at the end of the list.
     */
    void addAtEnd(Student student) {
        Node newNode = new Node(student);

        // If the list is empty, the new node becomes the head.
        if (head == null) {
            head = newNode;
            System.out.println("Student added at the end.");
            return;
        }

        // Traverse the list until the last node is reached.
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Connect the last node to the new node.
        current.next = newNode;

        System.out.println("Student added at the end.");
    }

    /**
     * Adds a student record at a specified position.
     * Positions start from 1.
     */
    void addAtPosition(Student student, int position) {

        // Positions must be positive.
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        // Position 1 means insertion at the beginning.
        if (position == 1) {
            addAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node current = head;

        // Move to the node immediately before the target position.
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        // If current is null, the position is out of range.
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        // Insert the new node into the list.
        newNode.next = current.next;
        current.next = newNode;

        System.out.println("Student added at position " + position + ".");
    }

    /**
     * Deletes a student record using the roll number.
     */
    void deleteByRollNumber(int rollNumber) {

        // An empty list contains no student records to delete.
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Handle deletion of the first node separately.
        if (head.data.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student record deleted.");
            return;
        }

        Node current = head;

        // Find the node immediately before the target student.
        while (current.next != null
                && current.next.data.rollNumber != rollNumber) {
            current = current.next;
        }

        // If the target student does not exist, report it.
        if (current.next == null) {
            System.out.println("Student not found.");
            return;
        }

        // Skip the target node to remove it from the list.
        current.next = current.next.next;

        System.out.println("Student record deleted.");
    }

    /**
     * Searches for a student using their roll number.
     */
    void searchByRollNumber(int rollNumber) {
        Node current = head;

        // Visit each node until the student is found or the list ends.
        while (current != null) {

            if (current.data.rollNumber == rollNumber) {
                System.out.println("Student found:");
                current.data.display();
                return;
            }

            current = current.next;
        }

        System.out.println("Student not found.");
    }

    /**
     * Displays all student records in the list.
     */
    void displayAll() {

        // Check whether the list has any nodes.
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Node current = head;

        // Traverse the list and display every student.
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }

    /**
     * Updates a student's grade using their roll number.
     */
    void updateGrade(int rollNumber, String newGrade) {
        Node current = head;

        // Search for the student whose grade must be updated.
        while (current != null) {

            if (current.data.rollNumber == rollNumber) {

                // Replace the existing grade with the new grade.
                current.data.grade = newGrade;

                System.out.println("Student grade updated successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Student not found.");
    }

    /**
     * Main method: displays the menu and accepts user input.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentRecordManagement list = new StudentRecordManagement();

        int choice;

        // Repeat the menu until the user chooses to exit.
        do {
            System.out.println("\n===== Student Record Management =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Display All Students");
            System.out.println("7. Update Student Grade");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                case 2:
                case 3: {
                    // Read the new student's details.
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    Student student = new Student(roll, name, age, grade);

                    // Call the appropriate insertion method.
                    if (choice == 1) {
                        list.addAtBeginning(student);
                    } else if (choice == 2) {
                        list.addAtEnd(student);
                    } else {
                        System.out.print("Enter position: ");
                        int position = sc.nextInt();
                        list.addAtPosition(student, position);
                    }
                    break;
                }

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    list.deleteByRollNumber(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    list.searchByRollNumber(sc.nextInt());
                    break;

                case 6:
                    list.displayAll();
                    break;

                case 7:
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Grade: ");
                    String newGrade = sc.nextLine();

                    list.updateGrade(roll, newGrade);
                    break;

                case 8:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}