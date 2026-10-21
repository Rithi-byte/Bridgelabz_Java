package extras.mixed;

import java.util.Scanner;

/**
 * Finds the maximum of three integers using separate methods.
 */
public class MaximumOfThree {

    /**
     * Reads an integer from the user.
     *
     * @param sc Scanner object
     * @return entered integer
     */
    public static int getInput(Scanner sc) {
        System.out.print("Enter an integer: ");
        return sc.nextInt();
    }

    /**
     * Finds the maximum of three numbers.
     *
     * @param a first number
     * @param b second number
     * @param c third number
     * @return maximum number
     */
    public static int findMaximum(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = getInput(sc);
        int b = getInput(sc);
        int c = getInput(sc);

        System.out.println("Maximum number: " + findMaximum(a, b, c));

        sc.close();
    }
}