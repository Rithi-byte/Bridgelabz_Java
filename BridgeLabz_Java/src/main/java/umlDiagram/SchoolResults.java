package umlDiagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a subject and the marks obtained by a student.
 */
class Subject {
    String subjectName;
    double marks;

    /**
     * Creates a subject with its name and marks.
     *
     * @param subjectName the name of the subject
     * @param marks the marks obtained in the subject
     */
    Subject(String subjectName, double marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }
}

/**
 * Represents a student and the subjects taken by the student.
 */
class Student {
    String name;
    int rollNo;
    List<Subject> subjects = new ArrayList<>();

    /**
     * Creates a student with a name and roll number.
     *
     * @param name the student's name
     * @param rollNo the student's roll number
     */
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    /**
     * Adds a subject to the student's subject list.
     *
     * @param subject the subject to add
     */
    void addSubject(Subject subject) {
        subjects.add(subject);
    }
}

/**
 * Calculates and displays a student's total marks, average, and grade.
 */
class GradeCalculator {

    /**
     * Calculates the total and average marks and displays the
     * corresponding grade for the specified student.
     *
     * @param student the student whose results are calculated
     */
    void calculateGrade(Student student) {
        double total = 0;

        // Display the student's details.
        System.out.println("\n--- Student Results ---");
        System.out.println("Name: " + student.name);
        System.out.println("Roll No: " + student.rollNo);

        // Display each subject's marks and calculate the total.
        for (Subject subject : student.subjects) {
            System.out.println(
                    subject.subjectName + ": " + subject.marks
            );

            total += subject.marks;
        }

        // Calculate the average marks.
        double average = total / student.subjects.size();

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);

        // Assign a grade based on the average marks.
        if (average >= 90)
            System.out.println("Grade: A");
        else if (average >= 75)
            System.out.println("Grade: B");
        else if (average >= 50)
            System.out.println("Grade: C");
        else
            System.out.println("Grade: Fail");
    }
}

/**
 * Runs the school results application.
 * Accepts student details and subject marks, then displays the results.
 */
public class SchoolResults {

    /**
     * Starts the application and collects student information
     * and subject marks from the user.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the student's details.
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Create a student object.
        Student student = new Student(name, rollNo);

        // Read the number of subjects.
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Collect the name and marks for each subject.
        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject name: ");
            String subjectName = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine(); // Consume the leftover newline.

            // Create the subject and add it to the student.
            student.addSubject(new Subject(subjectName, marks));
        }

        // Calculate and display the student's results.
        GradeCalculator calculator = new GradeCalculator();
        calculator.calculateGrade(student);

        // Close the scanner after input is complete.
        sc.close();
    }
}
