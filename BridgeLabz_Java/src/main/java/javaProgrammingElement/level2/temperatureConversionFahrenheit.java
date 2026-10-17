package javaProgrammingElement.level2;
import java.util.Scanner;

//Created temperatureConversionFahrenheit Class to convert Fahrenheit to Celsius
public class temperatureConversionFahrenheit {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created a double variable to take temperature in Fahrenheit
        double fahrenheit = sc.nextDouble();

        //Compute and store the temperature in Celsius
        double celsiusResult = (fahrenheit - 32) * 5 / 9;

        //Display Result
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsiusResult + " Celsius");
    }
}
