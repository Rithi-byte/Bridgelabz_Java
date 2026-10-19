package arrays.level1;

import java.util.Scanner;

/**
 * Calculates the mean height of players in a football team.
 */
public class MeanHeight {

    /**
     * Reads the heights of 11 players and calculates their mean height.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Store the heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0;

        // Read the height of each player and calculate the sum
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
            sum += heights[i];
        }

        // Calculate and display the mean height
        double mean = sum / heights.length;
        System.out.println("Mean height of the team = " + mean);

        input.close();
    }
}
