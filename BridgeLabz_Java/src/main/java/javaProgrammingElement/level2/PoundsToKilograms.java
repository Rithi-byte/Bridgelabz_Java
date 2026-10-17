package javaProgrammingElement.level2;
import java.util.Scanner;

//Created poundsToKilograms Class to convert pounds into kilograms
public class PoundsToKilograms {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created a double variable to take weight in pounds as input
        double weight = sc.nextDouble();

        //Compute and store the weight in kilograms
        double weightInKilograms = weight / 2.2;

        //Display Result
        System.out.println("The weight of the person in pound is " + weight + " and in kg is " + weightInKilograms);
    }
}
