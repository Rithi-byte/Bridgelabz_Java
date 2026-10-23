package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String name;
    ArrayList<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displayStudents() {
        System.out.println("Students in " + name + ":");
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    void displayCourses() {
        System.out.println("Courses of " + name + ":");
        for (Course c : courses) {
            System.out.println(c.name);
        }
    }
}

class School {
    String name;
    ArrayList<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter school name: ");
        School school = new School(sc.nextLine());

        System.out.print("Enter student name: ");
        Student student = new Student(sc.nextLine());

        System.out.print("Enter first course: ");
        Course c1 = new Course(sc.nextLine());

        System.out.print("Enter second course: ");
        Course c2 = new Course(sc.nextLine());

        school.addStudent(student);
        student.enroll(c1);
        student.enroll(c2);

        student.displayCourses();
        c1.displayStudents();

        sc.close();
    }
}
