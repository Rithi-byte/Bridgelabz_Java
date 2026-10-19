package javaMethods.level3;
import java.util.Arrays;
import java.util.Scanner;

//Created NumberCheckerPalindrome to reverse digits and check palindrome and duck numbers
public class NumberCheckerPalindrome {
    /** @param number input integer
     * @return digits from left to right */
    public static int[] getDigits(int number) {
        String text = String.valueOf(Math.abs((long) number));
        int[] digits = new int[text.length()];
        for (int i = 0; i < text.length(); i++) digits[i] = text.charAt(i) - '0';
        return digits;
    }

    /** @param digits digits array
     * @return reversed copy of the array */
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) reversed[i] = digits[digits.length - 1 - i];
        return reversed;
    }

    /** @param first first array
     * @param second second array
     * @return true if arrays contain the same elements in order */
    public static boolean areArraysEqual(int[] first, int[] second) {
        return Arrays.equals(first, second);
    }

    /** @param digits digits array
     * @return true if digits read the same forwards and backwards */
    public static boolean isPalindrome(int[] digits) {
        return areArraysEqual(digits, reverseDigits(digits));
    }

    /** @param digits digits array
     * @return true if at least one digit is non-zero, matching the worksheet definition */
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) if (digit != 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        int[] digits = getDigits(number);
        int[] reversed = reverseDigits(digits);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed digits: " + Arrays.toString(reversed));
        System.out.println("Palindrome: " + isPalindrome(digits));
        System.out.println("Duck number (worksheet definition): " + isDuckNumber(digits));
        sc.close();
    }
}
