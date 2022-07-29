package leetcode.graphs;

public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        }));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt += dfs(grid, i, j, visited);
                }
            }
        }
        return cnt;
    }

    private static int dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || j >= grid[0].length)
            return 0;

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};

        int cnt = 0;
        if (grid[i][j] == '1')
            cnt = 1;
        visited[i][j] = true;
        for (int k = 0; k < x.length; k++) {
            int dx = i + x[k];
            int dy = j + y[k];

            if (dx >= 0 && dy >= 0 && dx < grid.length && dy < grid[0].length && grid[dx][dy] == '1' && !visited[dx][dy]) {
                dfs(grid, dx, dy, visited);
            }
        }
        return cnt;
    }
}
