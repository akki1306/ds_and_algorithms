package leetcode.graphs;

public class UniquePathsIII {
    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        }));
        System.out.println(uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        }));
        System.out.println(uniquePathsIII(new int[][]{
                {0, 1},
                {2, 0}
        }));
    }

    public static int uniquePathsIII(int[][] grid) {
        int si = 0, sj = 0, ei = 0, ej = 0, bc = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                }
                if (grid[i][j] == 2) {
                    ei = i;
                    ej = j;
                }
                if (grid[i][j] == -1) {
                    bc++;
                }
            }
        }
        boolean[][] isUsed = new boolean[grid.length][grid[0].length];
        return uniquePathsIIIHelper(grid, ei, ej, isUsed, 0, si, sj, bc);
    }

    private static int uniquePathsIIIHelper(int[][] grid, int i, int j, boolean[][] isUsed, int cnt, int startI, int startJ, int bc) {
        if (i == startI && j == startJ) {
            if (cnt == (grid.length * grid[0].length - bc - 1))
                return 1;
            else
                return 0;
        } else if (cnt > (grid.length * grid[0].length - bc - 1))
            return 0;

        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};

        isUsed[i][j] = true;
        int pathCount = 0;
        for (int k = 0; k < x.length; k++) {
            int dx = x[k] + i;
            int dy = y[k] + j;
            if (dx >= grid.length || dy >= grid[0].length || dx < 0 || dy < 0)
                continue;
            if (!isUsed[dx][dy] && grid[dx][dy] != -1)
                pathCount += uniquePathsIIIHelper(grid, dx, dy, isUsed, cnt + 1, startI, startJ, bc);
        }
        isUsed[i][j] = false;
        return pathCount;
    }
}
