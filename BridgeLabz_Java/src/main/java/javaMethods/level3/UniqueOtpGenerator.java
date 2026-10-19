package javaMethods.level3;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Created UniqueOtpGenerator to generate ten unique six-digit OTPs
public class UniqueOtpGenerator {
    /** @return a random six-digit OTP */
    public static int generateOtp() {
        return (int) (Math.random() * 900000) + 100000;
    }

    /** @param otps OTP array
     * @return true if all OTPs are unique */
    public static boolean areOtpsUnique(int[] otps) {
        Set<Integer> unique = new HashSet<>();
        for (int otp : otps) if (!unique.add(otp)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] otps = new int[10];

        // Generate each OTP, retrying if it already exists
        Set<Integer> generated = new HashSet<>();
        for (int i = 0; i < otps.length; i++) {
            int otp;
            do { otp = generateOtp(); } while (generated.contains(otp));
            otps[i] = otp;
            generated.add(otp);
        }

        for (int i = 0; i < otps.length; i++) {
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        System.out.println("All OTPs are unique: " + areOtpsUnique(otps));
        sc.close();
    }
}
