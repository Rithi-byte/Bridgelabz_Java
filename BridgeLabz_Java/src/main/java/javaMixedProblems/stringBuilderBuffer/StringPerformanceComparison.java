package javaMixedProblems.stringBuilderBuffer;
/**
 * Compares StringBuilder and StringBuffer concatenation performance.
 */
public class StringPerformanceComparison {

    /**
     * Main method to compare execution times.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Number of concatenation operations.
        int iterations = 1_000_000;

        // Measure StringBuilder execution time.
        long startBuilder = System.nanoTime();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < iterations; i++) {
            builder.append("hello");
        }

        long endBuilder = System.nanoTime();

        // Measure StringBuffer execution time.
        long startBuffer = System.nanoTime();

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < iterations; i++) {
            buffer.append("hello");
        }

        long endBuffer = System.nanoTime();

        // Display execution times in milliseconds.
        System.out.println("StringBuilder time: "
                + (endBuilder - startBuilder) / 1_000_000.0 + " ms");

        System.out.println("StringBuffer time: "
                + (endBuffer - startBuffer) / 1_000_000.0 + " ms");

        // Prevent the resulting strings from being entirely unused.
        System.out.println("Builder length: " + builder.length());
        System.out.println("Buffer length: " + buffer.length());
    }
}