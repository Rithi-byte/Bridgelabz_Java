package javaSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to sort book prices in ascending order using Merge Sort.
 *
 * Problem Statement:
 * A bookstore maintains a list of book prices in an array.
 * Implement Merge Sort to sort the prices in ascending order.
 *
 * Algorithm:
 * 1. Divide the array into two halves.
 * 2. Recursively sort both halves.
 * 3. Merge the sorted halves into a single sorted array.
 *
 * Time Complexity: O(n log n) in all cases.
 * Space Complexity: O(n) for the temporary arrays.
 */
public class SortBookPrice {

    /**
     * Divides the array recursively and sorts each half.
     *
     * @param arr the array containing book prices
     * @param left the starting index
     * @param right the ending index
     */
    public static void mergeSort(int[] arr, int left, int right) {

        // Base case: a single element is already sorted.
        if (left < right) {

            // Find the middle index.
            int mid = left + (right - left) / 2;

            // Sort the left half.
            mergeSort(arr, left, mid);

            // Sort the right half.
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves.
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two sorted halves into one sorted section.
     *
     * @param arr the array containing book prices
     * @param left the starting index of the section
     * @param mid the ending index of the left half
     * @param right the ending index of the right half
     */
    public static void merge(int[] arr, int left, int mid, int right) {

        // Find the sizes of the two halves.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy elements into the left temporary array.
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        // Copy elements into the right temporary array.
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Initialize pointers for both temporary arrays.
        int i = 0;
        int j = 0;

        // Start filling the original array from left.
        int k = left;

        // Compare elements and copy the smaller one.
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left array.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right array.
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Main method to accept and sort book prices.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of book prices.
        System.out.print("Enter the number of book prices: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Read the book prices.
        System.out.println("Enter the book prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Sort the prices if the array is not empty.
        mergeSort(prices, 0, prices.length - 1);

        // Display the sorted book prices.
        System.out.println("Book prices in ascending order:");
        System.out.println(Arrays.toString(prices));

        sc.close();
    }
}