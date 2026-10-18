package controlFlow.level1;
import java.util.Scanner;
//Created BonusOfEmployees class to find the bonus of employees based on their years of service.
public class BonusOfEmployees {
    /**
     * Take salary and year of service in the year as input.
     * Print the bonus amount.
     * bonus is 5% to employees whose year of service is more than 5 years.
     * @param args command line arguments
     *
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);
        //Bonus for service>5 years in %
        int bonus=5;
        //Take salary and year of service in the year as input.
        //float type for salary and year
        System.out.println("Enter salary: ");
        float salary=sc.nextFloat();
        System.out.println("Enter Service year: ");
        float year=sc.nextFloat();
        //Calculate Bonus amount
        if(year>5){
            //Display the bonus amount
            float bonusAmount=(bonus*5)/100;
            System.out.println("Bonus Amount: "+bonusAmount);
        }
        else{
            //Display that there is no bonus
            System.out.println("No bonus");
        }
        sc.close();
    }

}
