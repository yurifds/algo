package algorithmictoolbox.week2;

import java.util.Scanner;

public class FibonacciHuge {

    //Number theory pisano period
    //https://www.youtube.com/watch?v=Nu-lW-Ifyec
    private static long calcPisanoPeriod(long m) {
        long a = 0;
        long b = 1;
        long c = a + b;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1)
                return i + 1; //indica que começa um novo periodo e que ja posso retornar o tamanho do periodo para o mod m, já que o tamanho de um
            //periodo é imutável.
        }
        return c;
    }

    private static Long calcFibLastDigit(Long n, Long m) {
        //Long[] numbers = new Long[n.intValue() + 1];
        //Map<Long, Long> fibMap = new HashMap<Long, Long>();
        long remainder = n % calcPisanoPeriod(m);
        if (n <= 1) return n;

        long previous = 0l;
        long current = 1l;
        long mod = remainder;

        for (long i = 1; i < remainder; i++) {
            mod = (previous + current) % m;
            previous = current;
            current = mod;
            //numbers[i] = mod;
            //fibMap.put(i, mod);
        }

        return mod % m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();
        Long m = in.nextLong();

        System.out.println(calcFibLastDigit(n, m));
    }
}
