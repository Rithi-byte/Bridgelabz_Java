package controlFlow.level1;
import java.util.Scanner;
//Created class SumOfNaturalWhile  to find the sum of n natural numbers using while loop
public class SumOfNaturalWhile {
    /**
     * to find the sum of n natural numbers using while loop
     * compare the result with the formulae n*(n+1)/2
     * show the result from both computations was correct
     *
     * @param n Integer type - User input
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
            //Compute sum using while loop
            long while_sum=0;
            while(n!=0){
                while_sum+=n;
                n--;
            }
            //Compare the two results and print the result
            if(while_sum==formula_sum){
                System.out.println("Equal");
                System.out.println("While loop sum: "+while_sum);
                System.out.println("Formula sum: "+formula_sum);
            }
            else{
                System.out.println("Not equal");
            }
        }
    }
}
