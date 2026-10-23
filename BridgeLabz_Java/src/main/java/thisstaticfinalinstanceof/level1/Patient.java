
package thisstaticfinalinstanceof.level1;

import java.util.Scanner;

/**
 * Represents a patient and demonstrates static, final, and instanceof concepts.
 */
class Patient {

    // Shared hospital name and patient count across all Patient objects.
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    // Instance variables store individual patient details.
    String name;
    int age;
    String ailment;

    // The patient ID is assigned once and cannot be reassigned.
    final int patientID;

    /**
     * Initializes a patient and increments the total patient count.
     *
     * @param name the patient's name
     * @param age the patient's age
     * @param ailment the patient's medical condition
     * @param patientID the patient's unique ID
     */
    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;

        // Increment the shared count whenever a patient is created.
        totalPatients++;
    }

    /**
     * Displays the total number of patients created.
     */
    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    /**
     * Displays the hospital name and the patient's details.
     */
    void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
    }

    /**
     * Executes the patient details demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the patient's name.
        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        // Read the patient's age.
        System.out.print("Enter patient age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Read the patient's ailment.
        System.out.print("Enter ailment: ");
        String ailment = sc.nextLine();

        // Read the patient's ID.
        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();

        // Create a Patient object with the entered details.
        Patient patient = new Patient(name, age, ailment, id);

        // Store the Patient reference in a variable of type Object.
        Object obj = patient;

        // Check the object's type before casting and displaying details.
        if (obj instanceof Patient) {
            ((Patient) obj).displayDetails();
        }

        // Display the total number of patients created.
        getTotalPatients();

        // Close the Scanner after input is complete.
        sc.close();
    }
}
