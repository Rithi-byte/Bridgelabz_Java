package javaConstructors.level3;

import java.util.Scanner;

/**
 * Represents a university student.
 */
class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    /**
     * Initializes the student details.
     *
     * @param rollNumber the student's roll number
     * @param name the student's name
     * @param CGPA the student's CGPA
     */
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        setCGPA(CGPA);
    }

    /**
     * Sets the student's CGPA.
     *
     * @param CGPA the CGPA to assign
     */
    public void setCGPA(double CGPA) {
        // Accept only CGPA values from 0 to 10.
        if (CGPA >= 0 && CGPA <= 10) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA.");
        }
    }

    /**
     * Returns the student's CGPA.
     *
     * @return the current CGPA
     */
    public double getCGPA() {
        return CGPA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read student details.
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        Student s1 = new Student(roll, name, cgpa);

        // Access public and private data appropriately.
        System.out.println("Roll Number: " + s1.rollNumber);
        System.out.println("CGPA: " + s1.getCGPA());

        // Demonstrate modifying private data through a public method.
        System.out.print("Enter updated CGPA: ");
        s1.setCGPA(sc.nextDouble());

        PostgraduateStudent pg = new PostgraduateStudent(roll, name, s1.getCGPA());
        pg.displayDetails();

        sc.close();
    }
}

/**
 * Represents a postgraduate student.
 */
class PostgraduateStudent extends Student {

    /**
     * Initializes a postgraduate student.
     *
     * @param rollNumber the student's roll number
     * @param name the student's name
     * @param CGPA the student's CGPA
     */
    PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    /**
     * Displays inherited student information.
     */
    void displayDetails() {
        // Access protected and public members directly.
        System.out.println("Postgraduate Student: " + name);
        System.out.println("Roll Number: " + rollNumber);

        // Access the private CGPA using its public getter.
        System.out.println("CGPA: " + getCGPA());
    }
}
