package javaProgrammingElement.level1;
import java.util.Scanner;

// Created Class FeetConverter to convert a distance in feet to yards and miles
class FeetConverter {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Create conversion constants and take user input for distance in feet
        int feetPerYard = 3;
        int yardsPerMile = 1760;
        double distanceInFeet = input.nextDouble();

        // Convert feet to yards and yards to miles
        double distanceInYards = distanceInFeet / feetPerYard;
        double distanceInMiles = distanceInYards / yardsPerMile;

        // Display the result
        System.out.println("The distance in feet is " + distanceInFeet + " while in yards is "
                + distanceInYards + " and in miles is " + distanceInMiles);
        input.close();
    }
}