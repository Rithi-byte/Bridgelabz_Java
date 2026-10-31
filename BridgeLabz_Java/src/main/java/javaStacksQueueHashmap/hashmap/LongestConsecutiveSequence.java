package javaStacksQueueHashmap.hashmap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
/**
 * Class Name: LongestConsecutiveSequence
 * Purpose: Finds the length of the longest sequence of consecutive
 * integers in an unsorted array using a HashSet.
 */
public class LongestConsecutiveSequence {

    public static int findLongestSequence(int[] arr) {

        // HashSet provides average O(1) membership checks.
        Set<Integer> set = new HashSet<>();

        // Insert all elements into the set.
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Start only at the beginning of a sequence.
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Count consecutive numbers.
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Update the longest sequence found so far.
                longest = Math.max(longest, length);
            }
        }

        return longest;
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

        System.out.println(
                "Longest consecutive sequence length: " +
                        findLongestSequence(arr)
        );

        sc.close();
    }
}