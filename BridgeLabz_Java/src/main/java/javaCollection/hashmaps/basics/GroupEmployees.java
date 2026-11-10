package javaCollection.hashmaps.basics;


import java.util.*;

class Employee {

    // Employee attributes
    String name;
    String department;

    // Constructor
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Display employee name
    @Override
    public String toString() {
        return name;
    }
}

public class GroupEmployees {

    // Method to group employees by department
    public static Map<String, List<Employee>> groupEmployees(
            List<Employee> employees) {

        // Create map to store department and employee list
        Map<String, List<Employee>> grouped = new HashMap<>();

        // Traverse employee list
        for (Employee emp : employees) {

            // Create department list if it does not exist
            // Add employee to corresponding department
            grouped.computeIfAbsent(
                    emp.department, k -> new ArrayList<>()
            ).add(emp);
        }

        return grouped;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        // Get number of employees
        System.out.println("Enter number of employees:");
        int n = sc.nextInt();

        // Get employee details from user
        for (int i = 0; i < n; i++) {

            System.out.println("Enter employee name:");
            String name = sc.next();

            System.out.println("Enter department:");
            String department = sc.next();

            // Create employee object and add to list
            employees.add(new Employee(name, department));
        }

        // Group employees by department
        Map<String, List<Employee>> result =
                groupEmployees(employees);

        // Display grouped employees
        System.out.println("\nEmployees Grouped by Department:");

        for (Map.Entry<String, List<Employee>> entry :
                result.entrySet()) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }

        sc.close();
    }
}
