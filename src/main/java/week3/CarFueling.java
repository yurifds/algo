package week3;

import java.util.Scanner;

public class CarFueling {
    private static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int currentRefill = 0;
        int lastRefill = 0;
        stops[stops.length - 1] = dist;

        while (currentRefill < stops.length - 1) {
            lastRefill = currentRefill;

            while (currentRefill < stops.length - 1 && stops[currentRefill + 1] - stops[lastRefill] <= tank) {
                currentRefill++;
            }

            if (currentRefill == lastRefill) {
                return -1;
            }

            if (currentRefill < stops.length - 1) {
                numRefills++;
            }
        }

        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt() + 2;
        int stops[] = new int[n];
        for (int i = 1; i < n - 1; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
