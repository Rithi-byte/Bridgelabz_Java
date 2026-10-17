package javaProgrammingElement.level1;
import java.util.Scanner;

// Created HandshakeCalculator Class to find the maximum number of handshakes
// among students
class HandshakeCalculator {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Take user input for the number of students
        int numberOfStudents = input.nextInt();

        // Combination formula: n * (n - 1) / 2
        int maximumHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display the result
        System.out.println("The maximum number of possible handshakes among " + numberOfStudents
                + " students is " + maximumHandshakes);
        input.close();
    }
}