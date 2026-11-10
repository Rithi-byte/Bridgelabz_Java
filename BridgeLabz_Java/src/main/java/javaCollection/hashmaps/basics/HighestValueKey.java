
package javaCollection.hashmaps.basics;

import java.util.HashMap;
import java.util.Scanner;

public class HighestValueKey {

    // Method to find the key associated with the highest value
    public static char maxKey(HashMap<Character, Integer> map) {

        // Handle empty HashMap
        if (map.isEmpty()) {
            throw new IllegalArgumentException("HashMap is empty");
        }

        // Initialize maximum value
        int maxValue = Integer.MIN_VALUE;

        // Variable to store the key with maximum value
        char maximumKey = '\0';

        // Traverse all keys in the HashMap
        for (char key : map.keySet()) {

            // Get the value associated with the current key
            int currentValue = map.get(key);

            // Check whether the current value is greater
            // than the maximum value
            if (currentValue > maxValue) {

                // Update maximum value
                maxValue = currentValue;

                // Update corresponding key
                maximumKey = key;
            }
        }

        // Return the key with the highest value
        return maximumKey;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create a HashMap to store character-value pairs
        HashMap<Character, Integer> map = new HashMap<>();

        // Get the number of key-value pairs
        System.out.println("Enter number of entries:");
        int numberOfEntries = scanner.nextInt();

        // Read key-value pairs from the user
        for (int i = 0; i < numberOfEntries; i++) {

            System.out.println("Enter character:");
            char key = scanner.next().charAt(0);

            System.out.println("Enter integer value:");
            int value = scanner.nextInt();

            map.put(key, value);
        }

        // Display the HashMap
        System.out.println("HashMap: " + map);

        // Find and display the key with the highest value
        if (!map.isEmpty()) {
            char result = maxKey(map);
            System.out.println("Key with highest value: " + result);
            System.out.println("Highest value: " + map.get(result));
        } else {
            System.out.println("HashMap is empty.");
        }

        scanner.close();
    }
}
