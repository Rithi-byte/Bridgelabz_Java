
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a student who can enroll in multiple courses.
 */
class CampusStudent {
    String name;
    ArrayList<CampusCourse> courses = new ArrayList<>();

    /**
     * Initializes a student with the specified name.
     *
     * @param name the student's name
     */
    CampusStudent(String name) {
        this.name = name;
    }

    /**
     * Enrolls the student in a course and updates the course's student list.
     *
     * @param course the course in which the student enrolls
     */
    void enrollCourse(CampusCourse course) {
        // Store the course in the student's course list.
        courses.add(course);

        // Register the student in the course.
        course.addStudent(this);

        System.out.println(name + " enrolled in " + course.name);
    }
}

/**
 * Represents a professor who teaches university courses.
 */
class CampusProfessor {
    String name;

    /**
     * Initializes a professor with the specified name.
     *
     * @param name the professor's name
     */
    CampusProfessor(String name) {
        this.name = name;
    }
}

/**
 * Represents a course with an assigned professor and enrolled students.
 */
class CampusCourse {
    String name;
    CampusProfessor professor;
    ArrayList<CampusStudent> students = new ArrayList<>();

    /**
     * Initializes a course with the specified name.
     *
     * @param name the course's name
     */
    CampusCourse(String name) {
        this.name = name;
    }

    /**
     * Assigns a professor to the course.
     *
     * @param professor the professor assigned to the course
     */
    void assignProfessor(CampusProfessor professor) {
        this.professor = professor;
        System.out.println(professor.name + " teaches " + name);
    }

    /**
     * Adds a student to the course's student list.
     *
     * @param student the student to add
     */
    void addStudent(CampusStudent student) {
        students.add(student);
    }

    /**
     * Displays the course name, assigned professor, and enrolled students.
     */
    void displayDetails() {
        System.out.println("\nCourse: " + name);

        // Display the professor only if one has been assigned.
        if (professor != null) {
            System.out.println("Professor: " + professor.name);
        }

        System.out.println("Enrolled Students:");

        // Display all students enrolled in the course.
        for (CampusStudent student : students) {
            System.out.println(student.name);
        }
    }
}

/**
 * Demonstrates student enrollment and professor assignment.
 */
public class UniversityManagementDemo {

    /**
     * Executes the university course management demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the student name.
        System.out.print("Enter student name: ");
        CampusStudent student =
                new CampusStudent(sc.nextLine());

        // Read the professor name.
        System.out.print("Enter professor name: ");
        CampusProfessor professor =
                new CampusProfessor(sc.nextLine());

        // Read the course name.
        System.out.print("Enter course name: ");
        CampusCourse course =
                new CampusCourse(sc.nextLine());

        // Enroll the student and assign the professor.
        student.enrollCourse(course);
        course.assignProfessor(professor);

        // Display the course information.
        course.displayDetails();

        // Close the Scanner after input is complete.
        sc.close();
    }
}
