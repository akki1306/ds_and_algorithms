package dynamicprogramming2D;

import java.util.Arrays;

public class SellingWines {
    public static void main(String[] args) {
        System.out.println(sellingWinesRecursive(new int[]{2, 3, 5, 1, 4}, 1, 1, 5));
        int[][] dp = new int[6][6];
        for (int i = 0; i < 6; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(sellingWinesRecursiveMemoization(new int[]{2, 3, 5, 1, 4}, 1, 1, 5, dp));
        System.out.println(sellingWinesDp(new int[]{2, 3, 5, 1, 4}));
    }

    private static int sellingWinesRecursive(int[] arr, int year, int i, int j) {
        if (i == j)
            return arr[i - 1] * year;

        int a = year * arr[i - 1] + sellingWinesRecursive(arr, year + 1, i + 1, j);
        int b = year * arr[j - 1] + sellingWinesRecursive(arr, year + 1, i, j - 1);
        int max = Math.max(a, b);
        return max;
    }

    private static int sellingWinesRecursiveMemoization(int[] arr, int year, int i, int j, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int a = year * arr[i - 1] + sellingWinesRecursive(arr, year + 1, i + 1, j);
        int b = year * arr[j - 1] + sellingWinesRecursive(arr, year + 1, i, j - 1);
        int max = Math.max(a, b);
        dp[i][j] = max;
        return max;
    }

    private static int sellingWinesDp(int[] arr) {
        int N = arr.length;
        int[][] dp = new int[N+1][N+1];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 1; j < N; j++) {
                if (i <= j) {
                    // year
                    int year = N - (j - i);
                    int pick_left = year * arr[i] + dp[i + 1][j];
                    int pick_right = year * arr[j] + dp[i][j - 1];
                    dp[i][j] = Math.max(pick_left, pick_right);
                }
            }
        }
        return dp[0][N-1];
    }
}
