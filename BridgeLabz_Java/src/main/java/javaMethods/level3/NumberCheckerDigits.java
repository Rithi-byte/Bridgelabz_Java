package javaMethods.level3;
import java.util.Arrays;
import java.util.Scanner;

//Created NumberCheckerDigits to analyze digits, Armstrong and duck numbers
public class NumberCheckerDigits {
    /** @param number input integer
     * @return number of digits */
    public static int countDigits(int number) {
        return String.valueOf(Math.abs((long) number)).length();
    }

    /** @param number input integer
     * @return digits from left to right */
    public static int[] getDigits(int number) {
        String value = String.valueOf(Math.abs((long) number));
        int[] digits = new int[value.length()];
        for (int i = 0; i < value.length(); i++) digits[i] = value.charAt(i) - '0';
        return digits;
    }

    /** @param digits digits array
     * @return true if at least one digit is non-zero, as specified in the worksheet */
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) if (digit != 0) return true;
        return false;
    }

    /** @param digits digits array
     * @return true if number equals the sum of each digit raised to digit count */
    public static boolean isArmstrongNumber(int[] digits) {
        long sum = 0;
        for (int digit : digits) sum += (long) Math.pow(digit, digits.length);
        long number = 0;
        for (int digit : digits) number = number * 10 + digit;
        return sum == number;
    }

    /** @param digits digits array
     * @return array {largest, secondLargest}; distinct values are used */
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) { second = largest; largest = digit; }
            else if (digit > second && digit < largest) second = digit;
        }
        return new int[]{largest, second};
    }

    /** @param digits digits array
     * @return array {smallest, secondSmallest}; distinct values are used */
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) { second = smallest; smallest = digit; }
            else if (digit < second && digit > smallest) second = digit;
        }
        return new int[]{smallest, second};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        int[] digits = getDigits(number);
        int[] largest = findLargestAndSecondLargest(digits);
        int[] smallest = findSmallestAndSecondSmallest(digits);
        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck number (worksheet definition): " + isDuckNumber(digits));
        System.out.println("Armstrong number: " + isArmstrongNumber(digits));
        System.out.println("Largest, second largest: " + Arrays.toString(largest));
        System.out.println("Smallest, second smallest: " + Arrays.toString(smallest));
        if (largest[1] == Integer.MIN_VALUE) System.out.println("No second-largest distinct digit.");
        if (smallest[1] == Integer.MAX_VALUE) System.out.println("No second-smallest distinct digit.");
        sc.close();
    }
}
