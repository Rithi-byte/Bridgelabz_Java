package javaSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to sort product prices in ascending order using Quick Sort.
 *
 * Problem Statement:
 * An e-commerce company wants to display product prices in ascending order.
 * Implement Quick Sort to sort the product prices.
 *
 * Algorithm:
 * 1. Select the last element as the pivot.
 * 2. Partition the array around the pivot.
 * 3. Place the pivot in its correct sorted position.
 * 4. Recursively sort the left and right partitions.
 *
 * Time Complexity:
 * Best Case: O(n log n)
 * Average Case: O(n log n)
 * Worst Case: O(n^2)
 *
 * Auxiliary Space Complexity:
 * Average Case: O(log n) recursion stack.
 */
public class SortProductPrice {

    /**
     * Sorts the array using Quick Sort.
     *
     * @param arr the array containing product prices
     * @param low the starting index
     * @param high the ending index
     */
    public static void quickSort(int[] arr, int low, int high) {

        // Continue sorting when the partition has at least two elements.
        if (low < high) {

            // Partition the array and get the pivot's final position.
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the elements before the pivot.
            quickSort(arr, low, pivotIndex - 1);

            // Recursively sort the elements after the pivot.
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array using the last element as the pivot.
     *
     * @param arr the array to partition
     * @param low the starting index
     * @param high the ending index
     * @return the final index of the pivot
     */
    public static int partition(int[] arr, int low, int high) {

        // Choose the last element as the pivot.
        int pivot = arr[high];

        // Tracks the boundary of elements smaller than or equal to pivot.
        int i = low - 1;

        // Examine each element before the pivot.
        for (int j = low; j < high; j++) {

            // Move elements smaller than or equal to the pivot to the left.
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j].
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot in its correct position.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the pivot's final index.
        return i + 1;
    }

    /**
     * Main method to accept and sort product prices.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of product prices.
        System.out.print("Enter the number of product prices: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Read product prices from the user.
        System.out.println("Enter the product prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Sort the prices if the array is not empty.
        quickSort(prices, 0, prices.length - 1);

        // Display the sorted prices.
        System.out.println("Product prices in ascending order:");
        System.out.println(Arrays.toString(prices));

        sc.close();
    }
}