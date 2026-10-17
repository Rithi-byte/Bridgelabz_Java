package javaProgrammingElement.level1;
//Created AveragePCM to calculate the average of physics,chemistry and maths marks
//Result Double type(Average)
public class AveragePCM {
    public static void main(String[] args){
        //Create int variables to store maths marks,physics marks and chemistry marks
        //Maths marks,Physics marks,Chemistry Marks
        int mathsMarks=94,chemistryMarks=96,physicsMarks=95;

        //Create a variable to calculate the total
        int total=mathsMarks+chemistryMarks+physicsMarks;

        //Create a variable to store the average of the marks
        double average=(double) total/3;

        //Print the Average of PCM(Physics Chemistry Maths)
        System.out.println("Sam’s average mark in PCM is "+average);
    }
}
