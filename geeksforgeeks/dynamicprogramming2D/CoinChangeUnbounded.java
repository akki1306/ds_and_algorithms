package geeksforgeeks.dynamicprogramming2D;

import java.util.Arrays;

public class CoinChangeUnbounded {
    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3}, 3, 4));
    }

    public static long count(int S[], int m, int n) {
        long[][] dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countRecursive(S, n, m, dp);
    }

    private static long countRecursive(int[] S, int n, int m, long[][] dp) {
        if (n < 0)
            return 0;

        if (n == 0)
            return 1;

        if (m <= 0)
            return 0;

        if (dp[n - 1][m - 1] != -1)
            return dp[n - 1][m - 1];

        dp[n - 1][m - 1] = (countRecursive(S, n - S[m - 1], m, dp) + countRecursive(S, n, m - 1, dp));
        return dp[n - 1][m - 1];
    }
}
