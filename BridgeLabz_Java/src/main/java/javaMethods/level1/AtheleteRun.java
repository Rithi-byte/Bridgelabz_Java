package javaMethods.level1;
import java.util.Scanner;

// Created AtheleteRun to calculate the number of rounds
public class AtheleteRun {
    /**
     * Calculates the number of complete rounds required to run 5 km
     * around a triangular park.
     *
     * @param side1 the first side of the triangle in meters
     * @param side2 the second side of the triangle in meters
     * @param side3 the third side of the triangle in meters
     * @return the number of complete rounds required to cover 5 km
     */
    public static int calculateRounds(int side1,int side2,int side3){
        return 5000/(side1+side2+side3);
    }

    public static void main(String[] args) {
        // Create Scanner object to get user input
        Scanner sc=new Scanner(System.in);

        //Integer type to Get the three sides of the triangular park
        System.out.print("Enter the three sides of the triangle (in metre): ");
        int side1=sc.nextInt();
        int side2=sc.nextInt();
        int side3=sc.nextInt();

        //Display the calculated number of rounds
        System.out.println("Number of rounds: " +calculateRounds(side1, side2, side3));

        //Close the object
        sc.close();
    }
}
