package javaConstructors.level1;
import java.util.Scanner;

/**
 * Represents a library book and its availability.
 */
class LibraryBook {
    String title;
    String author;
    double price;
    boolean availability;

    /**
     * Initializes a book with the provided details.
     *
     * @param title the book title
     * @param author the book author
     * @param price the book price
     */
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        availability = true;
    }

    /**
     * Borrows the book if it is available.
     */
    void borrowBook() {
        // Update availability only when the book can be borrowed.
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is unavailable.");
        }
    }

    /**
     * Displays the book details and availability.
     */
    void displayDetails() {
        // Print the current book information.
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + availability);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read book details from the user.
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        if (price < 0) {
            System.out.println("Price cannot be negative.");
            sc.close();
            return;
        }

        LibraryBook book = new LibraryBook(title, author, price);

        // Display, borrow, and display the updated status.
        book.displayDetails();
        book.borrowBook();
        book.displayDetails();

        sc.close();
    }
}
