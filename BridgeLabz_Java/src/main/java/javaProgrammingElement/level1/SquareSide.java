package javaProgrammingElement.level1;
import java.util.Scanner;

// Created SquareSide Class to find the side of a square from its perimeter
class SquareSide {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Take user input for the perimeter
        double perimeter = input.nextDouble();
        int numberOfSides = 4;

        // Perimeter = 4 * side, so side = perimeter / 4
        double side = perimeter / numberOfSides;

        // Display the result
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        input.close();
    }
}