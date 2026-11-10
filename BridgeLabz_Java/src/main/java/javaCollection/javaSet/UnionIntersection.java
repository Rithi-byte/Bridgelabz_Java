
package javaCollection.javaSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionIntersection {

    // Method to find the union of two sets
    public static Set<Integer> findUnion(
            Set<Integer> firstSet, Set<Integer> secondSet) {

        // Create a new set to store union elements
        Set<Integer> unionSet = new HashSet<>();

        // Add all elements from the first set
        for (int element : firstSet) {
            unionSet.add(element);
        }

        // Add all elements from the second set
        // Duplicate elements are automatically ignored by HashSet
        for (int element : secondSet) {
            unionSet.add(element);
        }

        return unionSet;
    }

    // Method to find the intersection of two sets
    public static Set<Integer> findIntersection(
            Set<Integer> firstSet, Set<Integer> secondSet) {

        // Create a new set to store common elements
        Set<Integer> intersectionSet = new HashSet<>();

        // Traverse the first set
        for (int element : firstSet) {

            // Check whether the element is present in the second set
            if (secondSet.contains(element)) {

                // Add common element to the intersection set
                intersectionSet.add(element);
            }
        }

        return intersectionSet;
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

        // Display the original sets
        System.out.println("First Set: " + firstSet);
        System.out.println("Second Set: " + secondSet);

        // Find and display union
        Set<Integer> unionResult = findUnion(firstSet, secondSet);
        System.out.println("Union: " + unionResult);

        // Find and display intersection
        Set<Integer> intersectionResult =
                findIntersection(firstSet, secondSet);
        System.out.println("Intersection: " + intersectionResult);

        scanner.close();
    }
}
