package javaProgrammingElement.level1;
import java.util.Scanner;
// Created KmToMilesConverter Class to convert a user-given distance from kilometers to miles
class KmToMilesConverter {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Take user input for the distance in km
        double km = input.nextDouble();
        double kmPerMile = 1.6;

        // Convert km to miles
        double miles = km / kmPerMile;

        // Display the result
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        input.close();
    }
}