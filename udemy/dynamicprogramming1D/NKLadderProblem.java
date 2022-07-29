package udemy.dynamicprogramming1D;

import java.util.Arrays;

public class NKLadderProblem {
    public static void main(String[] args) {
        System.out.println(computeWaysRecursion(4, 3));
        int[] cache = new int[5];
        Arrays.fill(cache, -1);
        System.out.println(computeWaysRecursionMemoization(4, 3, cache));
        System.out.println(computeWaysRecursionOptimized(4, 3));
        System.out.println(computeWaysRecursionBottomUp(4, 3));
    }

    // time complexity O(K^N)
    private static int computeWaysRecursion(int i, int K) {
        if (i == 0)
            return 1;

        if (i < 0)
            return 0;

        int ans = 0;
        for (int j = 1; j <= K; j++)
            ans += computeWaysRecursion(i - j, K);
        return ans;
    }

    // time complexity O(N*K)
    private static int computeWaysRecursionMemoization(int i, int K, int[] cache) {
        if (i == 0)
            return 1;

        if (i < 0)
            return 0;

        if (cache[i] != -1) {
            return cache[i];
        }

        int ans = 0;
        for (int j = 1; j <= K; j++)
            ans += computeWaysRecursionMemoization(i - j, K, cache);
        cache[i] = ans;
        return cache[i];
    }


    // time complexity O(N)
    private static int computeWaysRecursionOptimized(int N, int K) {
        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (i <= K)
                dp[i] = 2 * dp[i - 1];
            else
                dp[i] = 2 * dp[i - 1] - dp[i - K - 1];

        }
        return dp[N];
    }

    /*private static int computeWaysRecursionMemoization(int N, int i, int K, int[] cache) {
        if (i == 0)
            return 1;

        if (i < 0)
            return 0;

        int ans = 0;
        for (int j = 1; j <= K; j++)
            if (cache[i - j] != -1) {
                System.out.println("used caching");
                ans += cache[i - j];
            } else {
                int temp = computeWaysRecursion(N, i - j, K);
                cache[i - j] = temp;
                ans += temp;
            }
        return ans;
    }*/

    // time complexity - O(N*K)
    private static int computeWaysRecursionBottomUp(int N, int K) {
        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int m = 1; m < dp.length; m++) {
            for (int n = 1; n <= K; n++) {
                if (m - n >= 0)
                    dp[m] += dp[m - n];
            }
        }
        return dp[dp.length - 1];
    }
}