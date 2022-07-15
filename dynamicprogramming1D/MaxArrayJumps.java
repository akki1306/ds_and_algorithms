package dynamicprogramming1D;

import java.util.Arrays;

/**
 * Given an array of positive integers, where each element represents max no of steps
 * you can jump forward in the array.
 *
 * Find the minimum jumps needed to reach the final index.
 *
 * Input:
 *
 * arr = [3 4 2 1 2 3 10 1 1 1 2 5]
 *
 * Output:
 * 4
 * 3 -> 4 -> 2 -> 7 -> 5
 */
public class MaxArrayJumps {
    public static void main(String[] args) {
        System.out.println(maxArrayJumpsRecursive(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 2, 5}, 1));
        int[] cache = new int[12];
        Arrays.fill(cache, -1);
        System.out.println(maxArrayJumpsRecursiveMemoization(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 2, 5}, 1, cache));
        System.out.println(maxArrayJumpDp(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 2, 5}));
    }

    private static int maxArrayJumpsRecursive(int[] arr, int index) {
        if (index >= arr.length - 1)
            return 0;

        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[index - 1]; j++) {
            minJumps = Math.min(minJumps, 1 + maxArrayJumpsRecursive(arr, index + j));
        }

        return minJumps != Integer.MAX_VALUE ? minJumps : -1;
    }

    private static int maxArrayJumpsRecursiveMemoization(int[] arr, int index, int[] cache) {
        int N = arr.length - 1;
        if (index >= N)
            return 0;

        if (cache[N] != -1)
            return cache[N];

        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[index - 1]; j++) {
            minJumps = Math.min(minJumps, 1 + maxArrayJumpsRecursive(arr, index + j));
        }
        cache[N] = minJumps != Integer.MAX_VALUE ? minJumps : -1;
        return cache[N];
    }

    private static int maxArrayJumpDp(int[] arr) {

        int N = arr.length + 1;
        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i - 1]; j++) {
                if (i - j >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - j]);
            }
        }
        return dp[arr.length - 1];
    }
}
