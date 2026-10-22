package javaConstructors.level1;
import java.util.Scanner;

/**
 * Represents a person and supports copying another person's details.
 */
class Person {
    String name;
    int age;

    /**
     * Initializes a person with the given details.
     *
     * @param name the person's name
     * @param age the person's age
     */
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Creates a new person by copying another person's attributes.
     *
     * @param other the person to copy
     */
    Person(Person other) {
        this(other.name, other.age);
    }

    /**
     * Displays the person's details.
     */
    void displayDetails() {
        // Print the person's attributes.
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the original person's details.
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        if (age < 0) {
            System.out.println("Age cannot be negative.");
            sc.close();
            return;
        }

        Person p1 = new Person(name, age);

        // Create a separate object using the copy constructor.
        Person p2 = new Person(p1);

        System.out.println("Original Person:");
        p1.displayDetails();

        System.out.println("Copied Person:");
        p2.displayDetails();

        sc.close();
    }
}
