
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

class UniversityStudent {
    String name;
    ArrayList<UniversityCourse> courses = new ArrayList<>();

    UniversityStudent(String name) {
        this.name = name;
    }

    void enrollCourse(UniversityCourse course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.name);
    }
}

class UniversityProfessor {
    String name;

    UniversityProfessor(String name) {
        this.name = name;
    }
}

class UniversityCourse {
    String name;
    UniversityProfessor professor;
    ArrayList<UniversityStudent> students = new ArrayList<>();

    UniversityCourse(String name) {
        this.name = name;
    }

    void assignProfessor(UniversityProfessor professor) {
        this.professor = professor;
        System.out.println(professor.name + " teaches " + name);
    }

    void addStudent(UniversityStudent student) {
        students.add(student);
    }

    void displayDetails() {
        System.out.println("\nCourse: " + name);

        if (professor != null) {
            System.out.println("Professor: " + professor.name);
        }

        System.out.println("Enrolled Students:");
        for (UniversityStudent student : students) {
            System.out.println(student.name);
        }
    }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        UniversityStudent student =
                new UniversityStudent(sc.nextLine());

        System.out.print("Enter professor name: ");
        UniversityProfessor professor =
                new UniversityProfessor(sc.nextLine());

        System.out.print("Enter course name: ");
        UniversityCourse course =
                new UniversityCourse(sc.nextLine());

        student.enrollCourse(course);
        course.assignProfessor(professor);

        course.displayDetails();

        sc.close();
    }
}
