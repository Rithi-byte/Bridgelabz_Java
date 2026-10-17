package javaProgrammingElement.level1;
//Creating ageCalculator class indicating the purpose is to calculate age
//Result age
public class AgeCalculator {
    public static void main(String[] args){
        //Create an int variable to store Harry's Birthyear
        int birthyear=2000;

        //Create an int variable to store the current year
        int Currentyear=2024;

        //Create a variable to calculate the age {@code Currentyear-birthyear}
        int Age=Currentyear-birthyear;

        //Print the age
        System.out.println("Harry's age in 2024 is :"+Age);
    }
}