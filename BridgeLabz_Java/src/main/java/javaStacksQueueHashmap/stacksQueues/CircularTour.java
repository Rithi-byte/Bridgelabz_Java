package javaStacksQueueHashmap.stacksQueues;

public class CircularTour {

    public static int tour(int[] petrol, int[] distance) {

        int n = petrol.length;

        int start = 0;
        int balance = 0;
        int totalSurplus = 0;

        for (int i = 0; i < n; i++) {

            int surplus = petrol[i] - distance[i];

            balance += surplus;
            totalSurplus += surplus;

            if (balance < 0) {
                start = i + 1;
                balance = 0;
            }
        }

        if (totalSurplus < 0)
            return -1;

        return start;
    }
}