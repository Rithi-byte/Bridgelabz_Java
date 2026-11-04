
package javaGenerics;

import java.util.ArrayList;
import java.util.Scanner;

// 1. Created Mealplan: Interface for all meal categories.
// Purpose: Defines common methods that every meal category must implement.
// Special: Provides a common contract for Vegetarian, Vegan, Keto,
// and High Protein meal classes.
interface Mealplan {

    String mealType();

    void food();
}

// 2. Created VegetarianMeal: Represents a vegetarian meal category.
// Purpose: Provides vegetarian meal details.
// Special: Implements Mealplan and overrides its abstract methods.
class VegetarianMeal implements Mealplan {

    @Override
    public String mealType() {
        return "Vegetarian Meal";
    }

    @Override
    public void food() {
        System.out.println("Paneer curry with rice, vegetable salad, and curd");
    }
}

// 3. Created VeganMeal: Represents a vegan meal category.
// Purpose: Provides plant-based meal details.
// Special: Implements Mealplan and provides a vegan food plan.
class VeganMeal implements Mealplan {

    @Override
    public String mealType() {
        return "Vegan Meal";
    }

    @Override
    public void food() {
        System.out.println("Quinoa or lentil salad with chickpeas, avocado, and mixed greens");
    }
}

// 4. Created KetoMeal: Represents a keto meal category.
// Purpose: Provides a low-carbohydrate meal option.
// Special: Implements Mealplan and provides a keto food plan.
class KetoMeal implements Mealplan {

    @Override
    public String mealType() {
        return "Keto Meal";
    }

    @Override
    public void food() {
        System.out.println("Grilled paneer with avocado, spinach, and broccoli");
    }
}

// 5. Created HighProteinMeal: Represents a high-protein meal category.
// Purpose: Provides a protein-rich meal option.
// Special: Implements Mealplan and provides a high-protein food plan.
class HighProteinMeal implements Mealplan {

    @Override
    public String mealType() {
        return "High Protein Meal";
    }

    @Override
    public void food() {
        System.out.println("Grilled chicken with boiled eggs, lentils, and vegetables");
    }
}

// 6. Created Meal<T>: Represents an individual user's meal plan.
// Purpose: Stores meal details such as ID, username, and meal category.
// Special: Uses a Generic Class with bounded type parameter
// T extends Mealplan, ensuring only valid meal categories are accepted.
class Meal<T extends Mealplan> {

    // Static counter shared by all Meal objects for unique ID generation.
    static int counter = 100;

    int mealId;
    String userName;
    T mealPlan;

    // Constructor initializes meal details and automatically generates ID.
    Meal(String userName, T mealPlan) {

        this.mealId = ++counter;
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    // Displays the user's meal plan details.
    void display() {

        System.out.println("\nMeal ID: " + mealId);
        System.out.println("User Name: " + userName);
        System.out.println("Meal Category: " + mealPlan.mealType());

        System.out.print("Food Plan: ");
        mealPlan.food();
    }
}

// 7. Created MealPlanGenerator: Manages and generates personalized meal plans.
// Purpose: Stores different meal plans and generates plans for users.
// Special: Uses a Generic Method with bounded type parameter
// <T extends Mealplan> to accept any valid meal category.
// Also uses ArrayList<Meal<?>> to store different meal types together.
class MealPlanGenerator {

    // Stores meal objects belonging to different meal categories.
    // ? allows any valid Meal category to be stored.
    ArrayList<Meal<?>> mealList = new ArrayList<>();

    // Generic method to validate and generate meal plans.
    // T extends Mealplan ensures only objects implementing Mealplan are accepted.
    <T extends Mealplan> void generateMeal(String userName, T plan) {

        // Validates whether the given meal plan is null.
        if (plan == null) {
            System.out.println("Invalid meal plan!");
            return;
        }

        // Creates a generic Meal object using the received meal category.
        Meal<T> meal = new Meal<>(userName, plan);

        // Adds the generated meal to the common collection.
        mealList.add(meal);

        System.out.println("\nMeal plan generated successfully!");

        // Displays the generated meal plan.
        meal.display();
    }

    // Displays all generated meal plans regardless of their category.
    void displayAllMeals() {

        // Checks whether the collection is empty.
        if (mealList.isEmpty()) {
            System.out.println("No meal plans available!");
            return;
        }

        // Iterates through different Meal types using a wildcard.
        for (Meal<?> meal : mealList) {
            meal.display();
        }
    }
}

// 8. Created PersonalizedMealPlanGenerator: Main class of the application.
// Purpose: Accepts user input and allows users to generate meal plans.
// Special: Uses Scanner and a menu-driven switch statement to select
// different meal categories and interact with MealPlanGenerator.
public class PersonalizedMealPlanGenerator {

    public static void main(String[] args) {

        // Scanner object to accept user input.
        Scanner sc = new Scanner(System.in);

        // Creating MealPlanGenerator object to manage meal plans.
        MealPlanGenerator generator = new MealPlanGenerator();

        int choice;

        // Menu-driven application continues until the user exits.
        do {

            System.out.println("\n===== PERSONALIZED MEAL PLAN GENERATOR =====");

            System.out.println("1. Vegetarian Meal");
            System.out.println("2. Vegan Meal");
            System.out.println("3. Keto Meal");
            System.out.println("4. High Protein Meal");
            System.out.println("5. Display All Meal Plans");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Creates a Vegetarian meal plan.
                case 1: {

                    System.out.print("Enter your name: ");
                    String name = sc.next();

                    // Passes VegetarianMeal object to the generic method.
                    generator.generateMeal(name, new VegetarianMeal());
                    break;
                }

                // Creates a Vegan meal plan.
                case 2: {

                    System.out.print("Enter your name: ");
                    String name = sc.next();

                    // Passes VeganMeal object to the generic method.
                    generator.generateMeal(name, new VeganMeal());
                    break;
                }

                // Creates a Keto meal plan.
                case 3: {

                    System.out.print("Enter your name: ");
                    String name = sc.next();

                    // Passes KetoMeal object to the generic method.
                    generator.generateMeal(name, new KetoMeal());
                    break;
                }

                // Creates a High Protein meal plan.
                case 4: {

                    System.out.print("Enter your name: ");
                    String name = sc.next();

                    // Passes HighProteinMeal object to the generic method.
                    generator.generateMeal(name, new HighProteinMeal());
                    break;
                }

                // Displays all previously generated meal plans.
                case 5:

                    System.out.println("\n===== ALL GENERATED MEAL PLANS =====");

                    generator.displayAllMeals();
                    break;

                // Exits the application.
                case 6:

                    System.out.println("Exiting Meal Plan Generator...");
                    break;

                // Handles invalid menu choices.
                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        // Closes Scanner after execution.
        sc.close();
    }
}
