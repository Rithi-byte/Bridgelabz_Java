
package javaStrings.level3;

import java.util.Scanner;

/**
 * Write a program to initialize a deck of cards, shuffle it,
 * and distribute cards to a given number of players.
 * Hint =>
 * Use four suits and thirteen ranks.
 * Shuffle using Math.random() and distribute cards evenly.
 */
public class DeckOfCards {

    /**
     * Initializes a standard deck of 52 cards.
     *
     * @return array containing all cards
     */
    public static String[] initializeDeck() {
        String[] suits = {
                "Hearts", "Diamonds", "Clubs", "Spades"
        };

        String[] ranks = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        // Create every rank and suit combination
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }

        return deck;
    }

    /**
     * Shuffles the deck using random swapping.
     *
     * @param deck the original deck
     * @return the shuffled deck
     */
    public static String[] shuffleDeck(String[] deck) {

        // Swap each card with a random card from the remaining deck
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i
                    + (int) (Math.random() * (deck.length - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    /**
     * Distributes cards evenly among players.
     *
     * @param deck shuffled deck
     * @param players number of players
     * @param cardsPerPlayer number of cards per player
     * @return 2D array containing each player's cards
     */
    public static String[][] distributeCards(
            String[] deck, int players, int cardsPerPlayer) {

        // Validate that enough cards are available
        if (players <= 0 || cardsPerPlayer <= 0
                || (long) players * cardsPerPlayer > deck.length) {
            return new String[0][0];
        }

        String[][] hands = new String[players][cardsPerPlayer];
        int index = 0;

        // Distribute the requested number of cards
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                hands[i][j] = deck[index++];
            }
        }

        return hands;
    }

    /**
     * Displays the cards belonging to each player.
     *
     * @param hands 2D array of player hands
     */
    public static void displayPlayers(String[][] hands) {
        for (int i = 0; i < hands.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < hands[i].length; j++) {
                System.out.println(hands[i][j]);
            }
        }
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        // Create and shuffle the deck
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        // Validate distribution
        if (players <= 0 || cardsPerPlayer <= 0
                || (long) players * cardsPerPlayer > deck.length) {
            System.out.println("Invalid distribution. "
                    + "A standard deck contains 52 cards.");
        } else {
            // Distribute and display cards
            String[][] hands = distributeCards(
                    deck, players, cardsPerPlayer);
            displayPlayers(hands);
        }

        sc.close();
    }
}
