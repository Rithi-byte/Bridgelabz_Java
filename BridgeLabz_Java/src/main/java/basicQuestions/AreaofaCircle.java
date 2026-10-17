package basicQuestions;
import java.util.Scanner;
//Create AreaofaCircle class to calculate the area of a circle.
public class AreaofaCircle {
    public static void main(String[] args){
        //Create object for Scanner to take input
        Scanner sc=new Scanner(System.in);

        //Create float variable to take radius as an input
        float radius=sc.nextFloat();

        //Compute and store the area of circle
        //Area = π * radius^2
        float areaCircle= (float) ((22/7)*(Math.pow(radius,2.0)));

        //Display the result
        System.out.println("Radius:"+radius);
        System.out.println("Area of circle:"+areaCircle);
    }
}
