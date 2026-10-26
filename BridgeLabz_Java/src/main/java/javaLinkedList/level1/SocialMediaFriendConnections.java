package javaLinkedList.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 7. Singly Linked List: Social Media Friend Connections
 *
 * Problem Statement:
 * Create a system to manage social media friend connections
 * using a singly linked list.
 *
 * Each user contains:
 * User ID, Name, Age, and List of Friend IDs.
 *
 * Functionalities:
 * 1. Add a friend connection between two users.
 * 2. Remove a friend connection.
 * 3. Find mutual friends between two users.
 * 4. Display all friends of a specific user.
 * 5. Search for a user by Name or User ID.
 * 6. Count the number of friends for each user.
 */

// Represents a social media user.
class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;

    // Initializes a user with no friends.
    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }

    // Displays the user's details.
    void display() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Friend IDs: " + friendIds);
        System.out.println("Number of Friends: " + friendIds.size());
        System.out.println("-----------------------------");
    }
}

// Represents a node in the singly linked list.
class UserNode {
    User data;
    UserNode next;

    // Creates a node containing a user.
    UserNode(User data) {
        this.data = data;
        this.next = null;
    }
}

public class SocialMediaFriendConnections {

    // Head points to the first user in the linked list.
    UserNode head;

    /**
     * Adds a new user to the end of the linked list.
     */
    void addUser(User user) {

        // Prevent duplicate user IDs.
        if (findUserById(user.userId) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        UserNode newNode = new UserNode(user);

        // If the list is empty, the new node becomes head.
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the last node.
            UserNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            // Append the new user.
            current.next = newNode;
        }

        System.out.println("User added successfully.");
    }

    /**
     * Finds and returns a user using their ID.
     * Returns null if the user does not exist.
     */
    User findUserById(int userId) {
        UserNode current = head;

        // Traverse the linked list to find the matching ID.
        while (current != null) {
            if (current.data.userId == userId) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    /**
     * Adds a mutual friend connection between two users.
     */
    void addFriendConnection(int userId1, int userId2) {

        // Find both users.
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        // Both users must exist.
        if (user1 == null || user2 == null) {
            System.out.println("One or both users do not exist.");
            return;
        }

        // A user cannot be friends with themselves.
        if (userId1 == userId2) {
            System.out.println("A user cannot be their own friend.");
            return;
        }

        // Prevent duplicate friend connections.
        if (user1.friendIds.contains(userId2)) {
            System.out.println("Friend connection already exists.");
            return;
        }

        // Add each user to the other's friend list.
        user1.friendIds.add(userId2);
        user2.friendIds.add(userId1);

        System.out.println("Friend connection added successfully.");
    }

    /**
     * Removes the connection between two users.
     */
    void removeFriendConnection(int userId1, int userId2) {

        // Find both users.
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        // Both users must exist.
        if (user1 == null || user2 == null) {
            System.out.println("One or both users do not exist.");
            return;
        }

        // Remove the connection from both friend lists.
        boolean removed1 = user1.friendIds.remove(
                Integer.valueOf(userId2));

        boolean removed2 = user2.friendIds.remove(
                Integer.valueOf(userId1));

        if (removed1 || removed2) {
            System.out.println("Friend connection removed successfully.");
        } else {
            System.out.println("Friend connection does not exist.");
        }
    }

    /**
     * Displays all friends of a specific user.
     */
    void displayFriends(int userId) {

        // Find the requested user.
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");

        // Handle users who have no friends.
        if (user.friendIds.isEmpty()) {
            System.out.println("This user has no friends.");
            return;
        }

        // Find and display each friend using their ID.
        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);

            if (friend != null) {
                System.out.println(
                        "ID: " + friend.userId
                                + ", Name: " + friend.name
                                + ", Age: " + friend.age
                );
            }
        }
    }

    /**
     * Finds mutual friends between two users.
     */
    void findMutualFriends(int userId1, int userId2) {

        // Find both users.
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users do not exist.");
            return;
        }

        boolean found = false;

        System.out.println(
                "Mutual friends of " + user1.name
                        + " and " + user2.name + ":"
        );

        // A mutual friend appears in both friend lists.
        for (int friendId : user1.friendIds) {

            if (user2.friendIds.contains(friendId)) {
                User mutualFriend = findUserById(friendId);

                if (mutualFriend != null) {
                    System.out.println(
                            "ID: " + mutualFriend.userId
                                    + ", Name: " + mutualFriend.name
                    );

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No mutual friends found.");
        }
    }

    /**
     * Searches for a user by name.
     * Multiple users may have the same name.
     */
    void searchByName(String name) {
        UserNode current = head;
        boolean found = false;

        // Traverse the list and display matching names.
        while (current != null) {

            if (current.data.name.equalsIgnoreCase(name)) {
                current.data.display();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    /**
     * Displays information about a user by ID.
     */
    void searchByUserId(int userId) {

        // Reuse the ID lookup method.
        User user = findUserById(userId);

        if (user != null) {
            System.out.println("User found:");
            user.display();
        } else {
            System.out.println("User not found.");
        }
    }

    /**
     * Counts and displays the number of friends for each user.
     */
    void countFriendsForEachUser() {

        // Handle an empty user list.
        if (head == null) {
            System.out.println("No users available.");
            return;
        }

        UserNode current = head;

        // Visit each user and count their friend IDs.
        while (current != null) {
            System.out.println(
                    "User: " + current.data.name
                            + " (ID: " + current.data.userId + ")"
                            + " | Friends: " + current.data.friendIds.size()
            );

            current = current.next;
        }
    }

    /**
     * Displays all users in the linked list.
     */
    void displayAllUsers() {

        if (head == null) {
            System.out.println("No users available.");
            return;
        }

        UserNode current = head;

        // Traverse and display every user.
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }

    /**
     * Main method: displays the menu and accepts user input.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SocialMediaFriendConnections system =
                new SocialMediaFriendConnections();

        int choice;

        // Repeat until the user chooses to exit.
        do {
            System.out.println("\n===== Social Media Friend Connections =====");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends of a User");
            System.out.println("6. Search User by Name");
            System.out.println("7. Search User by ID");
            System.out.println("8. Count Friends for Each User");
            System.out.println("9. Display All Users");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    // Read the new user's details.
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (age < 0) {
                        System.out.println("Age cannot be negative.");
                        break;
                    }

                    // Create and add the new user.
                    User user = new User(userId, name, age);
                    system.addUser(user);
                    break;
                }

                case 2:
                    System.out.print("Enter First User ID: ");
                    int id1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();

                    system.addFriendConnection(id1, id2);
                    break;

                case 3:
                    System.out.print("Enter First User ID: ");
                    int removeId1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    int removeId2 = sc.nextInt();
                    sc.nextLine();

                    system.removeFriendConnection(
                            removeId1, removeId2);
                    break;

                case 4:
                    System.out.print("Enter First User ID: ");
                    int mutualId1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    int mutualId2 = sc.nextInt();
                    sc.nextLine();

                    system.findMutualFriends(mutualId1, mutualId2);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    system.displayFriends(sc.nextInt());
                    sc.nextLine();
                    break;

                case 6:
                    System.out.print("Enter Name: ");
                    system.searchByName(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter User ID: ");
                    system.searchByUserId(sc.nextInt());
                    sc.nextLine();
                    break;

                case 8:
                    system.countFriendsForEachUser();
                    break;

                case 9:
                    system.displayAllUsers();
                    break;

                case 10:
                    System.out.println("Exiting Social Media System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 10);

        sc.close();
    }
}