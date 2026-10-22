package classesAndObject.level2;

import java.util.Scanner;

/**
 * Represents a movie ticket and manages ticket booking.
 */
class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    /**
     * Books a ticket with the specified seat and price.
     *
     * @param seat the seat number to book
     * @param ticketPrice the price of the ticket
     */
    void bookTicket(String seat, double ticketPrice) {
        // Validate the booking details.
        if (isBooked) {
            System.out.println("Ticket is already booked.");
        } else if (seat == null || seat.trim().isEmpty()
                || ticketPrice <= 0) {
            System.out.println("Invalid seat or ticket price.");
        } else {
            seatNumber = seat;
            price = ticketPrice;
            isBooked = true;
            System.out.println("Ticket booked successfully.");
        }
    }

    /**
     * Displays the ticket details.
     */
    void displayDetails() {
        // Display the current booking status.
        System.out.println("Movie: " + movieName);

        if (isBooked) {
            System.out.println("Seat Number: " + seatNumber);
            System.out.printf("Price: %.2f%n", price);
        } else {
            System.out.println("Ticket is not booked.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();

        // Read the movie name.
        System.out.print("Enter movie name: ");
        ticket.movieName = sc.nextLine();

        // Read booking details.
        System.out.print("Enter seat number: ");
        String seat = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double ticketPrice = sc.nextDouble();

        // Book and display the ticket.
        ticket.bookTicket(seat, ticketPrice);
        ticket.displayDetails();

        sc.close();
    }
}
