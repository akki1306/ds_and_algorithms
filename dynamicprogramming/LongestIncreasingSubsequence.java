package dynamicprogramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequenceDp(new int[]{50, 4, 10, 8, 30, 100}));
        System.out.println(longestIncreasingSubsequenceRecursion(new int[]{50, 4, 10, 8, 30, 100}, 0));
    }

    private static int longestIncreasingSubsequenceDp(int[] arr) {
        int[] dp = new int[arr.length];

        dp[arr.length - 1] = 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1])
                dp[i] = 1 + dp[i + 1];
            else
                dp[i] = dp[i + 1];
        }
        return dp[0];
    }

    private static int longestIncreasingSubsequenceRecursion(int[] arr, int index) {
        if (index > arr.length - 1)
            return 0;

        if (index == arr.length - 1)
            return 1;

        if (arr[index] < arr[index + 1])
            return 1 + longestIncreasingSubsequenceRecursion(arr, index + 1);
        else
            return longestIncreasingSubsequenceRecursion(arr, index + 1);
    }
}
