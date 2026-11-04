
package javaGenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Created CourseType: Abstract parent class for all course categories.
// Purpose: Defines a common structure for different evaluation types.
// Special: Abstract method must be implemented by every child class.
abstract class CourseType {

    abstract String getEvaluationType();
}

// 2. Created ExamCourse: Represents an exam-based course.
// Purpose: Identifies courses evaluated through examinations.
// Special: Inherits CourseType and returns its evaluation type.
class ExamCourse extends CourseType {

    @Override
    String getEvaluationType() {
        return "Exam Based";
    }
}

// 3. Created AssignmentCourse: Represents an assignment-based course.
// Purpose: Identifies courses evaluated through assignments.
// Special: Inherits CourseType and provides its own evaluation type.
class AssignmentCourse extends CourseType {

    @Override
    String getEvaluationType() {
        return "Assignment Based";
    }
}

// 4. Created ResearchCourse: Represents a research-based course.
// Purpose: Identifies courses evaluated through research work.
// Special: Inherits CourseType and provides its own evaluation type.
class ResearchCourse extends CourseType {

    @Override
    String getEvaluationType() {
        return "Research Based";
    }
}

// 5. Created Course<T>: Represents an individual university course.
// Purpose: Stores course ID, name, department, and evaluation type.
// Special: Generic class with bounded type parameter
// T extends CourseType ensures only valid course categories are accepted.
class Course<T extends CourseType> {

    // Static counter shared by all Course objects for unique ID generation.
    static int counter = 100;

    int id;
    String courseName;
    String department;
    T courseType;

    // Constructor initializes course details and generates a unique ID.
    Course(String courseName, String department, T courseType) {

        this.id = ++counter;
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    // Displays complete course details.
    void display() {

        System.out.println(
                "ID: " + id +
                        " | Course: " + courseName +
                        " | Department: " + department +
                        " | Evaluation: " + courseType.getEvaluationType()
        );
    }
}

// 6. Created University: Manages all university courses.
// Purpose: Adds, stores, displays, and searches courses.
// Special: Uses ArrayList<Course<?>> to store different course categories
// together and a wildcard method to display compatible course lists.
class University {

    // Stores different types of courses in a single collection.
    // ? allows Course objects with any valid CourseType parameter.
    ArrayList<Course<?>> courses = new ArrayList<>();

    // Adds any valid Course object to the university.
    void addCourse(Course<?> course) {
        courses.add(course);
    }

    // Wildcard method to display different types of courses.
    // ? extends Course<?> accepts lists whose element type
    // is a subtype of Course<?>.
    void displayCourses(List<? extends Course<?>> courses) {

        for (Course<?> course : courses) {
            course.display();
        }
    }

    // Searches for a course using its unique ID.
    // Returns Course<?> because the course can belong to any category.
    Course<?> searchCourse(int id) {

        for (Course<?> course : courses) {

            if (course.id == id) {
                return course;
            }
        }

        // Returns null if the course is not found.
        return null;
    }
}

// 7. Created UniversityCourseManagement: Main class of the application.
// Purpose: Accepts user input and manages university course operations.
// Special: Uses Scanner, switch-case, and a menu-driven loop
// to add, display, and search courses of different evaluation types.
public class UniversityCourseManagement {

    public static void main(String[] args) {

        // Scanner object to accept user input.
        Scanner sc = new Scanner(System.in);

        // Creating University object to manage courses.
        University university = new University();

        int choice;

        // Menu-driven application continues until the user exits.
        do {

            System.out.println("\n===== UNIVERSITY COURSE MANAGEMENT =====");

            System.out.println("1. Add Exam-Based Course");
            System.out.println("2. Add Assignment-Based Course");
            System.out.println("3. Add Research-Based Course");
            System.out.println("4. Display All Courses");
            System.out.println("5. Search Course");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Consumes the leftover newline after nextInt().
            sc.nextLine();

            switch (choice) {

                // Creates and adds an Exam-Based course.
                case 1: {

                    System.out.print("Enter course name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();

                    // T is inferred as ExamCourse.
                    Course<ExamCourse> course =
                            new Course<>(name, dept, new ExamCourse());

                    university.addCourse(course);

                    System.out.println("Exam course added successfully!");
                    break;
                }

                // Creates and adds an Assignment-Based course.
                case 2: {

                    System.out.print("Enter course name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();

                    // T is inferred as AssignmentCourse.
                    Course<AssignmentCourse> course =
                            new Course<>(name, dept, new AssignmentCourse());

                    university.addCourse(course);

                    System.out.println("Assignment course added successfully!");
                    break;
                }

                // Creates and adds a Research-Based course.
                case 3: {

                    System.out.print("Enter course name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();

                    // T is inferred as ResearchCourse.
                    Course<ResearchCourse> course =
                            new Course<>(name, dept, new ResearchCourse());

                    university.addCourse(course);

                    System.out.println("Research course added successfully!");
                    break;
                }

                // Displays all courses stored in the university.
                case 4:

                    System.out.println("\n===== ALL UNIVERSITY COURSES =====");

                    university.displayCourses(university.courses);
                    break;

                // Searches for a course using its ID.
                case 5: {

                    System.out.print("Enter course ID: ");
                    int id = sc.nextInt();

                    // Wildcard reference can hold any Course category.
                    Course<?> result = university.searchCourse(id);

                    if (result != null) {
                        System.out.println("\nCourse Found:");
                        result.display();
                    } else {
                        System.out.println("Course not found!");
                    }

                    break;
                }

                // Exits the application.
                case 6:

                    System.out.println("Exiting University System...");
                    break;

                // Handles invalid menu choices.
                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        // Closes Scanner after program execution.
        sc.close();
    }
}
