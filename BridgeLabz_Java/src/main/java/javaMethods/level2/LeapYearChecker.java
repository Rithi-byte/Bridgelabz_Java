package javaMethods.level2;
import java.util.Scanner;

//Created LeapYearChecker to check leap years
public class LeapYearChecker {

    /**
     * Checks whether a year is a leap year in the Gregorian calendar.
     * @param year the input year
     * @return true if the year is a leap year, otherwise false
     */
    public static boolean isLeapYear(int year) {
        return year >= 1582
                && (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the year from the user
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Validate and display the result
        if (year < 1582) {
            System.out.println("Year must be 1582 or later.");
        } else if (isLeapYear(year)) {
            System.out.println("Year is a Leap Year.");
        } else {
            System.out.println("Year is not a Leap Year.");
        }

        sc.close();
    }
}