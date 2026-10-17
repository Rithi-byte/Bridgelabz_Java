package javaProgrammingElement.level1;

import java.util.Scanner;

//Created class areaOfTriangle to calculate the area of triangle
public class AreaOfTriangle {
    public static void main(String[] args){
        // Create a Scanner object to read input from the keyboard
        Scanner sc = new Scanner(System.in);

        // Take user input for base and height in cm
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        double cmPerInch = 2.54;

        // Area of a triangle = 1/2 * base * height  (0.5 avoids integer division)
        double areaInSquareCm = 0.5 * base * height;

        // 1 square inch = 2.54 * 2.54 square cm
        double areaInSquareInches = areaInSquareCm / (cmPerInch * cmPerInch);

        // Display the result
        System.out.println("The area of the triangle in square cm is " + areaInSquareCm + " and in square inches is " + areaInSquareInches);
        sc.close();
    }
    }

