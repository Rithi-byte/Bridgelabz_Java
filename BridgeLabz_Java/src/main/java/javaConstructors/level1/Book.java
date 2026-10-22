package javaConstructors.level1;
import java.util.Scanner;

/**
 * Represents a book with its title, author, and price.
 */
class Book {
    String title;
    String author;
    double price;

    /**
     * Initializes a book with default values.
     */
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    /**
     * Initializes a book with user-provided values.
     *
     * @param title the book title
     * @param author the book author
     * @param price the book price
     */
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Displays the book details.
     */
    void displayDetails() {
        // Print the book attributes.
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a book using the default constructor.
        Book b1 = new Book();
        System.out.println("Default Book:");
        b1.displayDetails();

        // Read details for the parameterized constructor.
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Book b2 = new Book(title, author, price);

        System.out.println("User-Provided Book:");
        b2.displayDetails();

        sc.close();
    }
}
