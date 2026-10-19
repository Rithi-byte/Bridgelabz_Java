package javaMethods.level3;
import java.util.Arrays;
import java.util.Scanner;

//Created NumberCheckerDigitStats to calculate digit sums and frequencies
public class NumberCheckerDigitStats {
    /** @param number input integer
     * @return digits from left to right */
    public static int[] getDigits(int number) {
        String text = String.valueOf(Math.abs((long) number));
        int[] digits = new int[text.length()];
        for (int i = 0; i < text.length(); i++) digits[i] = text.charAt(i) - '0';
        return digits;
    }

    /** @param digits digits array
     * @return sum of digits */
    public static int findSum(int[] digits) {
        int sum = 0;
        for (int digit : digits) sum += digit;
        return sum;
    }

    /** @param digits digits array
     * @return sum of squared digits */
    public static double findSumOfSquares(int[] digits) {
        double sum = 0;
        for (int digit : digits) sum += Math.pow(digit, 2);
        return sum;
    }

    /** @param number original number
     * @param digits digits array
     * @return true if number is divisible by its digit sum */
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = findSum(digits);
        return number > 0 && sum != 0 && number % sum == 0;
    }

    /** @param digits digits array
     * @return 2D array where column 0 is digit and column 1 is frequency */
    public static int[][] findDigitFrequency(int[] digits) {
        int[] counts = new int[10];
        for (int digit : digits) counts[digit]++;
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = counts[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        int[] digits = getDigits(number);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Sum: " + findSum(digits));
        System.out.println("Sum of squares: " + findSumOfSquares(digits));
        System.out.println("Harshad number: " + isHarshadNumber(number, digits));
        System.out.println("Digit frequencies (digit : count):");
        for (int[] row : findDigitFrequency(digits)) {
            if (row[1] > 0) System.out.println(row[0] + " : " + row[1]);
        }
        sc.close();
    }
}
