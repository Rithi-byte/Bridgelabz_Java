package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 2. Doubly Linked List: Movie Management System
 *
 * Problem Statement:
 * Implement a movie management system using a doubly linked list.
 * Each node stores the Movie Title, Director, Year of Release, and Rating.
 *
 * Functionalities:
 * 1. Add a movie at the beginning, end, or a specific position.
 * 2. Remove a movie by Movie Title.
 * 3. Search for movies by Director or Rating.
 * 4. Display movies in forward and reverse order.
 * 5. Update a movie's Rating using its Movie Title.
 */

// Represents a movie and its details.
class Movie {
    String title;
    String director;
    int year;
    double rating;

    // Initializes a movie with the given details.
    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    // Displays the details of a movie.
    void display() {
        System.out.println("Movie Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year of Release: " + year);
        System.out.println("Rating: " + rating);
        System.out.println("-----------------------------");
    }
}

// Represents a node in the doubly linked list.
class MovieNode {
    Movie data;
    MovieNode prev;
    MovieNode next;

    // Creates a node containing a movie.
    MovieNode(Movie data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class MovieManagementSystem {

    // Head points to the first node.
    MovieNode head;

    // Tail points to the last node.
    MovieNode tail;

    /**
     * Adds a movie at the beginning of the list.
     */
    void addAtBeginning(Movie movie) {
        MovieNode newNode = new MovieNode(movie);

        // If the list is empty, the new node becomes both head and tail.
        if (head == null) {
            head = tail = newNode;
        } else {
            // Connect the new node to the current first node.
            newNode.next = head;
            head.prev = newNode;

            // Update head to the new node.
            head = newNode;
        }

        System.out.println("Movie added at the beginning.");
    }

    /**
     * Adds a movie at the end of the list.
     */
    void addAtEnd(Movie movie) {
        MovieNode newNode = new MovieNode(movie);

        // If the list is empty, initialize head and tail.
        if (head == null) {
            head = tail = newNode;
        } else {
            // Connect the current tail to the new node.
            tail.next = newNode;
            newNode.prev = tail;

            // Update tail to the new last node.
            tail = newNode;
        }

        System.out.println("Movie added at the end.");
    }

    /**
     * Adds a movie at a specified position.
     * Positions start from 1.
     */
    void addAtPosition(Movie movie, int position) {

        // Reject invalid positions.
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        // Position 1 means insertion at the beginning.
        if (position == 1) {
            addAtBeginning(movie);
            return;
        }

        MovieNode current = head;

        // Traverse until the node before the target position.
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        // If current is null, the position is beyond the list.
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        // If current is the last node, insert at the end.
        if (current == tail) {
            addAtEnd(movie);
            return;
        }

        MovieNode newNode = new MovieNode(movie);

        // Connect the new node to the next node.
        newNode.next = current.next;
        newNode.prev = current;

        // Update the neighboring nodes' links.
        current.next.prev = newNode;
        current.next = newNode;

        System.out.println("Movie added at position " + position + ".");
    }

    /**
     * Removes a movie using its title.
     */
    void removeByTitle(String title) {
        MovieNode current = head;

        // Search for the movie by title, ignoring letter case.
        while (current != null &&
                !current.data.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        // Report if the movie does not exist.
        if (current == null) {
            System.out.println("Movie not found.");
            return;
        }

        // If the movie is not the first node, update the previous node.
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            // Otherwise, move head to the next node.
            head = current.next;
        }

        // If the movie is not the last node, update the next node.
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            // Otherwise, move tail to the previous node.
            tail = current.prev;
        }

        System.out.println("Movie removed successfully.");
    }

    /**
     * Searches for movies by director.
     * Multiple movies may have the same director.
     */
    void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;

        // Traverse the list and display matching movies.
        while (current != null) {
            if (current.data.director.equalsIgnoreCase(director)) {
                current.data.display();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found for this director.");
        }
    }

    /**
     * Searches for movies by rating.
     */
    void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;

        // Find movies whose rating matches the given rating.
        while (current != null) {
            if (Double.compare(current.data.rating, rating) == 0) {
                current.data.display();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with this rating.");
        }
    }

    /**
     * Displays all movies from head to tail.
     */
    void displayForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode current = head;

        System.out.println("\nMovies in Forward Order:");

        // Follow next links to reach the end.
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }

    /**
     * Displays all movies from tail to head.
     */
    void displayReverse() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode current = tail;

        System.out.println("\nMovies in Reverse Order:");

        // Follow prev links to reach the beginning.
        while (current != null) {
            current.data.display();
            current = current.prev;
        }
    }

    /**
     * Updates the rating of a movie using its title.
     */
    void updateRating(String title, double newRating) {

        // Validate the rating before updating.
        if (newRating < 0 || newRating > 10) {
            System.out.println("Rating must be between 0 and 10.");
            return;
        }

        MovieNode current = head;

        // Search for the movie by title.
        while (current != null) {
            if (current.data.title.equalsIgnoreCase(title)) {

                // Update the movie's rating.
                current.data.rating = newRating;

                System.out.println("Movie rating updated successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Movie not found.");
    }

    /**
     * Main method: displays the menu and accepts user input.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagementSystem list = new MovieManagementSystem();

        int choice;

        // Continue displaying the menu until the user exits.
        do {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display Movies Forward");
            System.out.println("8. Display Movies Reverse");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                case 2:
                case 3: {
                    // Read the movie details from the user.
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();

                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();

                    System.out.print("Enter Rating (0-10): ");
                    double rating = sc.nextDouble();
                    sc.nextLine();

                    // Validate the rating before adding the movie.
                    if (rating < 0 || rating > 10) {
                        System.out.println("Rating must be between 0 and 10.");
                        break;
                    }

                    Movie movie = new Movie(title, director, year, rating);

                    // Call the appropriate insertion method.
                    if (choice == 1) {
                        list.addAtBeginning(movie);
                    } else if (choice == 2) {
                        list.addAtEnd(movie);
                    } else {
                        System.out.print("Enter position: ");
                        int position = sc.nextInt();
                        sc.nextLine();

                        list.addAtPosition(movie, position);
                    }

                    break;
                }

                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    list.removeByTitle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Director Name: ");
                    list.searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Rating to Search: ");
                    list.searchByRating(sc.nextDouble());
                    sc.nextLine();
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    sc.nextLine();

                    list.updateRating(title, newRating);
                    break;

                case 10:
                    System.out.println("Exiting Movie Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 10);

        sc.close();
    }
}