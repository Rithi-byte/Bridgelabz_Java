package javaProgrammingElement.level2;
import java.util.Scanner;

//Created travelDetails Class to calculate travel distance and time
public class TravelDetails {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Take user input for travel details
        String name = sc.nextLine();
        String fromCity = sc.nextLine();
        String viaCity = sc.nextLine();
        String toCity = sc.nextLine();

        //Take user input for distances in miles and time in hours
        double fromToVia = sc.nextDouble();
        double viaToFinalCity = sc.nextDouble();
        double timeTaken = sc.nextDouble();

        //Compute and store the total distance
        double totalDistance = fromToVia + viaToFinalCity;

        //Display Result
        System.out.println("Traveller name: " + name);
        System.out.println("Travel route: " + fromCity + " to " + viaCity + " to " + toCity);
        System.out.println("The total distance travelled is " + totalDistance + " miles");
        System.out.println("The total time taken is " + timeTaken + " hours");
    }
}

