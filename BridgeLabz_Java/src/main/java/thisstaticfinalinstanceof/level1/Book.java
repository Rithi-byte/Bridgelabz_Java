package thisstaticfinalinstanceof.level1;
import java.util.Scanner;

class Book {
    static String libraryName = "Central Library";

    String title;
    String author;
    final String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        Book book = new Book(title, author, isbn);

        displayLibraryName();

        Object obj = book;
        if (obj instanceof Book) {
            ((Book) obj).displayDetails();
        }

        sc.close();
    }
}
