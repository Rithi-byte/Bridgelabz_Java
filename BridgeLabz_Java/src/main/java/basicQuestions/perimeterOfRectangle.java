package basicQuestions;
import java.util.Scanner;

//Created perimeterOfRectangle Class to calculate the perimeter of a rectangle
public class perimeterOfRectangle {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created two double variables to take length and width as input
        double length = sc.nextDouble();
        double width = sc.nextDouble();

        //Compute and store the perimeter of the rectangle
        double perimeter = 2 * (length + width);

        //Display Result
        System.out.println("The perimeter of the rectangle with length " + length + " and width " + width + " is " + perimeter);
    }
}
