package udemy.dynamicprogramming2D;

/**
 * Coin Change 2
 *
 * Given a value N and an integer vector COINS representing coins of different denominations. Considering you
 * have infinite supply of each coin, your task is to find total number of combinations of these coins that
 * make a sum of N.
 *
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * Input Format:
 *
 * In the function an integer N is given, and a vector COINS consisting of coins.
 *
 * Output Format:
 *
 * Return an integer representing total number of combinations.
 *
 * Constraint:
 *
 * Total number of ways <= 10^12
 *
 * Sample Testcase:
 *
 * Input:
 *
 * 1 2 3
 *
 * Output:
 *
 * 4
 *
 * Explanation:
 *
 * {1,1,1,1},{1,1,2},{1,3},{2,2} are different combinations having a sum of 4.
 */
public class CoinChangeTwo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int A = 4;
        System.out.println(coinChange2(arr, A, 2));
        int[][] dp = new int[arr.length][A + 1];
        System.out.println(coinChange2Memoization(arr, A, 2, dp));
        System.out.println(coinChange2Dp(arr, 4));
    }

    private static int coinChange2(int[] arr, int A, int index) {
        if (A == 0)
            return 1;

        if (index < 0)
            return 0;

        if (A < 0)
            return 0;

        int op1 = coinChange2(arr, A - arr[index], index); // include current element
        int op2 = coinChange2(arr, A, index - 1); // do not include current element
        return op1 + op2;
    }

    private static int coinChange2Memoization(int[] arr, int A, int index, int[][] dp) {
        if (A == 0)
            return 1;

        if (index < 0)
            return 0;

        if (A < 0)
            return 0;

        if (dp[index][A] != 0)
            return dp[index][A];

        int op1 = coinChange2Memoization(arr, A - arr[index], index, dp); // include current element
        int op2 = coinChange2Memoization(arr, A, index - 1, dp); // do not include current element
        return dp[index][A] = op1 + op2;
    }

    private static int coinChange2Dp(int[] arr, int A) {
        int[][] dp = new int[arr.length][A];

        for (int i = 1; i < A; i++)
            dp[0][i] = 1;

        for (int c = 1; c < arr.length; c++) {
            for (int t = 0; t < A; t++) {
                int take = 0;
                if (t - arr[c - 1] > 0) {
                    take = dp[c][t - arr[c - 1]];
                }
                int notTake = dp[c - 1][t];
                dp[c][t] = take + notTake;

            }
        }
        return dp[arr.length - 1][A - 1];
    }
}
