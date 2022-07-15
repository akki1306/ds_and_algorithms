package dynamicprogramming2D;

/**
 * Knapsack Problem
 *
 * Given weights and prices of n items, we need put a subset of items in a bag of
 * capacity W such that we get maximum total value in the bag, also known as knapsack.
 *
 * Input:
 * N=4 W=11
 * wts=[2,7,3,4]
 * prices=[5,20,20,10]
 *
 * Output:
 * 40
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        System.out.println(knapsackProblem(11, new int[]{2, 7, 3, 4}, new int[]{5, 20, 20, 10}, 0));
        System.out.println(knapsackProblemDp(11, new int[]{2, 7, 3, 4}, new int[]{5, 20, 20, 10}));
    }

    private static int knapsackProblem(int W, int[] w, int[] p, int i) {
        if (W <= 0)
            return 0;

        if (i >= w.length)
            return 0;

        if (W - w[i] > 0) {
            return Math.max(p[i] + knapsackProblem(W - w[i], w, p, i + 1), knapsackProblem(W, w, p, i + 1));
        }
        return knapsackProblem(W, w, p, i + 1);
    }

    private static int knapsackProblemDp(int W, int[] w, int[] p) {
        int N = w.length;
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                int inc = 0;
                if (w[i - 1] <= j)
                    inc = p[i - 1] + dp[i - 1][j - w[i - 1]];
                int exc = dp[i - 1][j];
                dp[i][j] = Math.max(inc, exc);
            }
        }
        return dp[N][W];
    }
}
