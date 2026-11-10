
package javaCollection.javaList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Created RotateElements: Rotates elements of a List.
// Purpose: Performs left rotation by k positions.
// Special: Uses a temporary ArrayList to store the first k elements.
public class RotateElements {

    public static <T> void rotate(List<T> list, int k) {

        int n = list.size();

        // Handle empty lists and normalize k
        if (n == 0) {
            return;
        }

        k = k % n;

        // Store the first k elements temporarily
        List<T> temp = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            temp.add(list.get(i));
        }

        // Shift the remaining elements towards the beginning
        for (int i = k; i < n; i++) {
            list.set(i - k, list.get(i));
        }

        // Copy the stored elements to the end
        for (int i = 0; i < k; i++) {
            list.set(n - k + i, temp.get(i));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter rotation count k: ");
        int k = sc.nextInt();

        System.out.println("Original List: " + list);

        rotate(list, k);

        System.out.println("Rotated List: " + list);

        sc.close();
    }
}
