package recursion;

public class LongestPossibleRoute {
    public static void main(String[] args) {
        //int grid[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        //        {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
        //        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 1}
        };

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        System.out.println(longestPossibleRoute(grid, 0, 0, visited) - 1);
    }

    private static int longestPossibleRoute(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || j < 0 || i < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
            return 0;

        visited[i][j] = true;
        return 1 + Math.max(Math.max(longestPossibleRoute(grid, i + 1, j, visited), longestPossibleRoute(grid, i - 1, j, visited)),
                Math.max(longestPossibleRoute(grid, i, j + 1, visited), longestPossibleRoute(grid, i, j - 1, visited)));
    }
}
