package javaConstructors.level3;
import java.util.Scanner;

/**
 * Represents a book in a library.
 */
class Book {
    public String ISBN;
    protected String title;
    private String author;

    /**
     * Initializes the book details.
     *
     * @param ISBN the book's ISBN
     * @param title the book title
     * @param author the book author
     */
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    /**
     * Sets the book's author.
     *
     * @param author the author's name
     */
    public void setAuthor(String author) {
        // Update the private author field.
        this.author = author;
    }

    /**
     * Returns the book's author.
     *
     * @return the author's name
     */
    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read book details.
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        EBook book = new EBook(isbn, title, author);
        book.displayDetails();

        // Demonstrate modifying the private author field through a setter.
        System.out.print("Enter updated author: ");
        book.setAuthor(sc.nextLine());

        System.out.println("Updated Author: " + book.getAuthor());

        sc.close();
    }
}

/**
 * Represents an electronic book.
 */
class EBook extends Book {

    /**
     * Initializes an electronic book.
     *
     * @param ISBN the book's ISBN
     * @param title the book title
     * @param author the book author
     */
    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    /**
     * Displays electronic book details.
     */
    void displayDetails() {
        // Access public and protected members directly.
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);

        // Access the private author using its public getter.
        System.out.println("Author: " + getAuthor());
    }
}
