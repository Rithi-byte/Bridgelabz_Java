package javaCollection.javaSet;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class SetToSortedList {

    // Method to convert Set into a sorted List
    public static List<Integer> convertToSortedList(Set<Integer> inputSet) {

        // Convert HashSet into ArrayList
        List<Integer> sortedList = new ArrayList<>(inputSet);

        // Bubble Sort to arrange elements in ascending order
        for (int i = 0; i < sortedList.size() - 1; i++) {

            // Compare adjacent elements
            for (int j = 0; j < sortedList.size() - 1 - i; j++) {

                // Swap if the current element is greater
                // than the next element
                if (sortedList.get(j) > sortedList.get(j + 1)) {

                    int temp = sortedList.get(j);

                    sortedList.set(j, sortedList.get(j + 1));

                    sortedList.set(j + 1, temp);
                }
            }
        }

        // Return the sorted list
        return sortedList;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create a HashSet to store unique integers
        Set<Integer> inputSet = new HashSet<>();

        // Get number of elements
        System.out.println("Enter the number of elements:");
        int numberOfElements = scanner.nextInt();

        // Read elements from the user
        System.out.println("Enter the elements:");
        for (int i = 0; i < numberOfElements; i++) {
            inputSet.add(scanner.nextInt());
        }

        // Display original set
        System.out.println("Original Set: " + inputSet);

        // Convert set into sorted list
        List<Integer> result = convertToSortedList(inputSet);

        // Display sorted list
        System.out.println("Sorted List: " + result);

        scanner.close();
    }
}
