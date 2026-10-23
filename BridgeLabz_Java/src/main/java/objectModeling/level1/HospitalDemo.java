package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    ArrayList<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name
                + " is consulting patient " + patient.name);
    }
}

class Hospital {
    String name;
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    Hospital(String name) {
        this.name = name;
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hospital name: ");
        Hospital hospital = new Hospital(sc.nextLine());

        System.out.print("Enter doctor name: ");
        Doctor doctor = new Doctor(sc.nextLine());

        System.out.print("Enter patient name: ");
        Patient patient = new Patient(sc.nextLine());

        hospital.doctors.add(doctor);
        hospital.patients.add(patient);

        doctor.consult(patient);

        sc.close();
    }
}
