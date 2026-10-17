package javaProgrammingElement.level2;
import java.util.Scanner;

//Created triangularPark Class to calculate the number of running rounds
public class TriangularPark {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created three double variables to take triangle sides in meters
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();

        //Compute and store the perimeter of the triangular park
        double perimeter = side1 + side2 + side3;

        //Convert 5 kilometers into meters
        double totalDistance = 5000;

        //Compute and store the number of rounds required
        double rounds = totalDistance / perimeter;

        //Display Result
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }
}

