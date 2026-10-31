package javaStacksQueueHashmap.hashmap;
import java.util.Scanner;
/**
 * Class Name: CustomHashMap
 * Purpose: Implements a basic integer-to-integer hash map with insertion,
 * retrieval, and deletion using separate chaining for collisions.
 */
public class CustomHashMap {

    /**
     * Class Name: Entry
     * Purpose: Represents one key-value pair in a bucket's linked list.
     */
    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final Entry[] buckets;
    private final int capacity;

    public CustomHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be positive"
            );
        }

        this.capacity = capacity;
        this.buckets = new Entry[capacity];
    }

    // Converts a key into a valid bucket index.
    private int hash(int key) {
        return Math.floorMod(key, capacity);
    }

    // Inserts a key-value pair or updates an existing key.
    public void put(int key, int value) {

        int index = hash(key);
        Entry current = buckets[index];

        // Update the value if the key already exists.
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert the new entry at the beginning of the bucket.
        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
    }

    // Returns the value associated with a key, or -1 if absent.
    public int get(int key) {

        int index = hash(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    // Removes the entry associated with the given key.
    public void remove(int key) {

        int index = hash(key);
        Entry current = buckets[index];
        Entry previous = null;

        while (current != null) {

            if (current.key == key) {

                // If first in the chain, update the bucket head.
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    // Otherwise, skip the removed entry.
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hash map capacity: ");
        int capacity = sc.nextInt();

        CustomHashMap map = new CustomHashMap(capacity);

        System.out.print("Enter number of key-value pairs: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key and value: ");
            int key = sc.nextInt();
            int value = sc.nextInt();

            map.put(key, value);
        }

        System.out.print("Enter key to search: ");
        int searchKey = sc.nextInt();
        System.out.println("Value: " + map.get(searchKey));

        System.out.print("Enter key to remove: ");
        int removeKey = sc.nextInt();
        map.remove(removeKey);

        System.out.println(
                "Value after removal: " + map.get(removeKey)
        );

        sc.close();
    }
}