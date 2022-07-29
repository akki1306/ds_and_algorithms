package udemy.dynamicprogramming1D;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        System.out.println(rodCuttingProblemRecursive(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8));
        int[] cache = new int[8];
        Arrays.fill(cache, -1);
        System.out.println(rodCuttingProblemRecursiveMemoization(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8, cache));
        System.out.println(rodCuttingProblemDp(new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 8));
    }

    private static int rodCuttingProblemRecursive(int[] price, int N) {
        if (N < 0)
            return 0;

        if (N == 0)
            return 0;

        int maxProfit = 0;
        for (int j = 1; j <= price.length; j++) {
            if ((N - j) >= 0) {
                int remaining = rodCuttingProblemRecursive(price, N - j);
                if (remaining != -1)
                    maxProfit = Math.max(maxProfit, price[j - 1] + remaining);
            }
        }
        return maxProfit;
    }

    private static int rodCuttingProblemRecursiveMemoization(int[] price, int N, int[] cache) {
        if (N < 0)
            return 0;

        if (N == 0)
            return 0;

        if (cache[N - 1] != -1)
            return cache[N - 1];

        int maxProfit = 0;
        for (int j = 1; j <= price.length; j++) {
            if ((N - j) >= 0) {
                int remaining = rodCuttingProblemRecursiveMemoization(price, N - j, cache);
                if (remaining != -1)
                    maxProfit = Math.max(maxProfit, price[j - 1] + remaining);
            }
        }
        cache[N - 1] = maxProfit;
        return cache[N - 1];
    }

    private static int rodCuttingProblemDp(int[] price, int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= N; j++) {
                if ((i - j) >= 0) {
                    dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
                }
            }
        }
        return dp[N];
    }
}
