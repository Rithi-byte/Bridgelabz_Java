
package javaSorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. Bubble Sort - Sort Student Marks
 * Problem: Sort student marks in ascending order.
 * Logic: Compare adjacent elements and swap if they are
 * in the wrong order. Repeat until the array is sorted.
 */
public class SortStudentMarks {

    // Method to sort student marks using Bubble Sort
    public static void bubbleSort(ArrayList<Double> arr) {

        // Outer loop controls the number of passes
        for (int i = 0; i < arr.size() - 1; i++) {

            // Assume no swaps will happen in this pass
            boolean swapped = false;

            // Inner loop compares adjacent elements
            // -i avoids checking elements already sorted
            for (int j = 0; j < arr.size() - 1 - i; j++) {

                // If the current element is greater than
                // the next element, they are in the wrong order
                if (arr.get(j) > arr.get(j + 1)) {

                    // Store the current element temporarily
                    double temp = arr.get(j);

                    // Move the next element to the current position
                    arr.set(j, arr.get(j + 1));

                    // Place the stored element in the next position
                    arr.set(j + 1, temp);

                    // Record that a swap occurred in this pass
                    swapped = true;
                }
            }

            // If no swaps occurred, the array is already sorted
            // Stop early to avoid unnecessary passes
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        // Create an ArrayList to store student marks
        ArrayList<Double> studentMarks = new ArrayList<>();

        // Create Scanner to read user input
        Scanner sc = new Scanner(System.in);

        // Read the number of students
        System.out.print("Enter No.of students: ");
        int noOfStudents = sc.nextInt();

        // Read each student's mark and add it to the list
        for (int i = 0; i < noOfStudents; i++) {
            studentMarks.add(sc.nextDouble());
        }

        // Display marks before sorting
        System.out.print("Before sorting: ");
        System.out.println(studentMarks);

        // Call the Bubble Sort method
        bubbleSort(studentMarks);

        // Display marks after sorting
        System.out.print("After sorting: ");
        System.out.println(studentMarks);

        // Close the Scanner
        sc.close();
    }
}
