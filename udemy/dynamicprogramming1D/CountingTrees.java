package udemy.dynamicprogramming1D;

import java.util.Arrays;

/**
 * Counting Trees
 *
 * Count the number of Binary Search Trees that can be formed using
 * N nodes, numbered from 1 to N. See the two test cases.
 *
 * Sample Input:
 *
 * 3
 * 4
 *
 * Output
 *
 * 5
 * 15
 *
 */
public class CountingTrees {
    public static void main(String[] args) {
        System.out.println(countTreesRecursive(3));
        int[] dp = new int[3];
        Arrays.fill(dp, -1);
        System.out.println(countTreesRecursiveMemoization(3, dp));
        System.out.println(countTreesDp(3));
    }

    private static int countTreesRecursive(int N) {
        if (N == 0 || N == 1)
            return 1;

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int x = countTreesRecursive(i - 1);
            int y = countTreesRecursive(N - i);
            ans += x * y;
        }
        return ans;
    }

    private static int countTreesRecursiveMemoization(int N, int[] dp) {
        if (N == 0 || N == 1)
            return 1;

        if (dp[N - 1] != -1)
            return dp[N - 1];

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int x = countTreesRecursiveMemoization(i - 1, dp);
            int y = countTreesRecursiveMemoization(N - i, dp);
            ans += x * y;
        }
        dp[N - 1] = ans;
        return dp[N - 1];
    }

    private static int countTreesDp(int N) {
        int[] dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int ans = 0;
            for (int j = 1; j <= i; j++) {
                int x = dp[j - 1];
                int y = dp[i - j];
                ans+=x*y;
            }
            dp[i]=ans;
        }
        return dp[N];
    }
}
