
package javaCollection.javaSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetEquality {

    // Method to check whether two sets are equal
    public static boolean setEquals(Set<Integer> firstSet, Set<Integer> secondSet) {

        // If sizes are different, sets cannot be equal
        if (firstSet.size() != secondSet.size()) {
            return false;
        }

        // Traverse the first set
        for (int element : firstSet) {

            // Check whether every element exists in the second set
            if (!secondSet.contains(element)) {
                return false;
            }
        }

        // If all elements are present, both sets are equal
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create two HashSets
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        // Get elements for the first set
        System.out.println("Enter the number of elements in the first set:");
        int firstSetSize = scanner.nextInt();

        System.out.println("Enter elements of the first set:");
        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextInt());
        }

        // Get elements for the second set
        System.out.println("Enter the number of elements in the second set:");
        int secondSetSize = scanner.nextInt();

        System.out.println("Enter elements of the second set:");
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextInt());
        }

        // Display both sets
        System.out.println("First Set: " + firstSet);
        System.out.println("Second Set: " + secondSet);

        // Check and display whether both sets are equal
        System.out.println("Are they Equal? "+ setEquals(firstSet, secondSet));

        scanner.close();
    }
}
