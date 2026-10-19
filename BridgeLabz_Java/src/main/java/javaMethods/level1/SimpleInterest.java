package javaMethods.level1;
import java.util.Arrays;
import java.util.Scanner;
//Created SimpleInterest class to input the Principal, Rate, and Time values
// calculate Simple Interest.
public class SimpleInterest {
    /**
     * A method to calculate the simple interest given principle, rate and time as parameters
     * @param principal float type,the prinicipal amount
     * @param rate  float type,the rate of interest in %
     * @param time  float type,the time in the years
     * @return  simple interest float type
     */
    public static float siCalculation(float principal,float rate,float time){
        //Create a float variable
        float si;
        //To calculate the simple interest
        si=(float)(principal*rate*time)/100;
        //Return the simple interest
        return si;
    }

    public static void main(String[] args) {
        //Created a new Scanner object
        Scanner sc=new Scanner(System.in);

        //Take input for prinicipal,rate,time
        System.out.print("Enter principal amount: ");
        float principal=sc.nextFloat();
        System.out.print("Enter rate(%): ");
        float rate=sc.nextFloat();
        System.out.print("Enter time(years): ");
        float time=sc.nextFloat();

        //Calculate Simple Interest
        float SimpleInterest=siCalculation(principal,rate,time);

        //Display the result
        System.out.println("The Simple Interest "+SimpleInterest+" for Principal "+principal+",Rate of interest "+rate+" and Time "+time);
    }
}
