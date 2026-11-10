package javaCollection.hashmaps.basics;

import java.util.*;

public class WordFrequency {

    // Method to calculate the frequency of each word
    public static Map<String, Integer> frequency(String text) {

        // HashMap to store words and their frequencies
        Map<String, Integer> mp = new HashMap<>();

        // Temporary string to construct each word
        String result = "";

        // Traverse the input string character by character
        for (int i = 0; i < text.length(); i++) {

            // Check whether the current character is a delimiter
            if (text.charAt(i) == ',' || text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == ' ') {

                // Process the word only if it is not empty
                if (result.length() > 0) {

                    // Convert the word to lowercase
                    String temp = result.toLowerCase(Locale.ROOT);

                    // Insert the word or increment its frequency
                    mp.merge(temp, 1, (oldValue, newValue) -> oldValue + 1);

                    // Reset result to construct the next word
                    result = "";
                }

            } else {

                // Append the current character to the word
                result += text.charAt(i);
            }
        }

        // Process the last word after the loop ends
        if (result.length() > 0) {

            String temp = result.toLowerCase(Locale.ROOT);

            mp.merge(temp, 1, (oldValue, newValue) -> oldValue + 1);
        }

        // Return the word-frequency map
        return mp;
    }

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Get the complete sentence from the user
        System.out.println("Enter a sentence:");
        String s = sc.nextLine();

        // Call the frequency method and print the result
        System.out.println("Word Frequencies: " + frequency(s));

        // Close Scanner
        sc.close();
    }
}