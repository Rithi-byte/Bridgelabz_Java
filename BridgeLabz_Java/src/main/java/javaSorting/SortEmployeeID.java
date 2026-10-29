package javaSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to sort employee IDs in ascending order using Insertion Sort.
 *
 * Problem Statement:
 * A company stores employee IDs in an unsorted array.
 * Implement Insertion Sort to arrange the employee IDs
 * in ascending order.
 *
 * Algorithm:
 * 1. Consider the first element as the sorted portion.
 * 2. Pick the next element as the key.
 * 3. Compare the key with elements in the sorted portion.
 * 4. Shift elements greater than the key one position to the right.
 * 5. Insert the key into its correct position.
 * 6. Repeat until the entire array is sorted.
 *
 * Time Complexity:
 * Best Case: O(n)
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 *
 * Space Complexity: O(1)
 */
public class SortEmployeeID {

    /**
     * Sorts the employee IDs in ascending order using Insertion Sort.
     *
     * @param arr the array containing unsorted employee IDs
     */
    public static void insertionSort(int[] arr) {

        // Start from the second element.
        for (int i = 1; i < arr.length; i++) {

            // Store the current element to be inserted.
            int key = arr[i];

            // Point to the last element of the sorted portion.
            int j = i - 1;

            // Shift elements greater than key one position to the right.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key into its correct position.
            arr[j + 1] = key;
        }
    }

    /**
     * Main method to accept employee IDs and display the sorted result.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of employee IDs.
        System.out.print("Enter the number of employee IDs: ");
        int n = sc.nextInt();

        int[] employeeIDs = new int[n];

        // Read employee IDs from the user.
        System.out.println("Enter the employee IDs:");

        for (int i = 0; i < n; i++) {
            employeeIDs[i] = sc.nextInt();
        }

        // Sort the employee IDs.
        insertionSort(employeeIDs);

        // Display the sorted employee IDs.
        System.out.println("Employee IDs in ascending order:");
        System.out.println(Arrays.toString(employeeIDs));

        sc.close();
    }
}