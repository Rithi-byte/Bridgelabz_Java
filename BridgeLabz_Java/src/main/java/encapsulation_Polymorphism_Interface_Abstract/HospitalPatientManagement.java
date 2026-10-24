
package encapsulation_Polymorphism_Interface_Abstract;

import java.util.ArrayList;
import java.util.List;

// Interface for managing medical records
interface MedicalRecord {
    void addRecord(String record);

    String viewRecords();
}

// Abstract parent class
abstract class Patient implements MedicalRecord {

    // Encapsulated patient details
    private int patientId;
    private String name;
    private int age;

    // Sensitive medical information is private
    private String diagnosis;
    private List<String> medicalHistory;

    // Constructor
    public Patient(int patientId, String name, int age,
                   String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = new ArrayList<>();
    }

    // Getter methods
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Medical history is updated through controlled methods
    @Override
    public void addRecord(String record) {
        if (record != null && !record.trim().isEmpty()) {
            medicalHistory.add(record);
            System.out.println("Medical record added.");
        } else {
            System.out.println("Invalid medical record.");
        }
    }

    @Override
    public String viewRecords() {
        return String.join("\n", medicalHistory);
    }

    // Abstract billing method
    public abstract double calculateBill();

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medical History: "
                + (medicalHistory.isEmpty()
                ? "No records" : viewRecords()));
        System.out.println("Total Bill: " + calculateBill());
        System.out.println("--------------------------------");
    }
}

// In-patient: includes room charges and treatment charges
class InPatient extends Patient {

    private int daysAdmitted;
    private double roomChargePerDay;
    private double treatmentCharge;

    public InPatient(int id, String name, int age,
                     String diagnosis, int daysAdmitted,
                     double roomChargePerDay,
                     double treatmentCharge) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
        this.treatmentCharge = treatmentCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * roomChargePerDay + treatmentCharge;
    }
}

// Out-patient: includes consultation and test charges
class OutPatient extends Patient {

    private double consultationFee;
    private double testCharges;

    public OutPatient(int id, String name, int age,
                      String diagnosis, double consultationFee,
                      double testCharges) {
        super(id, name, age, diagnosis);
        this.consultationFee = consultationFee;
        this.testCharges = testCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFee + testCharges;
    }
}

// Main class
public class HospitalPatientManagement {

    // Process different patient types using polymorphism
    public static void displayPatients(List<Patient> patients) {
        for (Patient patient : patients) {
            patient.getPatientDetails();
        }
    }

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient(
                101, "Arun", 45, "Fever",
                3, 2000, 5000);

        Patient p2 = new OutPatient(
                102, "Priya", 30, "Migraine",
                800, 1200);

        // Add medical records
        p1.addRecord("Blood test completed");
        p1.addRecord("Medication prescribed");

        p2.addRecord("Consultation completed");

        // Add patients to the list
        patients.add(p1);
        patients.add(p2);

        // Display patient details and dynamically calculated bills
        displayPatients(patients);
    }
}
