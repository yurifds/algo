package algorithmictoolbox.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.min;

public class PrimitiveCalculator {
    private static List<Integer> optimalSequence(int n) {
        List<Integer> sequence = new ArrayList<>();

        int[] cache = new int[n + 1];

        for (int i = 1; i < cache.length; i++) {
            cache[i] = cache[i - 1] + 1;
            if (i % 2 == 0) cache[i] = min(1 + cache[i / 2], cache[i]);
            if (i % 3 == 0) cache[i] = min(1 + cache[i / 3], cache[i]);
        }

        for (int i = n; i > 1; ) {
            sequence.add(i);
            if (cache[i - 1] == cache[i] - 1)
                i = i - 1;
            else if (i % 2 == 0 && (cache[i / 2] == cache[i] - 1))
                i = i / 2;
            else if (i % 3 == 0 && (cache[i / 3] == cache[i] - 1))
                i = i / 3;
        }
        sequence.add(1);

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

