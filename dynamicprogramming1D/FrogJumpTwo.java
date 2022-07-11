package dynamicprogramming1D;

public class FrogJumpTwo {
    public static void main(String[] args) {
        System.out.println(frogMinJumpDp(new int[]{10, 30, 40, 50, 20}, 3));
    }

    private static int frogMinJumpDp(int[] jumpArr, int k) {
        int[] dp = new int[jumpArr.length];

        dp[0] = 0;

        for (int i = 1; i < jumpArr.length; i++) {
            int cost;
            int min = Integer.MAX_VALUE;
            for (int j = Math.max(i - k, 0); j < i; j++) {
                cost = Math.abs(jumpArr[i] - jumpArr[j]) + dp[j];
                min = Math.min(min, cost);
            }
            dp[i] += min;
        }
        return dp[jumpArr.length - 1];
    }
}
