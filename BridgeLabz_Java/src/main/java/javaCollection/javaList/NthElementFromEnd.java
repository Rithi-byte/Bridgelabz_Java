package javaCollection.javaList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// Created NthElementFromEnd: Finds the Nth element from the end.
// Purpose: Demonstrates the two-pointer technique using LinkedList.
// Special: Does not calculate the size of the list.
public class NthElementFromEnd {

    static <T> T findNthFromEnd(LinkedList<T> list, int n) {

        if (n <= 0) {
            return null;
        }

        ListIterator<T> fast = list.listIterator();
        ListIterator<T> slow = list.listIterator();

        // Move fast pointer N positions ahead
        for (int i = 0; i < n; i++) {

            if (!fast.hasNext()) {
                return null;
            }

            fast.next();
        }

        // Move both pointers together
        while (fast.hasNext()) {

            fast.next();
            slow.next();
        }

        // Slow pointer is now at the Nth element from the end
        return slow.next();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<String> list = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int count = sc.nextInt();

        System.out.println("Enter list elements:");

        for (int i = 0; i < count; i++) {
            list.add(sc.next());
        }

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        String result = findNthFromEnd(list, n);

        if (result == null) {
            System.out.println("Invalid N!");
        } else {
            System.out.println("Nth element from the end: " + result);
        }

        sc.close();
    }
}

