package week2;

import java.util.Scanner;

public class FibonacciLastDigit {

    private static Long calcFibLastDigit(Long n) {
        Long[] numbers = new Long[n.intValue() + 1];

        if (n <= 1) return n;

        long previous = 0l;
        long current = 1l;
        long mod;

        for (int i = 2; i <= n; i++) {
            mod = (previous + current) % 10;
            previous = current;
            current = mod;
            numbers[i] = mod;
        }

        return numbers[n.intValue()];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();

        System.out.println(calcFibLastDigit(n));
    }
}
