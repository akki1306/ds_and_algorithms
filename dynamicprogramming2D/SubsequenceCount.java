package dynamicprogramming2D;

public class SubsequenceCount {
    public static void main(String[] args) {
        System.out.println(subsequenceCount("ABBCCCCEDG", "ABC", 6, 2));
        System.out.println(subsequenceCountDp("ABBCCCCEDG", "ABC"));
    }

    private static int subsequenceCount(String s1, String s2, int i, int j) {
        if ((i < 0 && j < 0) || j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (s1.charAt(i) != s2.charAt(j)) {
            return subsequenceCount(s1, s2, i - 1, j);
        }
        return subsequenceCount(s1, s2, i - 1, j - 1) + subsequenceCount(s1, s2, i - 1, j);
    }

    private static int subsequenceCountDp(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M + 1][N + 1];

        dp[0][0] = 1;

        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);

                if (c1 != c2) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[M][N];
    }
}
