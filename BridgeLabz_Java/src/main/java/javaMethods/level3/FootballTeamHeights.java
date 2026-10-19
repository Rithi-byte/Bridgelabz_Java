package javaMethods.level3;

//Created FootballTeamHeights to calculate player height statistics
public class FootballTeamHeights {

    /**
     * Generates random heights for 11 football players.
     *
     * @return an array containing player heights in centimeters
     */
    public static int[] generateHeights() {
        int[] heights = new int[11];

        // Generate random heights between 150 and 250 cm
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }

        return heights;
    }

    /**
     * Calculates the sum of all player heights.
     *
     * @param heights array of player heights
     * @return sum of all heights
     */
    public static int findSum(int[] heights) {
        int sum = 0;

        // Add all heights
        for (int height : heights) {
            sum += height;
        }

        return sum;
    }

    /**
     * Calculates the mean height of the players.
     *
     * @param heights array of player heights
     * @return mean height in centimeters
     */
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    /**
     * Finds the shortest player height.
     *
     * @param heights array of player heights
     * @return shortest height in centimeters
     */
    public static int findShortest(int[] heights) {
        int shortest = heights[0];

        // Find the minimum height
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }

        return shortest;
    }

    /**
     * Finds the tallest player height.
     *
     * @param heights array of player heights
     * @return tallest height in centimeters
     */
    public static int findTallest(int[] heights) {
        int tallest = heights[0];

        // Find the maximum height
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }

        return tallest;
    }

    public static void main(String[] args) {
        // Generate heights for all 11 players
        int[] heights = generateHeights();

        // Display player heights
        System.out.println("Player heights in cm:");
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i]);
        }

        // Display height statistics
        System.out.println("Total height: " + findSum(heights));
        System.out.println("Mean height: " + findMean(heights));
        System.out.println("Shortest height: " + findShortest(heights));
        System.out.println("Tallest height: " + findTallest(heights));
    }
}
