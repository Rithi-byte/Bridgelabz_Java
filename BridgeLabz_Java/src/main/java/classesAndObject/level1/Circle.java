package classesAndObject.level1;

import java.util.Scanner;

/**
 * Calculates and displays the area and circumference of a circle.
 */
class Circle {
    double radius;

    /**
     * Calculates the area of the circle.
     *
     * @return double type the area of the circle
     */
    double calculateArea() {
        // Apply the area formula.
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the circumference of the circle.
     *
     * @return double type the circumference of the circle
     */
    double calculateCircumference() {
        // Apply the circumference formula.
        return 2 * Math.PI * radius;
    }

    /**
     * Displays the radius, area, and circumference.
     */
    void displayDetails() {
        // Display calculated values to two decimal places.
        System.out.printf("Radius: %.2f%n", radius);
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Circumference: %.2f%n",
                calculateCircumference());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c1 = new Circle();

        // Read the radius from the user.
        System.out.print("Enter radius: ");
        c1.radius = sc.nextDouble();

        // Display the circle details.
        c1.displayDetails();
        sc.close();
    }
}
