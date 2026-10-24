package encapsulation_Polymorphism_Interface_Abstract;
import java.util.ArrayList;
import java.util.List;
//Create an interface Department with methods like
// assignDepartment() and getDepartmentDetails()
interface Department {
    void assignDepartment(String department);

    String getDepartmentDetails();
}

//Abstract class Employee to store details
abstract class Employee implements Department{
    //Data Encapsulation
    private int employeeId;
    private double baseSalary;
    private String department;
    private String name;

    //Parameterized constructor to  intialize instance variables
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    //Getter methods
    public int getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public double getBaseSalary(){
        return baseSalary;
    }

    //Overrride the methods implemented in department interface
    @Override
    public void assignDepartment(String department){
        this.department=department;
    }
    @Override
    public String getDepartmentDetails(){
        return department;
    }

    //Abstract method
    public abstract double calculateSalary();

    //Concrete method to display
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Salary: " + calculateSalary());
        System.out.println("-------------------------");
    }

}

//Created FullTimeEmployee class to store the results and access
class FullTimeEmployee extends Employee{
    private int workHours;
    FullTimeEmployee(int id,String name,int baseSalary,int workHours){
        super(id,name,baseSalary);
        this.workHours=workHours;
    }
    @Override
    public double calculateSalary(){
        return getBaseSalary();
    }
}
//Created FullTimeEmployee class to store the results and access
class PartTimeEmployee extends Employee{
    private int workHours;
    private int hourlyRate;
    PartTimeEmployee(int id,String name,int workHours,int hourlyRate){
        super(id,name,0);
        this.workHours=workHours;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return workHours*hourlyRate;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
            List<Employee> employee=new ArrayList<>();
            Employee e1=new FullTimeEmployee(1,"Rithi",50000,10);
            Employee e2=new PartTimeEmployee(2,"Raj",6,2000);
            employee.add(e1);
            employee.add(e2);
            for(Employee e:employee){
                e.displayDetails();
                System.out.println();
            }
    }
}
