package javaMethods.level3;
import java.util.Scanner;

//Created CollinearPoints to check collinearity using slopes and triangle area
public class CollinearPoints {
    /** @param x1 x-coordinate of A @param y1 y-coordinate of A
     * @param x2 x-coordinate of B @param y2 y-coordinate of B
     * @param x3 x-coordinate of C @param y3 y-coordinate of C
     * @return true if the points are collinear using the area formula */
    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2,
                                             double x3, double y3) {
        double expression = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return Math.abs(expression) < 1e-9;
    }

    /** @param x1 x-coordinate of A @param y1 y-coordinate of A
     * @param x2 x-coordinate of B @param y2 y-coordinate of B
     * @param x3 x-coordinate of C @param y3 y-coordinate of C
     * @return true if cross products of slopes agree, including vertical lines */
    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2,
                                              double x3, double y3) {
        return Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) < 1e-9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1 y1 x2 y2 x3 y3: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();
        System.out.println("Collinear by slope method: "
                + areCollinearBySlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear by area method: "
                + areCollinearByArea(x1, y1, x2, y2, x3, y3));
        sc.close();
    }
}
