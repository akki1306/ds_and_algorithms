package dynamicprogramming1D;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequenceDp(new int[]{50, 4, 10, 8, 30, 100}));
        System.out.println(longestIncreasingSubsequenceRecursion(new int[]{50, 4, 10, 8, 30, 100}, 5));
    }

    private static int longestIncreasingSubsequenceDp(int[] arr) {
        int[] dp = new int[arr.length];

        Arrays.fill(dp,1);
        int lis = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }
        return lis;
    }

    private static int longestIncreasingSubsequenceRecursion(int[] arr, int index) {
        if (index < 0)
            return 0;

        if (index == 0)
            return 1;

        int lis = 1;
        for (int j = 0; j < index; j++) {
            if (arr[j] < arr[index])
                lis = Math.max(1 + longestIncreasingSubsequenceRecursion(arr, j), lis);
        }
        return lis;
    }
}
