
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a book with a title and author.
 */
class LibraryBook {
    String title;
    String author;

    /**
     * Initializes a book with its title and author.
     *
     * @param title the book's title
     * @param author the book's author
     */
    LibraryBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Displays the book's title and author.
     */
    void display() {
        System.out.println(title + " by " + author);
    }
}

/**
 * Represents a library that stores a collection of books.
 */
class BookCollection {
    String name;
    ArrayList<LibraryBook> books = new ArrayList<>();

    /**
     * Initializes a library with the specified name.
     *
     * @param name the library's name
     */
    BookCollection(String name) {
        this.name = name;
    }

    /**
     * Adds a book to the library.
     *
     * @param book the book to add
     */
    void addBook(LibraryBook book) {
        books.add(book);
    }

    /**
     * Displays the library name and all its books.
     */
    void displayBooks() {
        System.out.println("\nLibrary: " + name);

        // Display each book stored in the library.
        for (LibraryBook book : books) {
            book.display();
        }
    }
}

/**
 * Demonstrates how books can be shared between libraries.
 */
public class LibraryDemo {

    /**
     * Executes the library demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create the first library.
        System.out.print("Enter first library name: ");
        BookCollection l1 = new BookCollection(sc.nextLine());

        // Create the second library.
        System.out.print("Enter second library name: ");
        BookCollection l2 = new BookCollection(sc.nextLine());

        // Read the first book's details.
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        // Create the first book object.
        LibraryBook b1 = new LibraryBook(title, author);

        // Read the second book's details.
        System.out.print("Enter another book title: ");
        String title2 = sc.nextLine();

        System.out.print("Enter its author: ");
        String author2 = sc.nextLine();

        // Create the second book object.
        LibraryBook b2 = new LibraryBook(title2, author2);

        // Add both books to the first library.
        l1.addBook(b1);
        l1.addBook(b2);

        // Share the first book object with the second library.
        l2.addBook(b1);

        // Display the books in both libraries.
        l1.displayBooks();
        l2.displayBooks();

        sc.close();
    }
}
