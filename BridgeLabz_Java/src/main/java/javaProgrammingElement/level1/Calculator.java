package javaProgrammingElement.level1;
import java.util.Scanner;
//Created Calculator class to calculate arithmetic operation
//Result -addition,multiplication,division and subtraction
public class Calculator {
    public static void main(String[] args){
        //Create a Scanner object to take input
        Scanner input=new Scanner(System.in);

        //Two float value inputs
        float number1=input.nextFloat();
        float number2=input.nextFloat();

        //Computing arithmetic operations and storing in variables
        //Addition(add),multiplication(mul) and subtraction(sub)
        float add=number1+number2;
        float sub=number1-number2;
        float mul=number1*number2;
        float div=0;

        //Possibility of arithmetic error for zero division
        try{
            div=number1/number2;
        } catch (ArithmeticException e) {
            div=0;
        }

        //Display the result
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+"  and "+number2+" is "+add+","+ sub+","+mul+" and "+div
        );
        input.close();

    }
}
