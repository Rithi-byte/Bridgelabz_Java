package javaMethods.level1;
import java.util.Scanner;
//Created Handshakes class  to find the maximum number of handshakes
// among N number of students.
public class Handshakes {
    /**
     * Created maxNumberOfHandshakes method  to find the maximum number of handshakes among N number of students.
     *
     * @param numberOfStudents int type number of students
     * @return  int type number of handshakes
     */
    public static int maxNumberOfHandshakes(int numberOfStudents){
        //Calculate the maximum number of possible handshakes.
        int handshakes=(int)(numberOfStudents*(numberOfStudents-1))/2;

        //Return the combination to calculate number of handshakes
        return handshakes;

    }

    public static void main(String[] args) {
        //Created scanner object
        Scanner sc=new Scanner(System.in);

        //Get integer input for number of students
        int numberOfStudents=sc.nextInt();

        //Call the method
        int maximumHandshakes=maxNumberOfHandshakes(numberOfStudents);

        //Display the number of possible handshakes
        System.out.println("For "+numberOfStudents+" number of students has "+maximumHandshakes+" maximum number of handshakes");

    }
}
