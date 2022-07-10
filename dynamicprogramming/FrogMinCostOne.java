package dynamicprogramming;

public class FrogMinCostOne {
    public static void main(String[] args) {
        System.out.println(frogMinCostRecursive(new int[]{30, 10, 60, 10, 60, 50}, 5));
        System.out.println(frogMinCostDp(new int[]{30, 10, 60, 10, 60, 50}));
    }

    private static int frogMinCostRecursive(int[] arr, int i) {
        if (i <= 0)
            return 0;

        return Math.min(Math.abs(arr[i] - frogMinCostRecursive(arr, i - 1)), Math.abs(arr[i] - frogMinCostRecursive(arr, i - 2)));
    }

    private static int frogMinCostDp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(Math.abs(arr[i] - arr[i - 1]), Math.abs(arr[i] - arr[i - 2]));
        }
        return dp[arr.length - 1];
    }
}
