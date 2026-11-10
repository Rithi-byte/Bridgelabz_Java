package javaCollection.javaList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Created ReverseList: Reverses ArrayList and LinkedList.
// Purpose: Accepts user input and reverses list elements.
// Special: Uses a generic method and two-pointer swapping.
public class ReverseList {

    // Generic method to reverse any List
    static <T> void reverseList(List<T> list) {

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            T temp = list.get(left);

            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            arrayList.add(value);
            linkedList.add(value);
        }

        System.out.println("\nOriginal ArrayList: " + arrayList);

        reverseList(arrayList);

        System.out.println("Reversed ArrayList: " + arrayList);

        System.out.println("\nOriginal LinkedList: " + linkedList);

        reverseList(linkedList);

        System.out.println("Reversed LinkedList: " + linkedList);

        sc.close();
    }
}
