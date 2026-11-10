
package javaCollection.javaSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubsetCheck {

    // Method to check whether one set is a subset of another
    public static boolean checkSubset(
            Set<Integer> firstSet, Set<Integer> secondSet) {

        // If firstSet is larger, check whether secondSet
        // is a subset of firstSet
        if (firstSet.size() > secondSet.size()) {

            // Traverse the smaller set
            for (int element : secondSet) {

                // Check if the element exists in the larger set
                if (!firstSet.contains(element)) {
                    return false;
                }
            }

        } else {

            // Traverse firstSet because it is smaller
            // or both sets have equal sizes
            for (int element : firstSet) {

                // Check if the element exists in secondSet
                if (!secondSet.contains(element)) {
                    return false;
                }
            }
        }

        // All elements of the smaller set are present
        // in the larger set
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create two HashSets
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        // Get elements for the first set
        System.out.println("Enter number of elements in first set:");
        int firstSetSize = scanner.nextInt();

        System.out.println("Enter elements of first set:");
        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextInt());
        }

        // Get elements for the second set
        System.out.println("Enter number of elements in second set:");
        int secondSetSize = scanner.nextInt();

        System.out.println("Enter elements of second set:");
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextInt());
        }

        // Display both sets
        System.out.println("First Set: " + firstSet);
        System.out.println("Second Set: " + secondSet);

        // Check subset relationship
        System.out.println("Is First Set a subset of Second Set? "
                + checkSubset(secondSet, firstSet));

        System.out.println("Is Second Set a subset of First Set? "
                + checkSubset(firstSet, secondSet));

        scanner.close();
    }
}
