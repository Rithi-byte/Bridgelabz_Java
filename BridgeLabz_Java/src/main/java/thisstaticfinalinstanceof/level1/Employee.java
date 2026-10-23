package thisstaticfinalinstanceof.level1;
import java.util.Scanner;

class Employee {
    static String companyName = "TCS";
    static int totalEmployees = 0;

    String name;
    final int id;
    String designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter designation: ");
        String designation = sc.nextLine();

        Employee employee = new Employee(name, id, designation);

        Object obj = employee;
        if (obj instanceof Employee) {
            ((Employee) obj).displayDetails();
        }

        displayTotalEmployees();
        sc.close();
    }
}
