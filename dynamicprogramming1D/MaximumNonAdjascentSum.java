package dynamicprogramming1D;

/**
 * Given an array of positive integers, find the maximum sum of
 * non adjacent elements in the array.
 * <p>
 * Input:
 * [6,10,12,7,9,14]
 * <p>
 * Output:
 * 32
 */
public class MaximumNonAdjascentSum {
    public static void main(String[] args) {
        System.out.println(maximumNonAdjacentSumRecursive(new int[]{6, 10, 12, 7, 9, 14}, 0));
        System.out.println(maximumNonAdjacentSumDp(new int[]{6, 10, 12, 7, 9, 14}));
    }

    private static int maximumNonAdjacentSumRecursive(int[] arr, int index) {
        if (index >= arr.length)
            return 0;

        return Math.max(arr[index] + maximumNonAdjacentSumRecursive(arr, index + 2), maximumNonAdjacentSumRecursive(arr, index + 1));
    }

    private static int maximumNonAdjacentSumDp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        return dp[arr.length-1];
    }
}
