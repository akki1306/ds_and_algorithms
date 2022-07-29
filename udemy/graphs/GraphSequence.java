package udemy.graphs;

import java.util.Arrays;

public class GraphSequence {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 2, 4, 3, 2},
                {7, 6, 5, 5, 1},
                {8, 9, 7, 18, 14},
                {5, 10, 11, 12, 13}
        };
        System.out.println(graphSequenceDp(grid));
    }

    private static int graphSequenceDp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == Integer.MIN_VALUE)
                    dp[i][j] = dfsLongestPathAtCell(i, j, dp, grid);

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    private static int dfsLongestPathAtCell(int r, int c, int[][] dp, int[][] grid) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int m = dp.length;
        int n = dp[0].length;

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < dx.length; k++) {
            int nx = r + dx[k];
            int ny = c + dy[k];

            if (nx < m && ny < n && nx >= 0 && ny >= 0 && grid[nx][ny] > grid[r][c]) {
                if (dp[nx][ny] == Integer.MIN_VALUE)
                    max = Math.max(max, 1 + dfsLongestPathAtCell(nx, ny, dp, grid));
                else
                    max = Math.max(max, 1 + dp[nx][ny]);
            }
        }

        if (max != Integer.MIN_VALUE)
            dp[r][c] = max;
        else
            return 1;

        return dp[r][c];
    }
}
