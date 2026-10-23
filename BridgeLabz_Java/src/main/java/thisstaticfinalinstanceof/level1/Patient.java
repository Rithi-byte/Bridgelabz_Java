package thisstaticfinalinstanceof.level1;
import java.util.Scanner;

class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    String name;
    int age;
    String ailment;
    final int patientID;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter patient age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter ailment: ");
        String ailment = sc.nextLine();

        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();

        Patient patient = new Patient(name, age, ailment, id);

        Object obj = patient;
        if (obj instanceof Patient) {
            ((Patient) obj).displayDetails();
        }

        getTotalPatients();
        sc.close();
    }
}
