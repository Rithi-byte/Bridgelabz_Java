package javaMethods.level2;
import java.util.Scanner;

//Created Quadratic to calculate roots of a quadratic equation
public class Quadratic {

    /**
     * Calculates the real roots of ax^2 + bx + c = 0.
     * @param a coefficient of x squared
     * @param b coefficient of x
     * @param c constant term
     * @return an array containing the real roots
     */
    public static double[] findRoots(double a, double b, double c) {
        // Handle a zero coefficient separately
        if (a == 0) {
            return new double[0];
        }

        // Calculate the discriminant
        double delta = Math.pow(b, 2) - 4 * a * c;

        // Return an empty array when there are no real roots
        if (delta < 0) {
            return new double[0];
        }

        // Calculate one root when the discriminant is zero
        if (delta == 0) {
            return new double[]{-b / (2 * a)};
        }

        // Calculate both real roots
        double root1 = (-b + Math.sqrt(delta)) / (2 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2 * a);

        return new double[]{root1, root2};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get coefficients from the user
        System.out.print("Enter a, b and c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        // Calculate the roots
        double[] roots = findRoots(a, b, c);

        // Display the results
        if (roots.length == 0) {
            System.out.println("No real roots.");
        } else {
            for (int i = 0; i < roots.length; i++) {
                System.out.println("Root " + (i + 1) + ": " + roots[i]);
            }
        }

        sc.close();
    }
}

