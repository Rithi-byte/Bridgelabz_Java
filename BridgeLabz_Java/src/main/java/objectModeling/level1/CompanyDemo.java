package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    ArrayList<Employee> employees = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    void display() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            System.out.println("Employee: " + e.name);
        }
    }
}

class Company {
    String name;
    ArrayList<Department> departments = new ArrayList<>();

    Company(String name) {
        this.name = name;
    }

    void addDepartment(String deptName, String employeeName) {
        Department d = new Department(deptName);
        d.addEmployee(employeeName);
        departments.add(d);
    }

    void display() {
        System.out.println("\nCompany: " + name);
        for (Department d : departments) {
            d.display();
        }
    }
}

public class CompanyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter company name: ");
        Company company = new Company(sc.nextLine());

        System.out.print("Enter department name: ");
        String dept = sc.nextLine();

        System.out.print("Enter employee name: ");
        String emp = sc.nextLine();

        company.addDepartment(dept, emp);
        company.display();

        company = null;
        System.out.println("Company reference removed.");

        sc.close();
    }
}

