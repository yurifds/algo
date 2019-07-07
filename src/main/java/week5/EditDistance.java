package week5;

import java.util.Scanner;

//Edit distance/Levenshtein distance
class EditDistance {
    public static int EditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] d = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) d[0][j] = j; //fill colunms

        for (int i = 0; i <= m; i++) d[i][0] = i; //fill lines

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                int insertion = d[i][j - 1] + 1;
                int deletion = d[i - 1][j] + 1;
                int match = d[i - 1][j - 1];
                int mismatch = d[i - 1][j - 1] + 1;

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    d[i][j] = Math.min(Math.min(insertion, deletion), match);
                } else {
                    d[i][j] = Math.min(Math.min(insertion, deletion), mismatch);
                }
            }
        }

        return d[m][n];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
