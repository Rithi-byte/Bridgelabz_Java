package thisstaticfinalinstanceof.level1;
import java.util.Scanner;

class Student {
    static String universityName = "SRM University";
    static int totalStudents = 0;

    String name;
    final int rollNumber;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    void updateGrade(String newGrade) {
        this.grade = newGrade;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        Student student = new Student(name, rollNumber, grade);

        Object obj = student;
        if (obj instanceof Student) {
            Student s = (Student) obj;
            s.displayDetails();

            System.out.print("Enter updated grade: ");
            String newGrade = sc.nextLine();

            s.updateGrade(newGrade);
            System.out.println("Updated Grade: " + s.grade);
        }

        displayTotalStudents();
        sc.close();
    }
}
