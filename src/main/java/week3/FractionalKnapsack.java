package week3;

import java.text.DecimalFormat;
import java.util.Scanner;

// the running time is O(n²)
// with the items sorted by the greatest vi/wi the running time is O(n log n)
public class FractionalKnapsack {

    private static double getOptimalValue(double capacity, double[] values, double[] weights, int totalItems) {
        double value = 0;

        for (int i = 0; i < totalItems; ++i) {
            if (capacity == 0) return value;

            int index = getIndexGreaterValuePerUnit(values, weights, totalItems);
            double a = Math.min(weights[index], capacity);
            double valuePerUnit = values[index] / weights[index];
            value += a * valuePerUnit;
            weights[index] -= a;
            capacity -= a;
        }

        return value;
    }

    private static int getIndexGreaterValuePerUnit(double[] values, double[] weights, int totalItems) {
        int index = 0;
        double maxValuePerUnit = 0.0;
        for (int i = 0; i < totalItems; ++i) {
            if (weights[i] > 0 && (values[i] / weights[i] > maxValuePerUnit)) {
                maxValuePerUnit = values[i] / weights[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double capacity = scanner.nextDouble();
        double[] values = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextDouble();
            weights[i] = scanner.nextDouble();
        }

        DecimalFormat df = new DecimalFormat("#.0000");
        System.out.println(df.format(getOptimalValue(capacity, values, weights, n)));
    }
}
