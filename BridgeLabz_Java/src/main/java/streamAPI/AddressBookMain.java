package streamAPI;

import java.util.*;
import java.util.stream.Collectors;

// Represents a contact person
class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Person(String firstName, String lastName, String address,
                  String city, String state, String zip,
                  String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    // Updates existing contact details
    public void update(String address, String city, String state,
                       String zip, String phoneNumber, String email) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Checks duplicate contacts using first and last name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Person)) return false;

        Person person = (Person) obj;

        return firstName.equalsIgnoreCase(person.firstName)
                && lastName.equalsIgnoreCase(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName.toLowerCase(),
                lastName.toLowerCase()
        );
    }

    // Displays contact details
    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName
                + "\nAddress: " + address
                + "\nCity: " + city
                + "\nState: " + state
                + "\nZip: " + zip
                + "\nPhone: " + phoneNumber
                + "\nEmail: " + email;
    }
}

// Manages contacts inside one address book
class AddressBook {

    private String bookName;
    private List<Person> contacts;

    public AddressBook(String bookName) {
        this.bookName = bookName;
        contacts = new ArrayList<>();
    }

    public String getBookName() {
        return bookName;
    }

    public List<Person> getContacts() {
        return contacts;
    }

    // UC 2 and UC 5: Add a new contact
    // UC 7: Prevent duplicate contacts using Streams
    public void addContact(Person person) {

        boolean duplicate = contacts.stream()
                .anyMatch(p -> p.equals(person));

        if (duplicate) {
            System.out.println("Duplicate contact! Person already exists.");
        } else {
            contacts.add(person);
            System.out.println("Contact added successfully.");
        }
    }

    // UC 3: Edit contact using person's name
    public void editContact(String firstName, String lastName,
                            Scanner sc) {

        Optional<Person> result = contacts.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(firstName)
                        && p.getLastName().equalsIgnoreCase(lastName))
                .findFirst();

        if (result.isPresent()) {

            Person person = result.get();

            System.out.print("Enter new Address: ");
            String address = sc.nextLine();

            System.out.print("Enter new City: ");
            String city = sc.nextLine();

            System.out.print("Enter new State: ");
            String state = sc.nextLine();

            System.out.print("Enter new Zip: ");
            String zip = sc.nextLine();

            System.out.print("Enter new Phone Number: ");
            String phone = sc.nextLine();

            System.out.print("Enter new Email: ");
            String email = sc.nextLine();

            person.update(address, city, state, zip, phone, email);

            System.out.println("Contact updated successfully.");

        } else {
            System.out.println("Contact not found.");
        }
    }

    // UC 4: Delete contact using person's name
    public void deleteContact(String firstName, String lastName) {

        boolean removed = contacts.removeIf(p ->
                p.getFirstName().equalsIgnoreCase(firstName)
                        && p.getLastName().equalsIgnoreCase(lastName));

        if (removed) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Display all contacts
    public void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        contacts.forEach(System.out::println);
    }
}

// Main class
public class AddressBookMain {

    // UC 6: Dictionary of Address Book Name to AddressBook
    private static Map<String, AddressBook> addressBooks =
            new LinkedHashMap<>();

    private static Scanner sc = new Scanner(System.in);

    // Read contact details from console
    private static Person readPerson() {

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Zip: ");
        String zip = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        return new Person(firstName, lastName, address,
                city, state, zip, phone, email);
    }

