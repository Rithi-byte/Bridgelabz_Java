package javaStacksQueueHashmap.hashmap;
import java.util.*;

/**
 * Class Name: ZeroSumSubarrays
 * Purpose: Finds and displays all contiguous subarrays whose sum is zero
 * using prefix sums and a HashMap.
 */
public class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {

        // Stores each prefix sum and all indices where it occurred.
        Map<Integer, List<Integer>> map = new HashMap<>();

        int prefixSum = 0;

        // A prefix sum of zero exists before the array begins.
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {

            // Calculate the running prefix sum.
            prefixSum += arr[i];

            // Repeated prefix sums indicate zero-sum subarrays.
            if (map.containsKey(prefixSum)) {

                for (int previousIndex : map.get(prefixSum)) {

                    int start = previousIndex + 1;
                    int end = i;

                    System.out.println(
                            "Subarray from index " + start +
                                    " to " + end
                    );

                    // Display the elements in the subarray.
                    System.out.print("Elements: ");
                    for (int j = start; j <= end; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                }
            }

            // Record the current index for this prefix sum.
            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }
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

        findZeroSumSubarrays(arr);

        sc.close();
    }
}