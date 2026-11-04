package javaGenerics;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Created JobRole: Abstract parent class representing different job roles.
// Special: Defines common methods that every job role must implement.
abstract class JobRole {

    abstract String roleName();

    abstract String requiredSkill();
}

// Created SoftwareEngineer: Represents the Software Engineer job role.
// Special: Inherits JobRole and provides Java as its required skill.
class SoftwareEngineer extends JobRole {

    @Override
    String roleName() {
        return "Software Engineer";
    }

    @Override
    String requiredSkill() {
        return "Java";
    }
}

// Created DataScientist: Represents the Data Scientist job role.
// Special: Inherits JobRole and provides Python as its required skill.
class DataScientist extends JobRole {

    @Override
    String roleName() {
        return "Data Scientist";
    }

    @Override
    String requiredSkill() {
        return "Python";
    }
}

// Created ProductManager: Represents the Product Manager job role.
// Special: Inherits JobRole and provides Management as its required skill.
class ProductManager extends JobRole {

    @Override
    String roleName() {
        return "Product Manager";
    }

    @Override
    String requiredSkill() {
        return "Management";
    }
}

// Created Resume<T>: Represents a candidate's resume for a particular job role.
// Special: Generic class with bounded type parameter T extends JobRole,
// ensuring that only valid job role objects can be associated with a resume.
class Resume<T extends JobRole> {

    // Static counter shared by all Resume objects for unique ID generation.
    static int counter = 100;

    int resumeId;
    String candidateName;
    String skill;
    T jobRole;

    // Constructor initializes candidate details and automatically generates ID.
    Resume(String candidateName, String skill, T jobRole) {

        this.resumeId = ++counter;
        this.candidateName = candidateName;
        this.skill = skill;
        this.jobRole = jobRole;
    }

    // Displays all candidate resume details.
    void display() {

        System.out.println("\nResume ID: " + resumeId);
        System.out.println("Candidate: " + candidateName);
        System.out.println("Job Role: " + jobRole.roleName());
        System.out.println("Skill: " + skill);
    }
}

// Created ResumeScreeningSystem: Manages and screens candidate resumes.
// Special: Uses a wildcard collection to store different resume types
// and a generic method to screen resumes belonging to different job roles.
class ResumeScreeningSystem {

    // Stores resumes belonging to different job categories.
    // Product-like category types are represented using the wildcard <?>.
    ArrayList<Resume<?>> resumeList = new ArrayList<>();

    // Adds any valid Resume type to the screening system.
    void addResume(Resume<?> resume) {
        resumeList.add(resume);
    }

    // Generic method with bounded type parameter.
    // Accepts resumes associated with any subclass of JobRole.
    <T extends JobRole> void screenResume(Resume<T> resume) {

        System.out.println("\n===== RESUME SCREENING =====");

        // Display candidate details.
        resume.display();

        // Compare candidate skill with the required skill for the selected role.
        if (resume.skill.equalsIgnoreCase(
                resume.jobRole.requiredSkill())) {

            System.out.println("Status: SHORTLISTED");
            System.out.println("Required skill matched!");

        } else {

            System.out.println("Status: NOT SHORTLISTED");
            System.out.println("Required skill not matched!");
        }
    }

    // Wildcard method.
    // ? extends JobRole accepts lists containing any subclass of JobRole.
    void displayJobRoles(List<? extends JobRole> roles) {

        System.out.println("\n===== AVAILABLE JOB ROLES =====");

        for (JobRole role : roles) {

            System.out.println("Job Role: " + role.roleName());
            System.out.println("Required Skill: " + role.requiredSkill());
        }
    }

    // Displays all resumes stored in the screening system.
    void displayAllResumes() {

        if (resumeList.isEmpty()) {
            System.out.println("No resumes available!");
            return;
        }

        System.out.println("\n===== ALL RESUMES =====");

        for (Resume<?> resume : resumeList) {
            resume.display();
        }
    }
}

// Created AIResumeScreeningSystem: Main class that executes the application.
// Special: Accepts user input, creates role-specific resumes,
// adds them to the system, and performs resume screening.
public class AIResumeScreeningSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating ResumeScreeningSystem object.
        ResumeScreeningSystem system = new ResumeScreeningSystem();

        // Creating a list to store available job roles.
        List<JobRole> roles = new ArrayList<>();

        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        int choice;

        // Menu-driven application continues until the user exits.
        do {

            System.out.println("\n===== AI RESUME SCREENING SYSTEM =====");

            System.out.println("1. Add Software Engineer Resume");
            System.out.println("2. Add Data Scientist Resume");
            System.out.println("3. Add Product Manager Resume");
            System.out.println("4. Screen Resume");
            System.out.println("5. Display All Resumes");
            System.out.println("6. Display Job Roles");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // Creating a Software Engineer resume.
                case 1: {

                    System.out.print("Enter candidate name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter candidate skill: ");
                    String skill = sc.nextLine();

                    // T is inferred as SoftwareEngineer.
                    Resume<SoftwareEngineer> resume =
                            new Resume<>(
                                    name,
                                    skill,
                                    new SoftwareEngineer()
                            );

                    system.addResume(resume);

                    System.out.println("Resume added successfully!");
                    break;
                }

                // Creating a Data Scientist resume.
                case 2: {

                    System.out.print("Enter candidate name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter candidate skill: ");
                    String skill = sc.nextLine();

                    // T is inferred as DataScientist.
                    Resume<DataScientist> resume =
                            new Resume<>(
                                    name,
                                    skill,
                                    new DataScientist()
                            );

                    system.addResume(resume);

                    System.out.println("Resume added successfully!");
                    break;
                }

                // Creating a Product Manager resume.
                case 3: {

                    System.out.print("Enter candidate name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter candidate skill: ");
                    String skill = sc.nextLine();

                    // T is inferred as ProductManager.
                    Resume<ProductManager> resume =
                            new Resume<>(
                                    name,
                                    skill,
                                    new ProductManager()
                            );

                    system.addResume(resume);

                    System.out.println("Resume added successfully!");
                    break;
                }

                // Screening a selected resume using its unique ID.
                case 4: {

                    if (system.resumeList.isEmpty()) {
                        System.out.println("No resumes available!");
                        break;
                    }

                    system.displayAllResumes();

                    System.out.print("Enter Resume ID: ");
                    int id = sc.nextInt();

                    // Wildcard reference can hold any Resume category.
                    Resume<?> selected = null;

                    // Searching for the resume using its ID.
                    for (Resume<?> resume : system.resumeList) {

                        if (resume.resumeId == id) {
                            selected = resume;
                            break;
                        }
                    }

                    // Screen the resume if it exists.
                    if (selected != null) {
                        system.screenResume(selected);
                    } else {
                        System.out.println("Resume not found!");
                    }

                    break;
                }

                // Display all stored resumes.
                case 5:

                    system.displayAllResumes();
                    break;

                // Display all available job roles using wildcard method.
                case 6:

                    system.displayJobRoles(roles);
                    break;

                // Exit the application.
                case 7:

                    System.out.println("Exiting Resume Screening System...");
                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
