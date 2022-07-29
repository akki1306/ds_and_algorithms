package udemy.graphs;

import java.util.LinkedList;
import java.util.Objects;

public class LargestIsland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0}
        };

        System.out.println(largestIsland(grid));
    }

    private static int largestIsland(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<Node> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                int cnt = 1;
                if (grid[i][j] == 1 && !visited[i][j]) {
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Node node = q.get(0);
                        q.remove(0);
                        for (int k = 0; k < dx.length; k++) {
                            int nx = node.r + dx[k];
                            int ny = node.c + dy[k];

                            if (nx < m && ny < n && nx >= 0 && ny >= 0 && grid[nx][ny] == 1 && !visited[nx][ny]) {
                                q.add(new Node(nx, ny));
                                visited[nx][ny] = true;
                                cnt++;
                            }
                        }
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    static class Node {
        public int r;
        public int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return r == node.r && c == node.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

    }
}
