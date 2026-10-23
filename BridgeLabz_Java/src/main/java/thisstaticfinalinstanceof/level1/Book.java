
package thisstaticfinalinstanceof.level1;

import java.util.Scanner;

/**
 * Represents a book and demonstrates static, final, and instanceof concepts.
 */
class Book {

    // Shared library name accessible to all Book objects.
    static String libraryName = "Central Library";

    // Instance variables store the details of each book.
    String title;
    String author;

    // Final ISBN can be assigned only once during initialization.
    final String isbn;

    /**
     * Initializes a book with its title, author, and ISBN.
     *
     * @param title the book's title
     * @param author the author's name
     * @param isbn the book's ISBN
     */
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Displays the shared library name.
     */
    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    /**
     * Displays the details of the book.
     */
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    /**
     * Demonstrates creating a book and checking its runtime type.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the book title.
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        // Read the author's name.
        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        // Read the book's ISBN.
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        // Create a Book object using the entered details.
        Book book = new Book(title, author, isbn);

        // Call the static method using the class.
        displayLibraryName();

        // Store the Book reference in a variable of type Object.
        Object obj = book;

        // Check the object's type before casting and calling its method.
        if (obj instanceof Book) {
            ((Book) obj).displayDetails();
        }

        // Close the Scanner after input is complete.
        sc.close();
    }
}
