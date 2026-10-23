package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(title + " by " + author);
    }
}

class Library {
    String name;
    ArrayList<Book> books = new ArrayList<>();

    Library(String name) {
        this.name = name;
    }

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        System.out.println("\nLibrary: " + name);
        for (Book book : books) {
            book.display();
        }
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first library name: ");
        Library l1 = new Library(sc.nextLine());

        System.out.print("Enter second library name: ");
        Library l2 = new Library(sc.nextLine());

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        Book b1 = new Book(title, author);

        System.out.print("Enter another book title: ");
        String title2 = sc.nextLine();

        System.out.print("Enter its author: ");
        String author2 = sc.nextLine();

        Book b2 = new Book(title2, author2);

        l1.addBook(b1);
        l1.addBook(b2);
        l2.addBook(b1);

        l1.displayBooks();
        l2.displayBooks();

        sc.close();
    }
}
