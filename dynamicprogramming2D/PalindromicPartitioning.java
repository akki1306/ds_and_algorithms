package dynamicprogramming2D;

import java.util.Arrays;

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
