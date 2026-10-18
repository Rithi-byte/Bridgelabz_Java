package controlFlow.level1;
import java.util.Scanner;
//Created class SumOfNaturalFor  to find the sum of n natural numbers using for loop and compare
public class SumOfNaturalFor {
    /**
     * to find the sum of n natural numbers using for loop
     * compare the result with the formulae n*(n+1)/2
     * show the result from both computations was correct
     *
     * @param args taken in command line client
     *
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);
        //User input for natural number
        int n=sc.nextInt();
        //Check if  it's a Natural number
        if(n<0){
            System.out.println("Not a natural number");
        }
        else{
            //Compute sum using formulae
            long formula_sum=(long) n*(n+1)/2;
            //Compute sum using for loop
            long for_sum=0;
            for(int i=1;i<n+1;i++){
                for_sum+=i;
            }
            //Compare the two results and print the result
            if(for_sum==formula_sum){
                System.out.println("Equal");
                System.out.println("For loop sum: "+for_sum);
                System.out.println("Formula sum: "+formula_sum);
            }
            else{
                System.out.println("Not equal");
            }
        }
    }
}
