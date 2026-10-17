package basicQuestions;
import java.util.Scanner;
//Created VolumeOfaCylinder class to calculate the volume of a cylinder
public class VolumeOfaCylinder {
    public static void main(String[] args){
            //Create object for Scanner to take input
            Scanner sc = new Scanner(System.in);

            //Created two double variables to take radius and height as input
            double radius = sc.nextDouble();
            double height = sc.nextDouble();

            //Compute and store the volume of the cylinder
            double volume = Math.PI * radius * radius * height;

            //Display Result
            System.out.println("The volume of the cylinder with radius " + radius + " and height " + height + " is " + volume);
        }
}

