package javaMethods.level3;
import java.util.Scanner;

//Created NumberCheckerSpecialNumbers to check prime, neon, spy, automorphic and buzz numbers
public class NumberCheckerSpecialNumbers {
    /** @param number input integer
     * @return true if number is prime */
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= number / i; i++) if (number % i == 0) return false;
        return true;
    }

    /** @param number input integer
     * @return true if sum of square's digits equals number */
    public static boolean isNeon(int number) {
        if (number < 0) return false;
        long square = (long) number * number;
        int sum = 0;
        do { sum += square % 10; square /= 10; } while (square > 0);
        return sum == number;
    }

    /** @param number input integer
     * @return true if digit sum equals digit product */
    public static boolean isSpy(int number) {
        if (number < 0) return false;
        int sum = 0, product = 1, temp = number;
        do { int digit = temp % 10; sum += digit; product *= digit; temp /= 10; }
        while (temp > 0);
        return sum == product;
    }

    /** @param number input integer
     * @return true if its square ends with the number */
    public static boolean isAutomorphic(int number) {
        if (number < 0) return false;
        long square = (long) number * number;
        long divisor = 1, temp = number;
        do { divisor *= 10; temp /= 10; } while (temp > 0);
        return square % divisor == number;
    }

    /** @param number input integer
     * @return true if divisible by 7 or ends with 7 */
    public static boolean isBuzz(int number) {
        return number >= 0 && (number % 7 == 0 || number % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int number = sc.nextInt();
        System.out.println("Prime: " + isPrime(number));
        System.out.println("Neon: " + isNeon(number));
        System.out.println("Spy: " + isSpy(number));
        System.out.println("Automorphic: " + isAutomorphic(number));
        System.out.println("Buzz: " + isBuzz(number));
        sc.close();
    }
}