    // UC 8: Search persons across all address books by city or state
    private static void searchAcrossBooks(String value, boolean byCity) {

        List<Person> result = addressBooks.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(p -> byCity
                        ? p.getCity().equalsIgnoreCase(value)
                        : p.getState().equalsIgnoreCase(value))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No matching contacts found.");
        } else {
            result.forEach(System.out::println);
        }
    }

    // UC 9: Group persons using City and State dictionaries
    private static void viewPersonsByCityOrState(boolean byCity) {

        Map<String, List<Person>> groupedPersons =
                addressBooks.values().stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                p -> byCity ? p.getCity() : p.getState(),
                                TreeMap::new,
                                Collectors.toList()
                        ));

        groupedPersons.forEach((location, persons) -> {

            System.out.println("\n" + (byCity ? "City: " : "State: ")
                    + location);

            persons.forEach(System.out::println);
        });
    }

    // UC 10: Count contacts by City or State
    private static void countPersonsByCityOrState(boolean byCity) {

        Map<String, Long> counts =
                addressBooks.values().stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                p -> byCity ? p.getCity() : p.getState(),
                                TreeMap::new,
                                Collectors.counting()
                        ));

        counts.forEach((location, count) ->
                System.out.println(location + " : " + count));
    }

    // UC 11: Sort contacts alphabetically by person's name
    private static void sortByName(AddressBook book) {

        book.getContacts().stream()
                .sorted(Comparator.comparing(Person::getFirstName,
                                String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Person::getLastName,
                                String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    // UC 12: Sort contacts by City, State or Zip
    private static void sortContacts(AddressBook book, int choice) {

        Comparator<Person> comparator;

        switch (choice) {

            case 1:
                comparator = Comparator.comparing(
                        Person::getCity,
                        String.CASE_INSENSITIVE_ORDER);
                break;

            case 2:
                comparator = Comparator.comparing(
                        Person::getState,
                        String.CASE_INSENSITIVE_ORDER);
                break;

            case 3:
                comparator = Comparator.comparing(Person::getZip);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        book.getContacts().stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    // Menu for individual address book
    private static void addressBookMenu(AddressBook book) {

        int choice;

        do {
            System.out.println("\n===== " + book.getBookName() + " =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Sort by Name");
            System.out.println("6. Sort by City");
            System.out.println("7. Sort by State");
            System.out.println("8. Sort by Zip");
            System.out.println("9. Back to Main Menu");

            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    book.addContact(readPerson());
                    break;

                case 2:
                    System.out.print("Enter First Name: ");
                    String editFirst = sc.nextLine();

                    System.out.print("Enter Last Name: ");
                    String editLast = sc.nextLine();

                    book.editContact(editFirst, editLast, sc);
                    break;

                case 3:
                    System.out.print("Enter First Name: ");
                    String deleteFirst = sc.nextLine();

                    System.out.print("Enter Last Name: ");
                    String deleteLast = sc.nextLine();

                    book.deleteContact(deleteFirst, deleteLast);
                    break;

                case 4:
                    book.displayContacts();
                    break;

                case 5:
                    sortByName(book);
                    break;

                case 6:
                    sortContacts(book, 1);
                    break;

                case 7:
                    sortContacts(book, 2);
                    break;

                case 8:
                    sortContacts(book, 3);
                    break;

                case 9:
                    System.out.println("Returning to Main Menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);
    }

    // Main method
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book System");

        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Create Address Book");
            System.out.println("2. Open Address Book");
            System.out.println("3. Search Person by City");
            System.out.println("4. Search Person by State");
            System.out.println("5. View Persons by City");
            System.out.println("6. View Persons by State");
            System.out.println("7. Count Persons by City");
            System.out.println("8. Count Persons by State");
            System.out.println("9. Display Address Books");
            System.out.println("10. Exit");

            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                // UC 6: Create multiple address books
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String bookName = sc.nextLine();

                    if (addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book already exists.");
                    } else {
                        addressBooks.put(bookName,
                                new AddressBook(bookName));

                        System.out.println("Address Book created.");
                    }
                    break;

                // Open an existing address book
                case 2:
                    System.out.print("Enter Address Book Name: ");
                    String name = sc.nextLine();

                    AddressBook book = addressBooks.get(name);

                    if (book != null) {
                        addressBookMenu(book);
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                // UC 8: Search by City
                case 3:
                    System.out.print("Enter City: ");
                    searchAcrossBooks(sc.nextLine(), true);
                    break;

                // UC 8: Search by State
                case 4:
                    System.out.print("Enter State: ");
                    searchAcrossBooks(sc.nextLine(), false);
                    break;

                // UC 9: View persons grouped by City
                case 5:
                    viewPersonsByCityOrState(true);
                    break;

                // UC 9: View persons grouped by State
                case 6:
                    viewPersonsByCityOrState(false);
                    break;

                // UC 10: Count persons by City
                case 7:
                    countPersonsByCityOrState(true);
                    break;

                // UC 10: Count persons by State
                case 8:
                    countPersonsByCityOrState(false);
                    break;

                // Display all address book names
                case 9:
                    addressBooks.keySet()
                            .forEach(System.out::println);
                    break;

                case 10:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        sc.close();
    }
}

