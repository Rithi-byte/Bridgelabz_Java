package javaConstructors.level1;
import java.util.Scanner;

/**
 * Represents a hotel booking.
 */
class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    /**
     * Initializes a booking with default values.
     */
    HotelBooking() {
        this("Guest", "Standard", 1);
    }

    /**
     * Initializes a booking with supplied details.
     *
     * @param guestName the guest's name
     * @param roomType the room type
     * @param nights the number of nights
     */
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    /**
     * Creates a booking by copying another booking.
     *
     * @param other the booking to copy
     */
    HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    /**
     * Displays the booking details.
     */
    void displayDetails() {
        // Print the booking information.
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a default booking.
        HotelBooking b1 = new HotelBooking();

        // Read the new booking details.
        System.out.print("Enter guest name: ");
        String name = sc.nextLine();

        System.out.print("Enter room type: ");
        String room = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        if (nights <= 0) {
            System.out.println("Nights must be positive.");
            sc.close();
            return;
        }

        // Create a parameterized booking and its copy.
        HotelBooking b2 = new HotelBooking(name, room, nights);
        HotelBooking b3 = new HotelBooking(b2);

        System.out.println("Default Booking:");
        b1.displayDetails();

        System.out.println("New Booking:");
        b2.displayDetails();

        System.out.println("Copied Booking:");
        b3.displayDetails();

        sc.close();
    }
}
