package classesAndObject.level2;

import java.util.Scanner;

/**
 * Represents a student and generates a student report.
 */
class Student {
    String name;
    int rollNumber;
    double marks;

    /**
     * Calculates the grade based on the student's marks.
     *
     * @return the grade obtained by the student
     */
    char calculateGrade() {
        // Determine the grade using the marks.
        if (marks >= 90)
            return 'A';
        else if (marks >= 80)
            return 'B';
        else if (marks >= 70)
            return 'C';
        else if (marks >= 60)
            return 'D';
        else
            return 'F';
    }

    /**
     * Displays the student's details and grade.
     */
    void displayDetails() {
        // Display the student report.
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();

        // Read student details.
        System.out.print("Enter name: ");
        s1.name = sc.nextLine();

        System.out.print("Enter roll number: ");
        s1.rollNumber = sc.nextInt();

        System.out.print("Enter marks: ");
        s1.marks = sc.nextDouble();

        // Display the student report.
        if (s1.marks < 0 || s1.marks > 100) {
            System.out.println("Invalid marks. Enter marks from 0 to 100.");
        } else {
            s1.displayDetails();
        }

        sc.close();
    }
}
