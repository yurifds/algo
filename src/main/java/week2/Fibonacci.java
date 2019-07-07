package week2;

import java.util.Scanner;

public class Fibonacci {

    private static long calc_fib(Long n) {
        long[] numbers = new long[n.intValue() + 1];

        if (n == 0 || n == 1) return n;

        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        return numbers[n.intValue()];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();

        System.out.println(calc_fib(n));

    }
}
