package week1;

import java.util.Scanner;

public class MaximumPairwiseProduct {

    private static long calculatePairwiseProduct(long[] numbers) {
        int indiceMaxNumber1 = 0;
        int indiceMaxNumber2 = 0;

        if (numbers.length == 1) return numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[indiceMaxNumber1]) {
                indiceMaxNumber1 = i;
            }
        }

        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j] > numbers[indiceMaxNumber2] && j != indiceMaxNumber1 || (j == numbers.length - 1 && indiceMaxNumber1 == indiceMaxNumber2)) {
                indiceMaxNumber2 = j;
            }
        }

        return numbers[indiceMaxNumber1] * numbers[indiceMaxNumber2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }

        System.out.println(calculatePairwiseProduct(numbers));
    }
}
