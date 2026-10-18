package controlFlow.level3;

/**
 * Created DayOfWeek to calculate the day of the week
 * for a given Gregorian calendar date.
 */
public class DayOfWeek {

    /**
     * Accepts month, day, and year as command-line
     * arguments and prints the day of the week.
     *
     * @param args command-line arguments containing
     *             month, day, and year
     */
    public static void main(String[] args) {

        // Read month, day, and year
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        // Calculate the adjusted year
        int y0 = y - (14 - m) / 12;

        // Calculate the year contribution
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        // Calculate the adjusted month
        int m0 = m + 12 * ((14 - m) / 12) - 2;

        // Calculate the day of the week
        int d0 = (d + x + 31 * m0 / 12) % 7;

        // Display the result: 0 = Sunday, 6 = Saturday
        System.out.println(d0);
    }
}
