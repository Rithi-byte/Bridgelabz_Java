package classesAndObject.level1;

import java.util.Scanner;

/**
 * Represents a book and displays its details.
 */
class Book {
    String title;
    String author;
    double price;

    /**
     * Displays the book's title, author, and price.
     */
    void displayDetails() {
        // Display book information.
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book();

        // Read book details from the user.
        System.out.print("Enter book title: ");
        b1.title = sc.nextLine();

        System.out.print("Enter author: ");
        b1.author = sc.nextLine();

        System.out.print("Enter price: ");
        b1.price = sc.nextDouble();

        // Display the entered book details.
        b1.displayDetails();
        sc.close();
    }
}
