package javaMethods.level3;
import java.util.Scanner;

//Created NumberCheckerFactors to analyze factors and special factor-based numbers
public class NumberCheckerFactors {
    /** @param number positive integer
     * @return array of all factors, or empty array for non-positive input */
    public static int[] findFactors(int number) {
        if (number <= 0) return new int[0];
        int count = 0;
        for (int i = 1; i <= number; i++) if (number % i == 0) count++;
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) if (number % i == 0) factors[index++] = i;
        return factors;
    }

    /** @param factors factors array
     * @return greatest factor */
    public static int findGreatestFactor(int[] factors) {
        int greatest = 0;
        for (int factor : factors) if (factor > greatest) greatest = factor;
        return greatest;
    }

    /** @param factors factors array
     * @return sum of proper factors, excluding the number itself */
    public static long findSumOfProperFactors(int[] factors) {
        long sum = 0;
        for (int factor : factors) if (factors.length > 1 && factor != factors[factors.length - 1]) sum += factor;
        return sum;
    }

    /** @param factors factors array
     * @return product of all factors */
    public static long findProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) product *= factor;
        return product;
    }

    /** @param factors factors array
     * @return sum of cubes of all factors (wording interpreted as sum of cubes) */
    public static double findSumOfCubes(int[] factors) {
        double sum = 0;
        for (int factor : factors) sum += Math.pow(factor, 3);
        return sum;
    }

    /** @param number number being checked
     * @param factors its factors
     * @return true if sum of proper factors equals number */
    public static boolean isPerfect(int number, int[] factors) {
        return number > 0 && findSumOfProperFactors(factors) == number;
    }

    /** @param number number being checked
     * @param factors its factors
     * @return true if sum of proper factors exceeds number */
    public static boolean isAbundant(int number, int[] factors) {
        return number > 0 && findSumOfProperFactors(factors) > number;
    }

    /** @param number number being checked
     * @param factors its factors
     * @return true if sum of proper factors is less than number */
    public static boolean isDeficient(int number, int[] factors) {
        return number > 0 && findSumOfProperFactors(factors) < number;
    }

    /** @param number input number
     * @return true if sum of digit factorials equals number */
    public static boolean isStrong(int number) {
        if (number < 0) return false;
        int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        int temp = number;
        long sum = 0;
        do { sum += factorials[temp % 10]; temp /= 10; } while (temp > 0);
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Enter a positive integer.");
            sc.close();
            return;
        }
        int[] factors = findFactors(number);
        System.out.println("Factors: " + java.util.Arrays.toString(factors));
        System.out.println("Greatest factor: " + findGreatestFactor(factors));
        System.out.println("Sum of proper factors: " + findSumOfProperFactors(factors));
        System.out.println("Product of factors: " + findProduct(factors));
        System.out.println("Sum of cubes of factors: " + findSumOfCubes(factors));
        System.out.println("Perfect: " + isPerfect(number, factors));
        System.out.println("Abundant: " + isAbundant(number, factors));
        System.out.println("Deficient: " + isDeficient(number, factors));
        System.out.println("Strong: " + isStrong(number));
        sc.close();
    }
}
