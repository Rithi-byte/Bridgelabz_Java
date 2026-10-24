
package encapsulation_Polymorphism_Interface_Abstract;

import java.util.ArrayList;
import java.util.List;

// Interface for reservable library items
interface Reservable {
    void reserveItem(String borrowerName);

    boolean checkAvailability();
}

// Abstract parent class for library items
abstract class LibraryItem implements Reservable {

    // Encapsulated item details
    private int itemId;
    private String title;
    private String author;

    // Availability and borrower details
    private boolean available;
    private String borrowerName;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrowerName = null;
    }

    // Getter methods
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Abstract method implemented by subclasses
    public abstract int getLoanDuration();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: "
                + getLoanDuration() + " days");
        System.out.println("Available: " + checkAvailability());
    }

    // Reserve an item if it is available
    @Override
    public void reserveItem(String borrowerName) {
        if (borrowerName == null || borrowerName.trim().isEmpty()) {
            System.out.println("Invalid borrower name.");
            return;
        }

        if (available) {
            this.borrowerName = borrowerName;
            available = false;
            System.out.println(title + " reserved successfully.");
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    // Check whether the item is available
    @Override
    public boolean checkAvailability() {
        return available;
    }
}

// Book: 14-day loan period
class Book extends LibraryItem {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }
}

// Magazine: 7-day loan period
class Magazine extends LibraryItem {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }
}

// DVD: 3-day loan period
class DVD extends LibraryItem {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }
}

// Main class
public class LibraryManagementSystem {

    // Manage all item types using the parent reference
    public static void displayItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {

        // Polymorphism: one list stores different item types
        List<LibraryItem> items = new ArrayList<>();

        LibraryItem item1 =
                new Book(101, "Java Programming", "James Gosling");

        LibraryItem item2 =
                new Magazine(102, "Science Today", "Editorial Team");

        LibraryItem item3 =
                new DVD(103, "Java Tutorials", "Learning Studio");

        items.add(item1);
        items.add(item2);
        items.add(item3);

        // Display all items
        displayItems(items);

        // Reserve an item
        item1.reserveItem("Rithi");

        // Check availability after reservation
        System.out.println(
                "Book available: " + item1.checkAvailability());

        // Attempt to reserve the same item again
        item1.reserveItem("Raj");
    }
}
