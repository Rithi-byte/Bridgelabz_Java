package javaCollection.hashmaps.scenarios;


import java.util.*;

public class BankingSystem {

    // HashMap stores account number and balance
    static Map<Integer, Double> accounts = new HashMap<>();

    // TreeMap stores customers sorted by balance
    static Map<Double, List<Integer>> sortedAccounts =
            new TreeMap<>();

    // Queue stores withdrawal requests
    static Queue<Integer> withdrawalQueue = new LinkedList<>();

    // Create a bank account
    public static void addAccount(int accountNumber, double balance) {

        // Check for duplicate account number
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }

        // Store account details
        accounts.put(accountNumber, balance);

        // Add account to balance-sorted map
        sortedAccounts.computeIfAbsent(
                balance, k -> new ArrayList<>()
        ).add(accountNumber);

        System.out.println("Account created successfully!");
    }

    // Display all accounts
    public static void displayAccounts() {

        System.out.println("\nAll Bank Accounts:");

        for (Map.Entry<Integer, Double> entry :
                accounts.entrySet()) {

            System.out.println(
                    "Account: " + entry.getKey() +
                            ", Balance: " + entry.getValue()
            );
        }
    }

    // Display accounts sorted by balance
    public static void displaySortedAccounts() {

        System.out.println("\nAccounts Sorted by Balance:");

        for (Map.Entry<Double, List<Integer>> entry :
                sortedAccounts.entrySet()) {

            System.out.println(
                    "Balance: " + entry.getKey() +
                            ", Accounts: " + entry.getValue()
            );
        }
    }

    // Add withdrawal request to queue
    public static void requestWithdrawal(int accountNumber) {

        if (accounts.containsKey(accountNumber)) {

            withdrawalQueue.offer(accountNumber);

            System.out.println("Withdrawal request added!");

        } else {
            System.out.println("Account not found!");
        }
    }

    // Process withdrawal requests in FIFO order
    public static void processWithdrawals(Scanner sc) {

        while (!withdrawalQueue.isEmpty()) {

            // Remove the first withdrawal request
            int accountNumber = withdrawalQueue.poll();

            System.out.println(
                    "\nProcessing account: " + accountNumber
            );

            System.out.println("Enter withdrawal amount:");
            double amount = sc.nextDouble();

            double balance = accounts.get(accountNumber);

            // Check available balance
            if (amount > 0 && balance >= amount) {

                // Remove account from old balance entry
                List<Integer> oldList = sortedAccounts.get(balance);

                oldList.remove(Integer.valueOf(accountNumber));

                if (oldList.isEmpty()) {
                    sortedAccounts.remove(balance);
                }

                // Update account balance
                double newBalance = balance - amount;

                accounts.put(accountNumber, newBalance);

                // Insert account under new balance
                sortedAccounts.computeIfAbsent(
                        newBalance, k -> new ArrayList<>()
                ).add(accountNumber);

                System.out.println("Withdrawal successful!");
                System.out.println("Remaining Balance: " + newBalance);

            } else {
                System.out.println("Insufficient balance or invalid amount!");
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get number of accounts
        System.out.println("Enter number of accounts:");
        int n = sc.nextInt();

        // Get account details
        for (int i = 0; i < n; i++) {

            System.out.println("Enter account number:");
            int accountNumber = sc.nextInt();

            System.out.println("Enter initial balance:");
            double balance = sc.nextDouble();

            addAccount(accountNumber, balance);
        }

        // Display account details
        displayAccounts();

        // Display accounts sorted by balance
        displaySortedAccounts();

        // Get withdrawal requests
        System.out.println("\nEnter number of withdrawal requests:");
        int requests = sc.nextInt();

        for (int i = 0; i < requests; i++) {

            System.out.println("Enter account number:");
            int accountNumber = sc.nextInt();

            requestWithdrawal(accountNumber);
        }

        // Process withdrawal requests
        processWithdrawals(sc);

        // Display updated account details
        System.out.println("\nUpdated Account Details:");

        displayAccounts();

        // Display updated balance sorting
        displaySortedAccounts();

        sc.close();
    }
}

