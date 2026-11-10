package javaCollection.hashmaps.scenarios;

import java.util.*;

public class VotingSystem {

    // HashMap stores candidate and total votes
    static Map<String, Integer> hashMap = new HashMap<>();

    // LinkedHashMap maintains the order in which votes are received
    static Map<String, Integer> linkedHashMap =
            new LinkedHashMap<>();

    // TreeMap displays candidates in sorted alphabetical order
    static Map<String, Integer> treeMap = new TreeMap<>();

    // Method to cast a vote
    public static void castVote(String candidate) {

        // Update vote count in HashMap
        hashMap.put(candidate,
                hashMap.getOrDefault(candidate, 0) + 1);

        // Update vote count in LinkedHashMap
        linkedHashMap.put(candidate,
                linkedHashMap.getOrDefault(candidate, 0) + 1);

        // Update vote count in TreeMap
        treeMap.put(candidate,
                treeMap.getOrDefault(candidate, 0) + 1);

        System.out.println("Vote recorded successfully!");
    }

    // Display votes in alphabetical order
    public static void displayResults() {

        System.out.println("\nVoting Results:");

        for (Map.Entry<String, Integer> entry :
                treeMap.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }
    }

    // Display voting order of candidates
    public static void displayVotingOrder() {

        System.out.println("\nVoting Order:");

        for (Map.Entry<String, Integer> entry :
                linkedHashMap.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }
    }

    // Find candidate with highest votes
    public static void findWinner() {

        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry :
                hashMap.entrySet()) {

            if (entry.getValue() > maxVotes) {

                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        if (winner != null) {
            System.out.println("\nWinner: " + winner);
            System.out.println("Votes: " + maxVotes);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get total number of votes
        System.out.println("Enter number of votes:");
        int n = sc.nextInt();

        // Accept votes from users
        for (int i = 0; i < n; i++) {

            System.out.println("Enter candidate name:");
            String candidate = sc.next();

            castVote(candidate);
        }

        // Display results
        displayResults();

        // Display voting order
        displayVotingOrder();

        // Display winner
        findWinner();

        sc.close();
    }
}

