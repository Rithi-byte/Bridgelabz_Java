
package javaCollection.javaList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Created RemoveDuplicates: Removes duplicate elements from a List.
// Purpose: Removes duplicates while preserving the original order.
// Special: Performs the operation in-place without creating another list.
public class RemoveDuplicates {

    // Removes duplicate elements from the given list
    public static void duplicates(List<Integer> list) {

        // Traverse the list to check each element
        for (int i = 0; i < list.size(); i++) {

            // Compare the current element with all previous elements
            for (int j = 0; j < i; j++) {

                // Check whether the current element already appeared before
                if (list.get(i).equals(list.get(j))) {

                    // Remove the current element (later occurrence),
                    // keeping the first occurrence to preserve original order
                    list.remove(i);

                    // Decrement i because the next element shifts to index i
                    i--;

                    // Stop checking because the duplicate has been removed
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create a list to store user input
        List<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Read elements from the user
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Display the original list
        System.out.println("Original List: " + list);

        // Remove duplicates from the same list
        duplicates(list);

        // Display the list after removing duplicates
        System.out.println("After removing duplicates: " + list);

        sc.close();
    }
}
