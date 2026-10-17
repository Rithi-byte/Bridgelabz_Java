package javaProgrammingElement.level1;
//Created a class DividingPen to  find how many pens each student
// will get if the pens must be divided equally
public class DividingPen {
    public static void main(String[] args){
        //Create variable to store total pens and number of students
        int totalPen=14;
        int students=3;

        //Calculate the number of pens that are distributed
        int perPerson=(int)totalPen/students;

        //Calculate the remaining students
        int remainingStudent=totalPen%students;
        //Print the pen division and remaining pen
        System.out.println("The Pen Per Student is "+perPerson+" and the remaining pen not distributed is "+remainingStudent);
    }
}

