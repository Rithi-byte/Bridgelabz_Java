
package controlFlow.level2;
import java.util.Scanner;

//Created BMI class to calculate BMI and find weight status

public class BMI {
    /**
     * Takes the ages and heights of three friends and identifies
     * the youngest and tallest friend.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //Take weight and height as input
        double weight = sc.nextDouble();
        double height = sc.nextDouble();

        //Convert height from cm to meters
        height = height / 100.0;

        //Calculate BMI
        double bmi = weight / (height * height);

        //Display BMI
        System.out.printf("BMI: %.2f%n", bmi);

        //Check weight status
        if (bmi <= 18.4) {
            System.out.println("Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Normal");
        } else if (bmi <= 39.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }

        sc.close();
    }
}
