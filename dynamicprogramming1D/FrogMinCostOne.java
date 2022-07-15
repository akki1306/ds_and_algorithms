package dynamicprogramming1D;

/**
 *  There are N stones given in the form of an array, each element in the array
 *  represents the height of ith stone. There is a frog who is initially on Stone 1.
 *
 *  Frog will repeat the following action some number of times to reach stone N:
 *
 *  If the frog is currently on Stone i, jump to Stone i + 1 or Stone i + 2.
 *  Here the cost of |hi - hj| is incurred, where j is the stone to land on.
 *
 *  Find the minimum total cost incurred before the frog reaches the stone N.
 *
 *  Sample Input:
 *
 *  10 10
 *
 *  Output:
 *
 *  0
 *
 *  Sample Input 2:
 *
 *  30 10 60 10 60 50
 *
 *  Output 2:
 *
 *  40
 *
 *  Sample Input 3:
 *
 *  10 30 40 20
 *
 *  Output 3:
 *
 *  30
 */
public class FrogMinCostOne {
    public static void main(String[] args) {
        System.out.println(frogMinCostRecursive(new int[]{30, 10, 60, 10, 60, 50}, 5));
        System.out.println(frogMinCostDp(new int[]{30, 10, 60, 10, 60, 50}));
    }

    private static int frogMinCostRecursive(int[] arr, int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return Math.abs(arr[0] - arr[1]);

        int minPrev = frogMinCostRecursive(arr, i - 1);
        int minPrevPrev = frogMinCostRecursive(arr, i - 2);
        return Math.min(Math.abs(arr[i] - arr[i - 1]) + minPrev, Math.abs(arr[i] - arr[i - 2]) + minPrevPrev);
    }

    private static int frogMinCostDp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(Math.abs(arr[i] - arr[i - 1]) + dp[i - 1], Math.abs(arr[i] - arr[i - 2]) + dp[i - 2]);
        }
        return dp[arr.length - 1];
    }
}
