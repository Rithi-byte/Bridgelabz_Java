
package javaSorting;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 5. Selection Sort - Sort Exam Scores
 * Problem: Sort students' exam scores in ascending order.
 * Logic: Find the minimum element and swap it with the
 * first element of the unsorted portion.
 */
public class SortExamScores {

    // Method to sort student scores using Selection Sort
    public static void selectionsort(ArrayList<Double> arr) {

        // Outer loop selects the position where the minimum
        // element of the unsorted portion should be placed
        for (int i = 0; i < arr.size(); i++) {

            // Assume the current element is the minimum
            // Store its index in min
            int min = i;

            // Search for a smaller element in the remaining
            // unsorted portion of the list
            for (int j = i + 1; j < arr.size(); j++) {

                // Compare the current minimum with the
                // element at index j
                if (arr.get(min) > arr.get(j)) {

                    // Update min to the index of the
                    // newly found smaller element
                    min = j;
                }
            }

            // Store the element at index i temporarily
            double temp = arr.get(i);

            // Place the minimum element at index i
            arr.set(i, arr.get(min));

            // Move the original element at index i
            // to the minimum element's previous position
            arr.set(min, temp);
        }
    }

    public static void main(String[] args) {

        // Create an ArrayList to store student scores
        ArrayList<Double> studentScore = new ArrayList<>();

        // Create Scanner to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask for the number of students
        System.out.print("Enter No.of students: ");

        // Read the number of students
        int noOfStudents = sc.nextInt();

        // Read each student's score and add it to the list
        for (int i = 0; i < noOfStudents; i++) {
            studentScore.add(sc.nextDouble());
        }

        // Display scores before sorting
        System.out.print("Before sorting: ");
        System.out.println(studentScore);

        // Call Selection Sort to sort the same ArrayList
        System.out.print("After sorting: ");
        selectionsort(studentScore);

        // Display scores in ascending order
        System.out.println(studentScore);

        // Close the Scanner
        sc.close();
    }
}
