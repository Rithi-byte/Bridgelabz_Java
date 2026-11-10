package javaCollection.hashmaps.basics;


import java.util.*;

public class MergeMaps {

    // Method to merge two maps
    public static Map<String, Integer> mergeMaps(
            Map<String, Integer> map1,
            Map<String, Integer> map2) {

        // Copy first map into result map
        Map<String, Integer> result = new HashMap<>(map1);

        // Traverse second map
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {

            String key = entry.getKey();
            Integer value = entry.getValue();

            // Sum values if key exists, otherwise insert new entry
            result.merge(key, value, Integer::sum);
        }

        return result;
    }

    // Method to get map entries from user
    public static Map<String, Integer> getMap(Scanner sc) {

        Map<String, Integer> map = new HashMap<>();

        System.out.println("Enter number of entries:");
        int n = sc.nextInt();

        // Read key-value pairs
        for (int i = 0; i < n; i++) {

            System.out.println("Enter key:");
            String key = sc.next();

            System.out.println("Enter value:");
            int value = sc.nextInt();

            map.put(key, value);
        }

        return map;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get first map from user
        System.out.println("Enter Map 1:");
        Map<String, Integer> map1 = getMap(sc);

        // Get second map from user
        System.out.println("Enter Map 2:");
        Map<String, Integer> map2 = getMap(sc);

        // Display original maps
        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);

        // Merge both maps
        Map<String, Integer> result = mergeMaps(map1, map2);

        // Display merged map
        System.out.println("Merged Map: " + result);

        sc.close();
    }
}

