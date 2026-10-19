
package arrays.level2;

import java.util.Scanner;

/**
 * Finds the youngest and tallest among Amar, Akbar, and Anthony.
 */
public class YoungestTallestFriends {

    /**
     * Reads the ages and heights of three friends and identifies
     * the youngest friend and the tallest friend.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Read and validate the age and height of each friend
        for (int i = 0; i < names.length; i++) {
            System.out.println("Enter details for " + names[i]);

            System.out.print("Enter age: ");
            ages[i] = input.nextInt();

            System.out.print("Enter height in cm: ");
            heights[i] = input.nextDouble();

            // Repeat input if either value is invalid
            if (ages[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid input. Enter details again.");
                i--;
            }
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        // Find the youngest and tallest friends
        for (int i = 1; i < names.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the results
        System.out.println("Youngest friend: " + names[youngestIndex]);
        System.out.println("Age: " + ages[youngestIndex]);

        System.out.println("Tallest friend: " + names[tallestIndex]);
        System.out.println("Height: " + heights[tallestIndex] + " cm");

        input.close();
    }
}
