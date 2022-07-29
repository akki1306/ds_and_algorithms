package udemy.dynamicprogramming2D;

import java.util.Arrays;

/**
 * Longest Common Subsequence
 *
 * Given two sequences, find the length of longest subsequence which is common to both
 * of them.
 *
 * Input
 *
 * s1 = "ABCD"
 * s2 = "ABEDG"
 *
 * Output:
 * 3
 * (ABD)
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcsRecursive("ABCD", "ABEDG", 0, 0));
        int[][] cache = new int[5][6];
        for (int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], -1);
        System.out.println(lcsRecursiveMemoization("ABCD", "ABEDG", 0, 0, cache));
        System.out.println(lcsDp("ABCD", "ABEDG"));
    }

    private static int lcsRecursive(String s1, String s2, int i, int j) {
        if (i > s1.length() - 1)
            return 0;

        if (j > s2.length() - 1)
            return 0;

        if (s1.charAt(i) == s2.charAt(j))
            return 1 + lcsRecursive(s1, s2, i + 1, j + 1);
        else
            return Math.max(lcsRecursive(s1, s2, i + 1, j), lcsRecursive(s1, s2, i, j + 1));
    }

    private static int lcsRecursiveMemoization(String s1, String s2, int i, int j, int[][] cache) {
        if (i > s1.length() - 1)
            return 0;

        if (j > s2.length() - 1)
            return 0;

        if (cache[i][j] != -1)
            return cache[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return cache[i + 1][j + 1] = 1 + lcsRecursiveMemoization(s1, s2, i + 1, j + 1, cache);
        else {
            int x = lcsRecursiveMemoization(s1, s2, i + 1, j, cache);
            int y = lcsRecursiveMemoization(s1, s2, i, j + 1, cache);
            if (x > y)
                return cache[i + 1][j] = x;
            else
                return cache[i][j + 1] = y;
        }
    }

    private static int lcsDp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        // print the LCS by backtracking
        StringBuilder lcs = new StringBuilder();
        for (int i = s1.length(); i > 0; ) {
            for (int j = s2.length(); i > 0; ) {
                if (dp[i][j] == dp[i][j - 1]) {
                    j--;
                } else if (dp[i - 1][j] == dp[i][j]) {
                    i--;
                } else {
                    lcs.append(s1.charAt(i - 1));
                    i--;
                    j--;
                }
            }
        }

        System.out.println(lcs.reverse());
        return dp[s1.length()][s2.length()];
    }
}
