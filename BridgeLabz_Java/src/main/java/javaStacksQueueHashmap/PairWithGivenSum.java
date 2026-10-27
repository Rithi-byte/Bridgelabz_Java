package javaStacksQueueHashmap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
/**
 * Class Name: PairWithGivenSum
 * Purpose: Checks whether an array contains two distinct elements
 * whose sum equals the specified target.
 */
public class PairWithGivenSum {

    public static boolean hasPair(int[] arr, int target) {

        // Stores numbers that have already been visited.
        Set<Integer> visited = new HashSet<>();

        for (int num : arr) {

            // Find the number needed to reach the target.
            int complement = target - num;

            // If the complement was visited, the pair exists.
            if (visited.contains(complement)) {
                System.out.println(
                        "Pair found: " + complement + " + " + num
                );
                return true;
            }

            // Store the current number for future comparisons.
            visited.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if (!hasPair(arr, target)) {
            System.out.println("No pair found.");
        }

        sc.close();
    }
}