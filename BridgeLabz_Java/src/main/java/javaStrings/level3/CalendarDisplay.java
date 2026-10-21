
package javaStrings.level3;

import java.util.Scanner;

/**
 * Write a program to display a calendar for a given month and year.

 * Hint =>
 * Find the month name and number of days.
 * Check leap years for February.
 * Use the Gregorian calendar algorithm to find the first day.
 */
public class CalendarDisplay {

    /**
     * Returns the name of a month.
     *
     * @param month month number from 1 to 12
     * @return month name
     */
    public static String getMonthName(int month) {
        String[] months = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };

        return months[month - 1];
    }

    /**
     * Checks whether a year is a leap year.
     *
     * @param year the year
     * @return true if it is a leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Returns the number of days in a month.
     *
     * @param month month number
     * @param year the year
     * @return number of days
     */
    public static int getDaysInMonth(int month, int year) {
        int[] days = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }

    /**
     * Finds the first weekday of the month using the Gregorian
     * calendar algorithm. Sunday = 0, Monday = 1, ..., Saturday = 6.
     *
     * @param month month number
     * @param year the year
     * @return first weekday index
     */
    public static int getFirstDay(int month, int year) {
        int day = 1;

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;

        return (day + x + (31 * m0) / 12) % 7;
    }

    /**
     * Displays the calendar.
     *
     * @param month month number
     * @param year the year
     */
    public static void displayCalendar(int month, int year) {
        System.out.println("       " + getMonthName(month) + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDay(month, year);
        int days = getDaysInMonth(month, year);

        // Add spaces before the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Display days in calendar format
        for (int day = 1; day <= days; day++) {
            System.out.printf("%4d", day);

            // Move to next line after Saturday
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        // Validate input
        if (month < 1 || month > 12 || year < 1) {
            System.out.println("Invalid month or year.");
        } else {
            displayCalendar(month, year);
        }

        sc.close();
    }
}
