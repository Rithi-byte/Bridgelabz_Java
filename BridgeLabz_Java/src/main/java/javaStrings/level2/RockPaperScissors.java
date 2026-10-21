
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to play Rock-Paper-Scissors between a user and
 * a computer. Display game results, win counts, and percentages.
 *
 * Hint =>
 * Generate computer choices using Math.random().
 * Find the winner of each game.
 * Calculate the win percentages and display the statistics.
 */
public class RockPaperScissors {

    /**
     * Generates the computer's choice.
     *
     * @return 0 for Rock, 1 for Paper, or 2 for Scissors
     */
    public static int getComputerChoice() {
        return (int) (Math.random() * 3);
    }

    /**
     * Converts a choice number into its name.
     *
     * @param choice the choice number
     * @return the choice name
     */
    public static String getChoiceName(int choice) {
        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    /**
     * Finds the winner of a game.
     *
     * @param player the player's choice
     * @param computer the computer's choice
     * @return the result of the game
     */
    public static String findWinner(int player, int computer) {
        if (player == computer) {
            return "Draw";
        }

        // Rock beats Scissors, Paper beats Rock,
        // and Scissors beats Paper
        if ((player == 0 && computer == 2)
                || (player == 1 && computer == 0)
                || (player == 2 && computer == 1)) {
            return "Player";
        }

        return "Computer";
    }

    /**
     * Creates the game statistics table.
     *
     * @param playerWins the number of player wins
     * @param computerWins the number of computer wins
     * @param draws the number of draws
     * @param games the total number of games
     * @return a 2D String array containing statistics
     */
    public static String[][] getStatistics(
            int playerWins, int computerWins, int draws, int games) {

        String[][] result = new String[3][3];

        result[0][0] = "Player";
        result[0][1] = String.valueOf(playerWins);
        result[0][2] = String.format("%.2f%%",
                playerWins * 100.0 / games);

        result[1][0] = "Computer";
        result[1][1] = String.valueOf(computerWins);
        result[1][2] = String.format("%.2f%%",
                computerWins * 100.0 / games);

        result[2][0] = "Draws";
        result[2][1] = String.valueOf(draws);
        result[2][2] = String.format("%.2f%%",
                draws * 100.0 / games);

        return result;
    }

    /**
     * Displays game statistics.
     *
     * @param result the statistics array
     */
    public static void displayStatistics(String[][] result) {
        System.out.printf("%-15s %-15s %-15s%n",
                "Result", "Count", "Percentage");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-15s %-15s %-15s%n",
                    result[i][0], result[i][1], result[i][2]);
        }
    }

    /**
     * Main method to play multiple games.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        // Validate the number of games
        if (games <= 0) {
            System.out.println("Number of games must be positive.");
            sc.close();
            return;
        }

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.println("0 = Rock, 1 = Paper, 2 = Scissors");

        // Play each game
        for (int i = 1; i <= games; i++) {
            System.out.print("Enter your choice for game "
                    + i + ": ");
            int player = sc.nextInt();

            if (player < 0 || player > 2) {
                System.out.println("Invalid choice. Try again.");
                i--;
                continue;
            }

            int computer = getComputerChoice();
            String winner = findWinner(player, computer);

            System.out.println("Player: " + getChoiceName(player));
            System.out.println("Computer: " + getChoiceName(computer));
            System.out.println("Winner: " + winner);

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        // Calculate and display statistics
        String[][] result = getStatistics(
                playerWins, computerWins, draws, games);
        displayStatistics(result);

        sc.close();
    }
}
