package javaProgrammingElement.level1;
import java.util.Scanner;
//Created HeightConverter to convert centimeter to foot and inches
public class HeightConverter {
    public static void main(String[] args){
        // Create a Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Create conversion constants and take user input for height in cm
        double cmPerInch = 2.54;
        int inchesPerFoot = 12;
        System.out.println("Height in cm:");
        double heightInCm = input.nextDouble();

        //Create three variables to store total inches and convert it to foot
        // Convert cm to  inches, then split into feet and remaining inches
        double totalInches = heightInCm / cmPerInch;
        double feet = (totalInches / inchesPerFoot);
        double inches = totalInches % inchesPerFoot;

        // Display the result
        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + feet
                + " and inches is " + inches);
        input.close();
    }
}
