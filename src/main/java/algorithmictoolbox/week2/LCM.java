package algorithmictoolbox.week2;

import java.util.Scanner;

public class LCM {

    private static long calculateGcd(long a, long b) {
        long remainder = 0;

        if (b == 0) {
            return a;
        }

        remainder = a % b;

        return calculateGcd(b, remainder);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long a = scanner.nextLong();
        Long b = scanner.nextLong();

        System.out.println((a * b) / calculateGcd(a, b));
    }
}
