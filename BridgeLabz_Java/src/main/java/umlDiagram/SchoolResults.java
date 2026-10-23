package umlDiagram;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Subject {
    String subjectName;
    double marks;

    Subject(String subjectName, double marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }
}

class Student {
    String name;
    int rollNo;
    List<Subject> subjects = new ArrayList<>();

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void addSubject(Subject subject) {
        subjects.add(subject);
    }
}

class GradeCalculator {
    void calculateGrade(Student student) {
        double total = 0;

        System.out.println("\n--- Student Results ---");
        System.out.println("Name: " + student.name);
        System.out.println("Roll No: " + student.rollNo);

        for (Subject subject : student.subjects) {
            System.out.println(
                    subject.subjectName + ": " + subject.marks
            );
            total += subject.marks;
        }

        double average = total / student.subjects.size();

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);

        if (average >= 90)
            System.out.println("Grade: A");
        else if (average >= 75)
            System.out.println("Grade: B");
        else if (average >= 50)
            System.out.println("Grade: C");
        else
            System.out.println("Grade: Fail");
    }
}

public class SchoolResults {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student student = new Student(name, rollNo);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject name: ");
            String subjectName = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            student.addSubject(new Subject(subjectName, marks));
        }

        GradeCalculator calculator = new GradeCalculator();
        calculator.calculateGrade(student);

        sc.close();
    }
}
