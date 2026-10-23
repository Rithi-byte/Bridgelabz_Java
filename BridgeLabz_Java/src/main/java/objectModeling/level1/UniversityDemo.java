package objectModeling.level1;
import java.util.ArrayList;
import java.util.Scanner;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    ArrayList<Faculty> facultyMembers = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    void addFaculty(Faculty f) {
        facultyMembers.add(f);
    }

    void display() {
        System.out.println("Department: " + name);
        for (Faculty f : facultyMembers) {
            System.out.println("Faculty: " + f.name);
        }
    }
}

class University {
    String name;
    ArrayList<Department> departments = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    void display() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.display();
        }
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter university name: ");
        University university = new University(sc.nextLine());

        System.out.print("Enter department name: ");
        university.addDepartment(sc.nextLine());

        System.out.print("Enter independent faculty name: ");
        Faculty faculty = new Faculty(sc.nextLine());

        university.departments.get(0).addFaculty(faculty);
        university.display();

        university = null;
        System.out.println("University reference removed.");
        System.out.println("Independent faculty still exists: " + faculty.name);

        sc.close();
    }
}
