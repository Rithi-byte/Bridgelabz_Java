package javaCollection.hashmaps.basics;


import java.util.*;

public class InvertMap {

    // Method to invert a map
    public static <K, V> Map<V, List<K>> invertMap(
            Map<K, V> original) {

        // Create map to store inverted key-value pairs
        Map<V, List<K>> inverted = new HashMap<>();

        // Traverse original map
        for (Map.Entry<K, V> entry : original.entrySet()) {

            K key = entry.getKey();
            V value = entry.getValue();

            // Add original key to the list of inverted value
            inverted.computeIfAbsent(value, k -> new ArrayList<>())
                    .add(key);
        }

        return inverted;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        // Get number of entries
        System.out.println("Enter number of entries:");
        int n = sc.nextInt();

        // Get key-value pairs from user
        for (int i = 0; i < n; i++) {

            System.out.println("Enter key:");
            String key = sc.next();

            System.out.println("Enter value:");
            int value = sc.nextInt();

            map.put(key, value);
        }

        // Display original map
        System.out.println("Original Map: " + map);

        // Invert the map
        Map<Integer, List<String>> result = invertMap(map);

        // Display inverted map
        System.out.println("Inverted Map: " + result);

        sc.close();
    }
}
