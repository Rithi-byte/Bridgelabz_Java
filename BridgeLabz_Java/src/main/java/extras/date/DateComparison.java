package extras.date;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Write a program to compare two dates and determine whether
 * the first date is before, after, or equal to the second date.
 * Hint =>
 * Use isBefore(), isAfter(), and isEqual() methods of LocalDate.
 */
public class DateComparison {

    /**
     * Compares two dates.
     *
     * @param date1 the first date
     * @param date2 the second date
     */
    public static void compareDates(LocalDate date1, LocalDate date2) {
        // Compare the two dates
        if (date1.isBefore(date2)) {
            System.out.println("The first date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("The first date is after the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are equal.");
        }
    }

    /**
     * Main method to take input and compare dates.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take two date inputs
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        // Compare the dates
        compareDates(date1, date2);

        sc.close();
    }
}