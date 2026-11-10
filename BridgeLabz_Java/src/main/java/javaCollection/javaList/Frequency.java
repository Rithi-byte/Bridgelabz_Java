
package javaCollection.javaList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Created Frequency: Counts the occurrence of each element in a List.
// Purpose: Finds how many times each String appears.
// Special: Uses HashMap to store elements as keys and their frequencies as values.
public class Frequency {

    // Method to calculate the frequency of each String
    public static HashMap<String, Integer> countFrequency(List<String> list) {

        // Create a HashMap to store String and its frequency
        HashMap<String, Integer> mp = new HashMap<>();

        // Traverse each element in the given list
        for (String s : list) {

            // Check whether the element already exists as a key
            if (mp.containsKey(s)) {

                // If present, increment its existing frequency by 1
                mp.compute(s, (k, c) -> c + 1);
            }
            else {

                // If not present, insert it with an initial frequency of 1
                mp.put(s, 1);
            }
        }

        // Return the HashMap containing all elements and their frequencies
        return mp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Create a List to store user input
        List<String> list = new ArrayList<>();

        // Read elements from the user
        for (int i = 0; i < n; i++) {

            System.out.print("Enter element " + (i + 1) + ": ");
            list.add(sc.next());
        }

        // Display the original list
        System.out.println("Original List:");
        System.out.println(list);

        // Display the frequency of each element
        System.out.println("Frequency:");
        System.out.println(countFrequency(list));

        sc.close();
    }
}
