package week3;

import java.util.Scanner;

public class MoneyChange {
    private static int ONECOIN = 1;
    private static int FIVECOIN = 5;
    private static int TENCOIN = 10;

    private static int getChange(int m) {
        int sum = 0;
        int coins = 0;

        while ((sum + TENCOIN) <= m) {
            sum += TENCOIN;
            coins++;
        }

        while ((sum + FIVECOIN) <= m) {
            sum += FIVECOIN;
            coins++;
        }

        while ((sum + ONECOIN) <= m) {
            sum += ONECOIN;
            coins++;
        }
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
