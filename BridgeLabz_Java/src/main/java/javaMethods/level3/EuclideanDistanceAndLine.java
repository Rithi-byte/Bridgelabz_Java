package javaMethods.level3;
import java.util.Scanner;

//Created EuclideanDistanceAndLine to calculate distance and line equation
public class EuclideanDistanceAndLine {
    /** @param x1 first point x
     * @param y1 first point y
     * @param x2 second point x
     * @param y2 second point y
     * @return Euclidean distance */
    public static double findDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /** @param x1 first point x
     * @param y1 first point y
     * @param x2 second point x
     * @param y2 second point y
     * @return array {slope, intercept}; vertical line returns {NaN, x-coordinate} */
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        if (x2 == x1) return new double[]{Double.NaN, x1};
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;
        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1 y1 x2 y2: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        System.out.println("Distance: " + findDistance(x1, y1, x2, y2));
        double[] line = findLineEquation(x1, y1, x2, y2);
        if (Double.isNaN(line[0])) System.out.println("Line is vertical: x = " + line[1]);
        else System.out.println("Line equation: y = " + line[0] + "x + " + line[1]);
        sc.close();
    }
}
