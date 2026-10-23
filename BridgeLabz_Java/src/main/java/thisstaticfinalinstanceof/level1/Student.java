
package thisstaticfinalinstanceof.level1;

import java.util.Scanner;

/**
 * Represents a student and demonstrates static, final, this,
 * and instanceof concepts in Java.
 */
class Student {

    // Shared university name and student count across all Student objects.
    static String universityName = "SRM University";
    static int totalStudents = 0;

    // Instance variables store individual student details.
    String name;

    // The roll number is assigned once and cannot be reassigned.
    final int rollNumber;

    // Grade can be updated after the object is created.
    String grade;

    /**
     * Initializes a student and increments the total student count.
     *
     * @param name the student's name
     * @param rollNumber the student's roll number
     * @param grade the student's initial grade
     */
    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;

        // Increment the shared counter for each new student.
        totalStudents++;
    }

    /**
     * Displays the total number of students created.
     */
    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    /**
     * Displays the university name and the student's details.
     */
    void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    /**
     * Updates the student's grade.
     *
     * @param newGrade the updated grade
     */
    void updateGrade(String newGrade) {
        // Update the grade of the current student object.
        this.grade = newGrade;
    }

    /**
     * Executes the student details and grade update demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the student's name.
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        // Read the student's roll number.
        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Read the student's initial grade.
        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        // Create a Student object with the entered details.
        Student student = new Student(name, rollNumber, grade);

        // Store the Student reference in a variable of type Object.
        Object obj = student;

        // Check the object's type before casting it to Student.
        if (obj instanceof Student) {
            Student s = (Student) obj;

            // Display the student's initial details.
            s.displayDetails();

            // Read the updated grade.
            System.out.print("Enter updated grade: ");
            String newGrade = sc.nextLine();

            // Update and display the student's grade.
            s.updateGrade(newGrade);
            System.out.println("Updated Grade: " + s.grade);
        }

        // Display the total number of students created.
        displayTotalStudents();

        // Close the Scanner after input is complete.
        sc.close();
    }
}
