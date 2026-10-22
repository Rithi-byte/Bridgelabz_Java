package javaConstructors.level2;

import java.util.Scanner;

/**
 * Represents a course offered by an institute.
 */
class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "ABC Institute";

    /**
     * Initializes the course details.
     *
     * @param courseName the name of the course
     * @param duration the course duration in months
     * @param fee the course fee
     */
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    /**
     * Displays the course details and institute name.
     */
    void displayCourseDetails() {
        // Display instance-specific and shared information.
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    /**
     * Updates the institute name for all course objects.
     *
     * @param name the new institute name
     */
    static void updateInstituteName(String name) {
        // Update the shared class variable.
        instituteName = name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the first course details.
        System.out.print("Enter course name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter duration in months: ");
        int duration1 = sc.nextInt();

        System.out.print("Enter course fee: ");
        double fee1 = sc.nextDouble();
        sc.nextLine();

        // Read the second course details.
        System.out.print("Enter another course name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter duration in months: ");
        int duration2 = sc.nextInt();

        System.out.print("Enter course fee: ");
        double fee2 = sc.nextDouble();
        sc.nextLine();

        // Create course objects.
        Course c1 = new Course(name1, duration1, fee1);
        Course c2 = new Course(name2, duration2, fee2);

        // Change the institute name for every course.
        System.out.print("Enter updated institute name: ");
        String institute = sc.nextLine();
        Course.updateInstituteName(institute);

        // Both objects display the updated shared name.
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        sc.close();
    }
}
