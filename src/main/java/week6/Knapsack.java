package week6;

import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int capacity = W + 1;
        int items = w.length;
        int[][] weights = new int[items][capacity];

        for (int i = 1; i < items; i++) {
            for (int j = 1; j < capacity; j++) {
                weights[i][j] = weights[i - 1][j];
                if (w[i] <= j) {
                    int val = weights[i - 1][j - w[i]] + w[i];
                    if (weights[i][j] < val) {
                        weights[i][j] = val;
                    }
                }
            }
        }
        return weights[items - 1][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

