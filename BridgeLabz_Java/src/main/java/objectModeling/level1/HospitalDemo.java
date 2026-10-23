
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a patient visiting a hospital.
 */
class HospitalPatient {
    String name;

    /**
     * Initializes a patient with the given name.
     *
     * @param name the patient's name
     */
    HospitalPatient(String name) {
        this.name = name;
    }
}

/**
 * Represents a doctor who consults patients.
 */
class HospitalDoctor {
    String name;
    ArrayList<HospitalPatient> patients = new ArrayList<>();

    /**
     * Initializes a doctor with the given name.
     *
     * @param name the doctor's name
     */
    HospitalDoctor(String name) {
        this.name = name;
    }

    /**
     * Adds a patient to the doctor's consultation list.
     *
     * @param patient the patient being consulted
     */
    void consult(HospitalPatient patient) {
        patients.add(patient);

        System.out.println("Dr. " + name
                + " is consulting patient " + patient.name);
    }
}

/**
 * Represents a hospital that manages doctors and patients.
 */
class MedicalCenter {
    String name;
    ArrayList<HospitalDoctor> doctors = new ArrayList<>();
    ArrayList<HospitalPatient> patients = new ArrayList<>();

    /**
     * Initializes a hospital with the given name.
     *
     * @param name the hospital's name
     */
    MedicalCenter(String name) {
        this.name = name;
    }
}

/**
 * Demonstrates the relationship between a hospital,
 * its doctors, and its patients.
 */
public class HospitalDemo {

    /**
     * Executes the hospital demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the hospital name.
        System.out.print("Enter hospital name: ");
        MedicalCenter hospital = new MedicalCenter(sc.nextLine());

        // Read the doctor's name.
        System.out.print("Enter doctor name: ");
        HospitalDoctor doctor = new HospitalDoctor(sc.nextLine());

        // Read the patient's name.
        System.out.print("Enter patient name: ");
        HospitalPatient patient = new HospitalPatient(sc.nextLine());

        // Register the doctor and patient with the hospital.
        hospital.doctors.add(doctor);
        hospital.patients.add(patient);

        // Let the doctor consult the patient.
        doctor.consult(patient);

        // Close the Scanner after input is complete.
        sc.close();
    }
}
