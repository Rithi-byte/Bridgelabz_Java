package javaMixedProblems.linearBinarySearch;

import java.util.Scanner;

/**
 * Searches for a target in a sorted 2D matrix using Binary Search.
 *
 * Assumption:
 * Each row is sorted, and the first element of each row is greater
 * than the last element of the previous row.
 */
public class SearchSortedMatrix {

    /**
     * Searches the matrix as if it were a one-dimensional array.
     *
     * @param matrix the sorted matrix
     * @param target the value to find
     * @return true if found, otherwise false
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        // Perform Binary Search over virtual one-dimensional indices.
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Convert the virtual index to row and column indices.
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * Main method to search a matrix.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements in sorted order:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Target found: " + searchMatrix(matrix, target));

        sc.close();
    }
}