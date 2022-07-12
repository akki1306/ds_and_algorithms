package dynamicprogramming2D;

import java.util.Arrays;

public class MixturesSPOJ {
    public static void main(String[] args) {
        int[][] dp = new int[500][500];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(mixtures(new int[]{40, 60, 20}, 0, 2, dp));
    }

    private static int mixtures(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], mixtures(arr, i, k, dp) + mixtures(arr, k + 1, j, dp) + sum(arr, i, k) * sum(arr, k + 1, j));
        }

        return dp[i][j];
    }

    private static int sum(int[] arr, int i, int j) {
        int ans = 0;
        for (int n = i; n <= j; n++) {
            ans += arr[n];
            ans %= 100;
        }
        return ans;
    }
}
