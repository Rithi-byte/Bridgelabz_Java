package basicQuestions;
import java.util.Scanner;

//Created kilometersToMiles Class to convert kilometers into miles
public class kilometersToMiles {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created a double variable to take distance in kilometers as input
        double kilometers = sc.nextDouble();

        //Compute and store the distance in miles
        double miles = kilometers * 0.621371;

        //Display Result
        System.out.println(kilometers + " kilometers is equal to " + miles + " miles");
    }
}
