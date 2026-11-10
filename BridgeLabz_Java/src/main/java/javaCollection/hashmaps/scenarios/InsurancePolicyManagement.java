package javaCollection.hashmaps.scenarios;


import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class InsurancePolicy {

    // Policy attributes
    private int policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor
    public InsurancePolicy(int policyNumber, String policyholderName,
                           LocalDate expiryDate, String coverageType,
                           double premiumAmount) {

        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getter methods
    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    // Override equals() to identify duplicate policy numbers
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof InsurancePolicy))
            return false;

        InsurancePolicy other = (InsurancePolicy) obj;

        return this.policyNumber == other.policyNumber;
    }

    // Override hashCode() consistently with equals()
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Display policy details
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
                ", Name: " + policyholderName +
                ", Expiry Date: " + expiryDate +
                ", Coverage: " + coverageType +
                ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagement {

    // Different Set implementations
    static Set<InsurancePolicy> hashSet = new HashSet<>();

    static Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();

    // TreeSet sorts policies according to expiry date.
    // Policy number is used to break ties and preserve unique policies.
    static Set<InsurancePolicy> treeSet = new TreeSet<>(
            Comparator.comparing(InsurancePolicy::getExpiryDate)
                    .thenComparingInt(InsurancePolicy::getPolicyNumber)
    );

    // Add policy to all three sets
    public static void addPolicy(InsurancePolicy p) {

        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);

        System.out.println("Policy added successfully!");
    }

    // Display all unique policies
    public static void displayAllPolicies() {

        System.out.println("\n--- All Unique Policies ---");

        for (InsurancePolicy p : hashSet) {
            System.out.println(p);
        }
    }

    // Display policies expiring within the next 30 days
    public static void expiringSoon() {

        System.out.println("\n--- Policies Expiring Within 30 Days ---");

        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (InsurancePolicy p : hashSet) {

            if (!p.getExpiryDate().isBefore(today) &&
                    !p.getExpiryDate().isAfter(limit)) {

                System.out.println(p);
            }
        }
    }

    // Display policies based on coverage type
    public static void searchByCoverage(String type) {

        System.out.println("\n--- Policies with Coverage: " + type + " ---");

        for (InsurancePolicy p : hashSet) {

            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // Detect duplicate policies based on policy number
    public static void detectDuplicate(InsurancePolicy p) {

        if (hashSet.contains(p)) {
            System.out.println("Duplicate policy found: " +
                    p.getPolicyNumber());
        } else {
            System.out.println("Policy number is unique.");
        }
    }

    // Display policies in insertion order
    public static void displayInsertionOrder() {

        System.out.println("\n--- Insertion Order ---");

        for (InsurancePolicy p : linkedHashSet) {
            System.out.println(p);
        }
    }

    // Display policies sorted by expiry date
    public static void displaySortedPolicies() {

        System.out.println("\n--- Policies Sorted by Expiry Date ---");

        for (InsurancePolicy p : treeSet) {
            System.out.println(p);
        }
    }

    // Remove a policy from all three sets
    public static void removePolicy(int policyNumber) {

        InsurancePolicy temp = new InsurancePolicy(
                policyNumber, "", LocalDate.now(), "", 0
        );

        hashSet.remove(temp);
        linkedHashSet.remove(temp);
        treeSet.remove(temp);

        System.out.println("Policy removed successfully!");
    }

    // Compare performance of adding, searching and removing
    public static void performanceComparison() {

        Set<InsurancePolicy>[] sets = new Set[] {
                new HashSet<>(),
                new LinkedHashSet<>(),
                new TreeSet<>(
                        Comparator.comparing(InsurancePolicy::getExpiryDate)
                                .thenComparingInt(InsurancePolicy::getPolicyNumber)
                )
        };

        String[] names = {
                "HashSet", "LinkedHashSet", "TreeSet"
        };

        int n = 10000;

        List<InsurancePolicy> policies = new ArrayList<>();

        // Generate sample policies
        for (int i = 1; i <= n; i++) {

            policies.add(new InsurancePolicy(
                    i,
                    "User" + i,
                    LocalDate.now().plusDays(i % 365),
                    "Health",
                    5000 + i
            ));
        }

        // Test each set separately
        for (int i = 0; i < sets.length; i++) {

            Set<InsurancePolicy> set = sets[i];

            // Measure insertion time
            long start = System.nanoTime();

            for (InsurancePolicy p : policies) {
                set.add(p);
            }

            long addTime = System.nanoTime() - start;

            // Measure searching time
            InsurancePolicy search = policies.get(n / 2);

            start = System.nanoTime();

            set.contains(search);

            long searchTime = System.nanoTime() - start;

            // Measure removal time
            start = System.nanoTime();

            set.remove(search);

            long removeTime = System.nanoTime() - start;

            System.out.println("\n" + names[i]);

            System.out.println("Add Time: " + addTime + " ns");
            System.out.println("Search Time: " + searchTime + " ns");
            System.out.println("Remove Time: " + removeTime + " ns");
        }
    }

    // Main method
    public static void main(String[] args) {

        // Create sample insurance policies
        InsurancePolicy p1 = new InsurancePolicy(
                101, "Ravi", LocalDate.now().plusDays(10),
                "Health", 5000
        );

        InsurancePolicy p2 = new InsurancePolicy(
                102, "Priya", LocalDate.now().plusDays(45),
                "Auto", 7000
        );

        InsurancePolicy p3 = new InsurancePolicy(
                103, "Arun", LocalDate.now().plusDays(20),
                "Home", 6000
        );

        InsurancePolicy p4 = new InsurancePolicy(
                104, "Kumar", LocalDate.now().plusDays(5),
                "Health", 4500
        );

        // Add policies
        addPolicy(p1);
        addPolicy(p2);
        addPolicy(p3);
        addPolicy(p4);

        // Attempt to add duplicate policy number
        InsurancePolicy duplicate = new InsurancePolicy(
                101, "Ravi Kumar", LocalDate.now().plusDays(60),
                "Auto", 8000
        );

        addPolicy(duplicate);

        // Display all unique policies
        displayAllPolicies();

        // Display insertion order
        displayInsertionOrder();

        // Display sorted policies
        displaySortedPolicies();

        // Find policies expiring soon
        expiringSoon();

        // Search by coverage type
        searchByCoverage("Health");

        // Detect duplicate policy number
        detectDuplicate(duplicate);

        // Remove a policy
        removePolicy(102);

        // Performance comparison
        performanceComparison();
    }
}
