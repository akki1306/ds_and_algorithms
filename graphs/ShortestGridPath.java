package graphs;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestGridPath {
    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{31, 100, 65, 12, 18},
                        {10, 13, 47, 157, 6},
                        {100, 113, 174, 11, 33},
                        {88, 124, 41, 20, 140},
                        {99, 32, 111, 41, 20}};
        System.out.println(shortest_path(grid));
    }

    private static int shortest_path(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        TreeSet<Node> set = new TreeSet<>(new NodeComparator());

        for (int i = 0; i < dist.length; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = grid[0][0];
        set.add(new Node(0, 0, dist[0][0]));

        while (!set.isEmpty()) {
            Node c = set.pollFirst();
            List<Node> neighbours = new ArrayList<>();
            int nx, ny;
            if (c.r + 1 < grid.length) {
                nx = c.r + 1;
                ny = c.c;
                neighbours.add(new Node(nx, ny, dist[nx][ny]));
            }
            if (c.c + 1 < grid[0].length) {
                nx = c.r;
                ny = c.c + 1;
                neighbours.add(new Node(nx, ny, dist[nx][ny]));
            }
            if (c.r - 1 >= 0) {
                nx = c.r - 1;
                ny = c.c;
                neighbours.add(new Node(nx, ny, dist[nx][ny]));
            }
            if (c.c - 1 >= 0) {
                nx = c.r;
                ny = c.c - 1;
                neighbours.add(new Node(nx, ny, dist[nx][ny]));
            }

            for (int i = 0; i < neighbours.size(); i++) {
                Node nbr = neighbours.get(i);
                if ((dist[c.r][c.c] + grid[nbr.r][nbr.c]) < dist[nbr.r][nbr.c]) {
                    List<Node> entries = set.stream().filter(en -> en.equals(nbr)).collect(Collectors.toList());
                    if (entries != null && !entries.isEmpty())
                        set.remove(entries.get(0));

                    dist[nbr.r][nbr.c] = dist[c.r][c.c] + grid[nbr.r][nbr.c];
                    set.add(new Node(nbr.r, nbr.c, dist[nbr.r][nbr.c]));
                }
            }
        }
//        dist[dist.length - 1][dist[0].length - 1] = grid[grid.length - 1][grid.length - 1] + Math.min(dist[dist.length - 1][dist[0].length - 2], dist[dist.length - 2][dist.length - 1]);
        return dist[dist.length - 1][dist[0].length - 1];
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.dist, o2.dist);
        }
    }

    static class Node {
        public int r;
        public int c;
        public int dist;

        public Node(int r, int c, int dist) {
            this.c = c;
            this.r = r;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node cell = (Node) o;
            return r == cell.r && c == cell.c && dist == cell.dist;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, dist);
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dist=" + dist + "'}'";
        }
    }
}
