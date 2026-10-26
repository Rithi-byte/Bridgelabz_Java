package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 5. Doubly Linked List: Library Management System
 *
 * Problem Statement:
 * Design a library management system using a doubly linked list.
 * Each node stores Book Title, Author, Genre, Book ID,
 * and Availability Status.
 *
 * Functionalities:
 * 1. Add a book at the beginning, end, or a specific position.
 * 2. Remove a book by Book ID.
 * 3. Search for a book by Title or Author.
 * 4. Update a book's Availability Status.
 * 5. Display books in forward and reverse order.
 * 6. Count the total number of books.
 */

// Represents a book and its details.
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;

    // Initializes a book with the given details.
    Book(String title, String author, String genre,
         int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
    }

    // Displays the details of a book.
    void display() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Book ID: " + bookId);
        System.out.println("Availability: "
                + (available ? "Available" : "Not Available"));
        System.out.println("--------------------------------");
    }
}

// Represents a node in the doubly linked list.
class BookNode {
    Book data;
    BookNode prev;
    BookNode next;

    // Creates a node containing a book.
    BookNode(Book data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class LibraryManagementSystem {

    // Head points to the first node.
    BookNode head;

    // Tail points to the last node.
    BookNode tail;

    /**
     * Adds a book at the beginning of the list.
     */
    void addAtBeginning(Book book) {
        BookNode newNode = new BookNode(book);

        // If the list is empty, the new node becomes head and tail.
        if (head == null) {
            head = tail = newNode;
        } else {
            // Connect the new node to the existing first node.
            newNode.next = head;
            head.prev = newNode;

            // Update head to the new node.
            head = newNode;
        }

        System.out.println("Book added at the beginning.");
    }

    /**
     * Adds a book at the end of the list.
     */
    void addAtEnd(Book book) {
        BookNode newNode = new BookNode(book);

        // If the list is empty, initialize head and tail.
        if (head == null) {
            head = tail = newNode;
        } else {
            // Connect the current last node to the new node.
            tail.next = newNode;
            newNode.prev = tail;

            // Update tail to the new last node.
            tail = newNode;
        }

        System.out.println("Book added at the end.");
    }

    /**
     * Adds a book at a specific position.
     * Positions start from 1.
     */
    void addAtPosition(Book book, int position) {

        // Reject invalid positions.
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        // Position 1 means insertion at the beginning.
        if (position == 1) {
            addAtBeginning(book);
            return;
        }

        BookNode current = head;

        // Move to the node immediately before the target position.
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        // If current is null, the position is out of range.
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        // If current is the last node, insert at the end.
        if (current == tail) {
            addAtEnd(book);
            return;
        }

        BookNode newNode = new BookNode(book);

        // Connect the new node to its neighboring nodes.
        newNode.next = current.next;
        newNode.prev = current;

        // Update the neighboring nodes' links.
        current.next.prev = newNode;
        current.next = newNode;

        System.out.println("Book added at position " + position + ".");
    }

    /**
     * Removes a book using its Book ID.
     */
    void removeByBookId(int bookId) {
        BookNode current = head;

        // Search for the book by its ID.
        while (current != null && current.data.bookId != bookId) {
            current = current.next;
        }

        // Report if the book does not exist.
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        // Update the previous node or move head.
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        // Update the next node or move tail.
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        System.out.println("Book removed successfully.");
    }

    /**
     * Searches for books by title.
     * Multiple books may have the same title.
     */
    void searchByTitle(String title) {
        BookNode current = head;
        boolean found = false;

        // Traverse the list and display matching titles.
        while (current != null) {
            if (current.data.title.equalsIgnoreCase(title)) {
                current.data.display();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No books found with this title.");
        }
    }

    /**
     * Searches for books by author.
     * Multiple books may have the same author.
     */
    void searchByAuthor(String author) {
        BookNode current = head;
        boolean found = false;

        // Traverse the list and display matching authors.
        while (current != null) {
            if (current.data.author.equalsIgnoreCase(author)) {
                current.data.display();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No books found for this author.");
        }
    }

    /**
     * Updates a book's availability status using Book ID.
     */
    void updateAvailability(int bookId, boolean available) {
        BookNode current = head;

        // Search for the book by its ID.
        while (current != null) {
            if (current.data.bookId == bookId) {

                // Update the availability status.
                current.data.available = available;

                System.out.println("Availability updated successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Book not found.");
    }

    /**
     * Displays all books from head to tail.
     */
    void displayForward() {

        // Check whether the library contains any books.
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = head;

        System.out.println("\nBooks in Forward Order:");

        // Follow next links to reach the end.
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }

    /**
     * Displays all books from tail to head.
     */
    void displayReverse() {

        // Check whether the library contains any books.
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = tail;

        System.out.println("\nBooks in Reverse Order:");

        // Follow prev links to reach the beginning.
        while (current != null) {
            current.data.display();
            current = current.prev;
        }
    }

    /**
     * Counts the total number of books in the library.
     */
    int countBooks() {
        int count = 0;
        BookNode current = head;

        // Visit each node and increment the count.
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Main method: displays the menu and accepts user input.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem library =
                new LibraryManagementSystem();

        int choice;

        // Repeat the menu until the user chooses to exit.
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Specific Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display Books Forward");
            System.out.println("9. Display Books Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                case 2:
                case 3: {
                    // Read the book details from the user.
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Is the book available? (true/false): ");
                    boolean available = sc.nextBoolean();
                    sc.nextLine();

                    Book book = new Book(
                            title, author, genre, bookId, available);

                    // Call the appropriate insertion method.
                    if (choice == 1) {
                        library.addAtBeginning(book);
                    } else if (choice == 2) {
                        library.addAtEnd(book);
                    } else {
                        System.out.print("Enter position: ");
                        int position = sc.nextInt();
                        sc.nextLine();

                        library.addAtPosition(book, position);
                    }

                    break;
                }

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    library.removeByBookId(sc.nextInt());
                    sc.nextLine();
                    break;

                case 5:
                    System.out.print("Enter Book Title to search: ");
                    library.searchByTitle(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Author Name to search: ");
                    library.searchByAuthor(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    System.out.print(
                            "Enter availability (true/false): ");
                    boolean status = sc.nextBoolean();
                    sc.nextLine();

                    library.updateAvailability(id, status);
                    break;

                case 8:
                    library.displayForward();
                    break;

                case 9:
                    library.displayReverse();
                    break;

                case 10:
                    System.out.println(
                            "Total Number of Books: "
                                    + library.countBooks());
                    break;

                case 11:
                    System.out.println(
                            "Exiting Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 11);

        sc.close();
    }
}