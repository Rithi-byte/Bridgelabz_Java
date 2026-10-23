
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a course that maintains a list of enrolled students.
 */
class AcademicCourse {
    String name;
    ArrayList<SchoolStudent> students = new ArrayList<>();

    /**
     * Initializes a course with the specified name.
     *
     * @param name the course name
     */
    AcademicCourse(String name) {
        this.name = name;
    }

    /**
     * Adds a student to the course.
     *
     * @param student the student to add
     */
    void addStudent(SchoolStudent student) {
        students.add(student);
    }

    /**
     * Displays all students enrolled in the course.
     */
    void displayStudents() {
        System.out.println("Students in " + name + ":");

        // Display the name of each enrolled student.
        for (SchoolStudent s : students) {
            System.out.println(s.name);
        }
    }
}

/**
 * Represents a student who can enroll in multiple courses.
 */
class SchoolStudent {
    String name;
    ArrayList<AcademicCourse> courses = new ArrayList<>();

    /**
     * Initializes a student with the specified name.
     *
     * @param name the student's name
     */
    SchoolStudent(String name) {
        this.name = name;
    }

    /**
     * Enrolls the student in a course and updates both relationships.
     *
     * @param course the course to enroll in
     */
    void enroll(AcademicCourse course) {
        // Record the course for the student.
        courses.add(course);

        // Record the student in the course's student list.
        course.addStudent(this);
    }

    /**
     * Displays all courses in which the student is enrolled.
     */
    void displayCourses() {
        System.out.println("Courses of " + name + ":");

        // Display the name of each enrolled course.
        for (AcademicCourse c : courses) {
            System.out.println(c.name);
        }
    }
}

/**
 * Represents a school that maintains a list of students.
 */
class EducationalInstitute {
    String name;
    ArrayList<SchoolStudent> students = new ArrayList<>();

    /**
     * Initializes a school with the specified name.
     *
     * @param name the school's name
     */
    EducationalInstitute(String name) {
        this.name = name;
    }

    /**
     * Adds a student to the school.
     *
     * @param s the student to add
     */
    void addStudent(SchoolStudent s) {
        students.add(s);
    }
}

/**
 * Demonstrates the relationships between a school, students, and courses.
 */
public class SchoolDemo {

    /**
     * Executes the school enrollment demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the school name and create the school.
        System.out.print("Enter school name: ");
        EducationalInstitute school =
                new EducationalInstitute(sc.nextLine());

        // Read the student name and create the student.
        System.out.print("Enter student name: ");
        SchoolStudent student = new SchoolStudent(sc.nextLine());

        // Read the first course name.
        System.out.print("Enter first course: ");
        AcademicCourse c1 = new AcademicCourse(sc.nextLine());

        // Read the second course name.
        System.out.print("Enter second course: ");
        AcademicCourse c2 = new AcademicCourse(sc.nextLine());

        // Register the student with the school.
        school.addStudent(student);

        // Enroll the student in both courses.
        student.enroll(c1);
        student.enroll(c2);

        // Display the student's courses and the first course's students.
        student.displayCourses();
        c1.displayStudents();

        // Close the Scanner after input is complete.
        sc.close();
    }
}
