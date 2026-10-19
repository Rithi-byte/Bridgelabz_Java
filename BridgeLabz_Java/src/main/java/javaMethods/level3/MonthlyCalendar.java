package javaMethods.level3;
import java.util.Scanner;

//Created MonthlyCalendar to display a calendar for a given month and year
public class MonthlyCalendar {
    private static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /** @param month month number 1-12
     * @return month name */
    public static String getMonthName(int month) {
        return MONTHS[month - 1];
    }

    /** @param year year
     * @return true if Gregorian leap year */
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    /** @param month month number 1-12
     * @param year calendar year
     * @return number of days in the month */
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return DAYS[month - 1];
    }

    /** @param month month number 1-12
     * @param year year
     * @return first weekday, where Sunday is 0 */
    public static int getFirstDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + (31 * m0) / 12) % 7;
    }

    /** @param month month number
     * @param year year
     * Displays a calendar with aligned weekday columns. */
    public static void displayCalendar(int month, int year) {
        System.out.println("       " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDay = getFirstDay(month, year);
        int days = getDaysInMonth(month, year);
        for (int i = 0; i < firstDay; i++) System.out.print("    ");
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((firstDay + day) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12) and year: ");
        int month = sc.nextInt();
        int year = sc.nextInt();
        if (month < 1 || month > 12 || year < 1) {
            System.out.println("Invalid month or year.");
        } else {
            displayCalendar(month, year);
        }
        sc.close();
    }
}
