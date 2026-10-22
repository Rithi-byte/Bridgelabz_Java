package javaConstructors.level1;
import java.util.Scanner;

/**
 * Represents a circle with a radius.
 */
class Circle {
    double radius;

    /**
     * Initializes the radius using constructor chaining.
     */
    Circle() {
        this(1.0);
    }

    /**
     * Initializes the circle with a specified radius.
     *
     * @param radius the radius of the circle
     */
    Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Displays the radius and area.
     */
    void displayDetails() {
        // Calculate and display the circle's area.
        System.out.println("Radius: " + radius);
        System.out.printf("Area: %.2f%n", Math.PI * radius * radius);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a circle using the default constructor.
        Circle c1 = new Circle();
        c1.displayDetails();

        // Read the radius from the user.
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        if (radius <= 0) {
            System.out.println("Radius must be positive.");
        } else {
            // Invoke the parameterized constructor.
            Circle c2 = new Circle(radius);
            c2.displayDetails();
        }

        sc.close();
    }
}
