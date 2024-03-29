package udemy.dynamicprogramming1D;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args) {
        System.out.println(coinChange(15, new int[]{1, 3, 7, 10}));
        int[] cache = new int[15];
        Arrays.fill(cache, -1);
        System.out.println(coinChangeMemoization(15, new int[]{1, 3, 7, 10}, cache));
        System.out.println(coinChangeDp(6, new int[]{5, 7, 10}));
    }

    private static int coinChange(int M, int[] coins) {
        if (M < 0)
            return -1;

        if (M == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > M)
                continue;
            int remainingAmount = M - coins[i];
            if (remainingAmount >= 0) {
                int remainingAmtCount = coinChange(remainingAmount, coins);
                min = Math.min(1 + remainingAmtCount, min);
            }
        }
        return min;
    }

    private static int coinChangeMemoization(int M, int[] coins, int[] cache) {
        if (M < 0)
            return -1;

        if (M == 0)
            return 0;

        if (cache[M - 1] != -1)
            return cache[M - 1];

        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > M)
                continue;
            int remainingAmount = M - coins[i];
            if (remainingAmount >= 0) {
                int remainingAmtCount = coinChangeMemoization(remainingAmount, coins, cache);
                min = Math.min(1 + remainingAmtCount, min);
            }
        }
        cache[M - 1] = min;
        return min;
    }

    private static int coinChangeDp(int M, int[] coins) {
        int[] dp = new int[M + 1];

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i)
                    continue;
                int remainingAmount = i - coins[j];
                if (remainingAmount >= 0 && dp[remainingAmount]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(1 + dp[remainingAmount], dp[i]);
                }

            }
        }
        return dp[M] == Integer.MAX_VALUE ? -1 : dp[M];
    }

}
