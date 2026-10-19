package arrays.level1;

import java.util.Scanner;

/**
 * Creates a two-dimensional array and copies its elements into a one-dimensional array.
 */
public class TwoDArrayToOneDArray {

    /**
     * Reads a matrix, flattens it into a one-dimensional array, and displays it.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        // Validate the dimensions
        if (rows <= 0 || columns <= 0) {
            System.out.println("Error: Rows and columns must be positive.");
            input.close();
            return;
        }

        // Create the two-dimensional matrix
        int[][] matrix = new int[rows][columns];

        // Read matrix elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }

        // Create a one-dimensional array for all matrix elements
        int[] array = new int[rows * columns];
        int index = 0;

        // Copy each matrix element into the one-dimensional array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display the one-dimensional array
        System.out.print("One-dimensional array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        input.close();
    }
}

