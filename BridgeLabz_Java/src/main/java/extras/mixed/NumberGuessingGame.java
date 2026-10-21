package extras.mixed;

import java.util.Scanner;

/**
 * Computer guesses a number between 1 and 100.
 * The user provides feedback: High, Low, or Correct.
 */
public class NumberGuessingGame {

    /**
     * Generates a random guess within the given range.
     *
     * @param low minimum possible number
     * @param high maximum possible number
     * @return randomly generated guess
     */
    public static int generateGuess(int low, int high) {
        return low + (int) (Math.random() * (high - low + 1));
    }

    /**
     * Receives feedback from the user.
     *
     * @param sc Scanner object
     * @return feedback entered by the user
     */
    public static char getFeedback(Scanner sc) {
        System.out.print("Enter H (guess too high), L (guess too low), or C (correct): ");
        return Character.toUpperCase(sc.next().charAt(0));
    }

    /**
     * Determines the next valid range based on feedback.
     *
     * @param guess current guess
     * @param feedback user feedback
     * @param range current minimum and maximum
     */
    public static void determineNextGuess(int guess, char feedback, int[] range) {
        if (feedback == 'L') {
            range[0] = guess + 1; // Number is higher than the guess
        } else if (feedback == 'H') {
            range[1] = guess - 1; // Number is lower than the guess
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = {1, 100};
        boolean correct = false;

        System.out.println("Think of a number between 1 and 100.");

        while (range[0] <= range[1]) {
            int guess = generateGuess(range[0], range[1]);
            System.out.println("My guess is: " + guess);

            char feedback = getFeedback(sc);

            if (feedback == 'C') {
                correct = true;
                System.out.println("I guessed your number!");
                break;
            } else if (feedback == 'H' || feedback == 'L') {
                determineNextGuess(guess, feedback, range);
            } else {
                System.out.println("Invalid feedback. Try again.");
            }
        }

        if (!correct) {
            System.out.println("Your feedback was inconsistent. Check your answers.");
        }

        sc.close();
    }
}