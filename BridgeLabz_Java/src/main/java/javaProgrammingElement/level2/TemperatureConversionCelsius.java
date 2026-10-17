package javaProgrammingElement.level2;
import java.util.Scanner;

//Created temperatureConversionCelsius Class to convert Celsius to Fahrenheit
public class TemperatureConversionCelsius {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created a double variable to take temperature in Celsius
        double celsius = sc.nextDouble();

        //Compute and store the temperature in Fahrenheit
        double fahrenheitResult = (celsius * 9 / 5) + 32;

        //Display Result
        System.out.println("The " + celsius + " Celsius is " + fahrenheitResult + " Fahrenheit");
    }
}
