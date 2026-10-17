package basicQuestions;
import java.util.Scanner;
//Created CelsiustoFahrenheit class to convert the temperature in Celsius as input and converts
//it to Fahrenheit
//Result : float value(Fahrenheit)
public class CelsiustoFahrenheit {
    public static void main(String[] args){
        //Create object for Scanner to take input
        Scanner sc=new Scanner(System.in);

        //Take temperature input in float
        float temperatureInCelsius=sc.nextFloat();

        //Compute the Fahrenheit temperature from the formula
        //Fahrenheit = (Celsius * 9/5) + 32
        float temperatureInFahrenheit = (temperatureInCelsius * 9/5) + 32;

        //Display result
        System.out.println("Temperature in celsius :"+temperatureInCelsius);
        System.out.println("Temperature in Fahrenheit :"+temperatureInFahrenheit);

    }
}
