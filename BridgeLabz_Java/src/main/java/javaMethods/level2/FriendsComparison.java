package javaMethods.level2;
import java.util.Scanner;

//Created FriendsComparison to find the youngest and tallest friend
public class FriendsComparison {

    /**
     * Finds the index of the youngest friend.
     * @param ages array containing the ages of friends
     * @return index of the youngest friend
     */
    public static int findYoungest(int[] ages) {
        int youngest = 0;

        // Compare the ages of all friends
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngest]) {
                youngest = i;
            }
        }
        return youngest;
    }

    /**
     * Finds the index of the tallest friend.
     * @param heights array containing heights in centimeters
     * @return index of the tallest friend
     */
    public static int findTallest(double[] heights) {
        int tallest = 0;

        // Compare the heights of all friends
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallest]) {
                tallest = i;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store the friends' names
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Get age and height of each friend
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + " in cm: ");
            heights[i] = sc.nextDouble();
        }

        // Find and display the youngest and tallest friends
        System.out.println("Youngest friend: " + names[findYoungest(ages)]);
        System.out.println("Tallest friend: " + names[findTallest(heights)]);

        sc.close();
    }
}