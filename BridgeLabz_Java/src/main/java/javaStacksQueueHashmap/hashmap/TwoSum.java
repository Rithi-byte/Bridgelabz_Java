package javaStacksQueueHashmap.hashmap;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Class Name: TwoSum
 * Purpose: Finds and returns the indices of two distinct array elements
 * whose sum equals the target, using a HashMap.
 */
public class TwoSum {

    public static int[] findTwoSum(int[] arr, int target) {

        // Maps each previously visited number to its index.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // Find the complement needed to reach the target.
            int complement = target - arr[i];

            // Check whether the complement has already been seen.
            if (map.containsKey(complement)) {

                // Return the complement's index and current index.
                return new int[] {map.get(complement), i};
            }

            // Store the current number and its index.
            map.put(arr[i], i);
        }

        // Return an empty array if no valid pair exists.
        return new int[0];
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

        int[] result = findTwoSum(arr, target);

        if (result.length == 2) {
            System.out.println(
                    "Indices: " + Arrays.toString(result)
            );
            System.out.println(
                    "Values: " + arr[result[0]] +
                            ", " + arr[result[1]]
            );
        } else {
            System.out.println("No valid pair found.");
        }

        sc.close();
    }
}