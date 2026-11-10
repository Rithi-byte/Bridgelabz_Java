
package javaCollection.javaSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {

    public static Set<Integer> symmetricDifference(
            Set<Integer> set1, Set<Integer> set2) {

        // Set to store symmetric difference
        Set<Integer> result = new HashSet<>();

        // Add elements present only in set1
        for (int i : set1) {
            if (!set2.contains(i)) {
                result.add(i);
            }
        }

        // Add elements present only in set2
        for (int i : set2) {
            if (!set1.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Get first set from user
        System.out.println("Enter number of elements in Set 1:");
        int n = sc.nextInt();

        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }

        // Get second set from user
        System.out.println("Enter number of elements in Set 2:");
        int m = sc.nextInt();

        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < m; i++) {
            set2.add(sc.nextInt());
        }

        // Calculate symmetric difference
        Set<Integer> result = symmetricDifference(set1, set2);

        // Display results
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Symmetric Difference: " + result);

        sc.close();
    }
}
