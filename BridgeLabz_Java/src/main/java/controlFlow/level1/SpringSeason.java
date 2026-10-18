package controlFlow.level1;
import java.util.Scanner;

// Create SpringSeason class to check whether the given date falls in spring season
public class SpringSeason {

    /**
     * Checks whether the given month and day fall within the spring season.
     * Spring season is from March 20 to June 20, inclusive.
     *
     * @param month integer representing the month
     * @param day integer representing the day
     * @return true if the date falls in spring season, otherwise false
     */
    public static boolean checkSpringSeason(int month, int day) {
        return (month == 3 && day >= 20 && day <= 31)
                || (month == 4 && day >= 1 && day <= 30)
                || (month == 5 && day >= 1 && day <= 31)
                || (month == 6 && day >= 1 && day <= 20);
    }

    /**
     * Takes month and day as input and displays whether the date
     * falls within the spring season.
     *
     * @param args command-line arguments passed to the main method
     */
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Get month and day from the user
        int month = sc.nextInt();
        int day = sc.nextInt();

        // Check whether the date falls in spring season
        if (checkSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        // Close the Scanner object
        sc.close();
    }
}
