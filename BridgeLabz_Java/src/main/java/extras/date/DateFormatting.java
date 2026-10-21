package extras.date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Write a program to display the current date in three formats:
 * dd/MM/yyyy, yyyy-MM-dd, and EEE, MMM dd, yyyy.
 *
 * Hint =>
 * Use LocalDate and DateTimeFormatter with custom patterns.
 */
public class DateFormatting {

    /**
     * Displays the date in three different formats.
     *
     * @param date the date to format
     */
    public static void displayFormats(LocalDate date) {
        // Define date formats
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter format2 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter format3 =
                DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Display formatted dates
        System.out.println("Format 1: " + date.format(format1));
        System.out.println("Format 2: " + date.format(format2));
        System.out.println("Format 3: " + date.format(format3));
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Get the current date
        LocalDate today = LocalDate.now();

        System.out.println("Current date: " + today);

        // Display date in different formats
        displayFormats(today);
    }
}