package dynamicprogramming2D;

import java.util.Arrays;

/**
 * Palindromic Partitioning
 *
 * Given a string s, your task is to partition s such that every substring of the partition is palindrome
 *
 * Return the minimum number of cuts needed for a palindrome partitioning of s.
 *
 * Examples:
 *
 * Input str = "geek"
 * Output: 2
 *
 * We need to make minimum 2 cuts, i.e. "g | ee | k"
 *
 * Input str = "aaaa"
 *
 * Output: 0
 *
 * The string is already a palindrome
 *
 * Input str = "abcde"
 * Output: we need to make 4 cuts, i.e. "a|b|c|d|e"
 *
 * Input str = "abbac"
 * Output: 1 i.e. abba | c
 */
public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "geek";
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(minPartitions(s, 0, 3, dp));
    }

    private static int minPartitions(String s, int i, int j, int[][] dp) {
        if (i >= j)
            return 0;

        if (isPalindrome(s, i, j))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) { // try making partition at each k
            int op1 = minPartitions(s, i, k, dp);
            int op2 = minPartitions(s, k + 1, j, dp);
            ans = Math.min(1 + op1 + op2, ans);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
