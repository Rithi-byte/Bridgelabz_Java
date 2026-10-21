package extras.date;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Write a program to display the current time in different time zones:
 * GMT, IST, and PST.
 *
 * Hint =>
 * Use ZonedDateTime and ZoneId to work with time zones.
 */
public class TimeZones {

    /**
     * Displays the current time for the given time zone.
     *
     * @param zone the time zone ID
     * @param name the time zone name
     */
    public static void displayTime(String zone, String name) {
        // Get current time in the specified time zone
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of(zone));

        // Format the date and time
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        System.out.println(name + ": " + time.format(formatter));
    }

    /**
     * Main method to display times in different time zones.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Display current time in each time zone
        displayTime("GMT", "GMT");
        displayTime("Asia/Kolkata", "IST");
        displayTime("America/Los_Angeles", "PST/Pacific Time");
    }
}