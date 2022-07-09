package dynamicprogramming;

import java.util.Arrays;

public class NKLadderProblem {
    public static void main(String[] args) {
        System.out.println(computeWaysRecursion(4, 4, 3));
        int[] cache = new int[4];
        Arrays.fill(cache, -1);
        System.out.println(computeWaysRecursionMemoization(4, 4, 3, cache));
        System.out.println(computeWaysRecursionBottomUp(4, 3));
    }

    private static int computeWaysRecursion(int N, int i, int K) {
        if (i == 0)
            return 1;

        if (i < 0)
            return 0;

        int ans = 0;
        for (int j = 1; j <= K; j++)
            ans += computeWaysRecursion(N, i - j, K);
        return ans;
    }

    private static int computeWaysRecursionMemoization(int N, int i, int K, int[] cache) {
        if (i == 0)
            return 1;

        if (i < 0)
            return 0;

        int ans = 0;
        for (int j = 1; j <= K; j++)
            if (cache[i - j] != -1)
                ans += cache[i - j];
            else
                ans += computeWaysRecursion(N, i - j, K);
        return ans;
    }

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