package extras.date;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Write a program to take a date and add 7 days, 1 month, and 2 years.
 * Then subtract 3 weeks from the result.
 *
 * Hint =>
 * Use plusDays(), plusMonths(), plusYears(), and minusWeeks().
 */
public class DateArithmetic {

    /**
     * Performs date arithmetic on the given date.
     *
     * @param date the starting date
     * @return the final calculated date
     */
    public static LocalDate calculateDate(LocalDate date) {
        // Add 7 days
        date = date.plusDays(7);

        // Add 1 month
        date = date.plusMonths(1);

        // Add 2 years
        date = date.plusYears(2);

        // Subtract 3 weeks
        date = date.minusWeeks(3);

        return date;
    }

    /**
     * Main method to perform date arithmetic.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        // Convert input into LocalDate
        LocalDate date = LocalDate.parse(input);

        // Calculate and display the result
        LocalDate result = calculateDate(date);

        System.out.println("Original date: " + date);
        System.out.println("Final date: " + result);

        sc.close();
    }
}
