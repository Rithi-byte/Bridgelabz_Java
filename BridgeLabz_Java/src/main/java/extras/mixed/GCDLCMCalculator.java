package extras.mixed;

import java.util.Scanner;

/**
 * Calculates the GCD and LCM of two integers.
 */
public class GCDLCMCalculator {

    /**
     * Calculates GCD using the Euclidean algorithm.
     *
     * @param a first integer
     * @param b second integer
     * @return greatest common divisor
     */
    public static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    /**
     * Calculates the LCM of two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return least common multiple
     */
    public static long findLCM(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        // Divide before multiplying to reduce overflow risk.
        return (long) Math.abs(a / findGCD(a, b)) * Math.abs((long) b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int a = sc.nextInt();

        System.out.print("Enter the second number: ");
        int b = sc.nextInt();

        System.out.println("GCD: " + findGCD(a, b));
        System.out.println("LCM: " + findLCM(a, b));

        sc.close();
    }
}