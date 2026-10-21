package extras.mixed;

import java.util.Scanner;

/**
 * Checks whether a number is prime.
 */
public class PrimeNumberChecker {

    /**
     * Checks whether the given number is prime.
     *
     * @param number number to check
     * @return true if prime, otherwise false
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        // Check divisors only up to the square root of the number.
        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        sc.close();
    }
}