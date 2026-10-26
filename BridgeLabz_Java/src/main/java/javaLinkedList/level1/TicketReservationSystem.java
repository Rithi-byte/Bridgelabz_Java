package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 9. Circular Linked List: Online Ticket Reservation System
 *
 * Problem Statement:
 * Design a ticket reservation system using a circular linked list.
 * Each node stores Ticket ID, Customer Name, Movie Name,
 * Seat Number, and Booking Time.
 *
 * Functionalities:
 * 1. Add a ticket reservation at the end of the list.
 * 2. Remove a ticket by Ticket ID.
 * 3. Display all booked tickets.
 * 4. Search for tickets by Customer Name or Movie Name.
 * 5. Calculate the total number of booked tickets.
 */

// Represents a ticket reservation.
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    // Initializes a ticket with the given details.
    Ticket(int ticketId, String customerName, String movieName,
           String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }

    // Displays the details of a ticket.
    void display() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Booking Time: " + bookingTime);
        System.out.println("--------------------------------");
    }
}

// Represents a node in the circular linked list.
class TicketNode {
    Ticket data;
    TicketNode next;

    // Creates a node containing a ticket.
    TicketNode(Ticket data) {
        this.data = data;
        this.next = null;
    }
}

public class TicketReservationSystem {

    // Head points to the first ticket.
    TicketNode head;

    // Tracks the number of booked tickets.
    int size = 0;

    /**
     * Adds a new ticket reservation at the end of the circular list.
     */
    void addTicket(Ticket ticket) {

        // Prevent duplicate ticket IDs.
        if (findTicketById(ticket.ticketId) != null) {
            System.out.println("Ticket ID already exists.");
            return;
        }

        TicketNode newNode = new TicketNode(ticket);

        // If the list is empty, the node points to itself.
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            // Find the last node in the circular list.
            TicketNode last = head;

            while (last.next != head) {
                last = last.next;
            }

            // Connect the last node to the new ticket.
            last.next = newNode;

            // Connect the new ticket back to head.
            newNode.next = head;
        }

        size++;

        System.out.println("Ticket booked successfully.");
    }

    /**
     * Finds a ticket using its Ticket ID.
     * Returns null if the ticket does not exist.
     */
    Ticket findTicketById(int ticketId) {

        // An empty list contains no tickets.
        if (head == null) {
            return null;
        }

        TicketNode current = head;

        // Traverse exactly one complete circle.
        do {
            if (current.data.ticketId == ticketId) {
                return current.data;
            }

            current = current.next;
        } while (current != head);

        return null;
    }

    /**
     * Removes a ticket using its Ticket ID.
     */
    void removeTicket(int ticketId) {

        // Handle an empty list.
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode current = head;
        TicketNode previous = null;

        // Search for the ticket by ID.
        do {
            if (current.data.ticketId == ticketId) {
                break;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        // If traversal returns to head, the ticket was not found.
        if (current.data.ticketId != ticketId) {
            System.out.println("Ticket not found.");
            return;
        }

        // Handle deletion when only one ticket exists.
        if (current.next == current) {
            head = null;
        } else {
            // If deleting head, find the last node first.
            if (current == head) {
                TicketNode last = head;

                while (last.next != head) {
                    last = last.next;
                }

                // Move head to the next node and close the circle.
                head = head.next;
                last.next = head;
            } else {
                // Skip the node being deleted.
                previous.next = current.next;
            }
        }

        size--;

        System.out.println("Ticket cancelled successfully.");
    }

    /**
     * Displays all booked tickets starting from head.
     */
    void displayTickets() {

        // Handle an empty reservation list.
        if (head == null) {
            System.out.println("No booked tickets available.");
            return;
        }

        TicketNode current = head;

        System.out.println("\n===== Booked Tickets =====");

        // Stop when traversal returns to head.
        do {
            current.data.display();
            current = current.next;
        } while (current != head);
    }

    /**
     * Searches for tickets by customer name.
     * Multiple tickets may belong to the same customer.
     */
    void searchByCustomerName(String customerName) {

        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode current = head;
        boolean found = false;

        // Visit each ticket and compare customer names.
        do {
            if (current.data.customerName.equalsIgnoreCase(customerName)) {
                current.data.display();
                found = true;
            }

            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for this customer.");
        }
    }

    /**
     * Searches for tickets by movie name.
     * Multiple tickets may belong to the same movie.
     */
    void searchByMovieName(String movieName) {

        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode current = head;
        boolean found = false;

        // Visit each ticket and compare movie names.
        do {
            if (current.data.movieName.equalsIgnoreCase(movieName)) {
                current.data.display();
                found = true;
            }

            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for this movie.");
        }
    }

    /**
     * Returns the total number of booked tickets.
     */
    int countTickets() {
        return size;
    }

    /**
     * Main method: displays the menu and accepts user input.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system =
                new TicketReservationSystem();

        int choice;

        // Repeat until the user chooses to exit.
        do {
            System.out.println("\n===== Ticket Reservation System =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name");
            System.out.println("5. Search by Movie Name");
            System.out.println("6. Count Booked Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    // Read ticket details from the user.
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter Movie Name: ");
                    String movieName = sc.nextLine();

                    System.out.print("Enter Seat Number: ");
                    String seatNumber = sc.nextLine();

                    System.out.print("Enter Booking Time: ");
                    String bookingTime = sc.nextLine();

                    // Create and add the ticket reservation.
                    Ticket ticket = new Ticket(
                            ticketId,
                            customerName,
                            movieName,
                            seatNumber,
                            bookingTime
                    );

                    system.addTicket(ticket);
                    break;
                }

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    system.removeTicket(sc.nextInt());
                    sc.nextLine();
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name: ");
                    system.searchByCustomerName(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Movie Name: ");
                    system.searchByMovieName(sc.nextLine());
                    break;

                case 6:
                    System.out.println(
                            "Total Booked Tickets: "
                                    + system.countTickets()
                    );
                    break;

                case 7:
                    System.out.println(
                            "Exiting Ticket Reservation System."
                    );
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}