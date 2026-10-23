
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a faculty member associated with a university.
 */
class UniversityFaculty {
    String name;

    /**
     * Initializes a faculty member with the specified name.
     *
     * @param name the faculty member's name
     */
    UniversityFaculty(String name) {
        this.name = name;
    }
}

/**
 * Represents a university department that manages faculty members.
 */
class UniversityDepartment {
    String name;
    ArrayList<UniversityFaculty> facultyMembers = new ArrayList<>();

    /**
     * Initializes a department with the specified name.
     *
     * @param name the department's name
     */
    UniversityDepartment(String name) {
        this.name = name;
    }

    /**
     * Adds a faculty member to the department.
     *
     * @param f the faculty member to add
     */
    void addFaculty(UniversityFaculty f) {
        facultyMembers.add(f);
    }

    /**
     * Displays the department name and its faculty members.
     */
    void display() {
        System.out.println("Department: " + name);

        // Display every faculty member in the department.
        for (UniversityFaculty f : facultyMembers) {
            System.out.println("Faculty: " + f.name);
        }
    }
}

/**
 * Represents a university that manages multiple departments.
 */
class AcademicUniversity {
    String name;
    ArrayList<UniversityDepartment> departments = new ArrayList<>();

    /**
     * Initializes a university with the specified name.
     *
     * @param name the university's name
     */
    AcademicUniversity(String name) {
        this.name = name;
    }

    /**
     * Creates and adds a department to the university.
     *
     * @param deptName the name of the department
     */
    void addDepartment(String deptName) {
        departments.add(new UniversityDepartment(deptName));
    }

    /**
     * Displays the university name and its departments.
     */
    void display() {
        System.out.println("University: " + name);

        // Display each department and its faculty members.
        for (UniversityDepartment d : departments) {
            d.display();
        }
    }
}

/**
 * Demonstrates university departments and an independent faculty reference.
 */
public class UniversityDemo {

    /**
     * Executes the university demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the university name.
        System.out.print("Enter university name: ");
        AcademicUniversity university =
                new AcademicUniversity(sc.nextLine());

        // Create a department within the university.
        System.out.print("Enter department name: ");
        university.addDepartment(sc.nextLine());

        // Create a faculty member and keep an independent reference.
        System.out.print("Enter independent faculty name: ");
        UniversityFaculty faculty =
                new UniversityFaculty(sc.nextLine());

        // Associate the faculty member with the first department.
        university.departments.get(0).addFaculty(faculty);

        // Display the university and its department details.
        university.display();

        // Remove the university reference.
        university = null;
        System.out.println("University reference removed.");

        // The faculty reference remains available independently.
        System.out.println(
                "Independent faculty still exists: " + faculty.name);

        sc.close();
    }
}
