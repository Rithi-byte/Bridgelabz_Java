package javaMixedProblems.linearBinarySearch;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Finds the first missing positive integer using Linear Search
 * and searches for a target using Binary Search.
 */
public class SearchChallenge {

    /**
     * Finds the smallest missing positive integer.
     *
     * @param arr the input array
     * @return the first missing positive integer
     */
    public static int firstMissingPositive(int[] arr) {

        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        // Record positive values that can affect the answer.
        for (int value : arr) {
            if (value > 0 && value <= n) {
                present[value] = true;
            }
        }

        // Find the first positive value not present.
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    /**
     * Searches for a target in a sorted array.
     *
     * @param arr the sorted array
     * @param target the value to find
     * @return index of the target, or -1 if absent
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Main method to execute both search operations.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find the first missing positive integer.
        System.out.println("First missing positive: "
                + firstMissingPositive(arr));

        // Sort a copy before applying Binary Search.
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        System.out.print("Enter target to search: ");
        int target = sc.nextInt();

        System.out.println("Sorted array: " + Arrays.toString(sorted));
        System.out.println("Target index: " + binarySearch(sorted, target));

        sc.close();
    }
}