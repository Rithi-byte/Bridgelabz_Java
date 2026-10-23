package thisstaticfinalinstanceof.level1;
import java.util.Scanner;

class BankAccount {
    static String bankName = "SBI";
    static int totalAccounts = 0;

    String accountHolderName;
    final long accountNumber;

    BankAccount(String accountHolderName, long accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        long number = sc.nextLong();

        BankAccount account = new BankAccount(name, number);

        Object obj = account;
        if (obj instanceof BankAccount) {
            ((BankAccount) obj).displayDetails();
        }

        getTotalAccounts();
        sc.close();
    }
}