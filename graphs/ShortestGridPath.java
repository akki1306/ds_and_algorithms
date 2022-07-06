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
        TreeMap<Integer, Cell> map = new TreeMap<>();

        for (int i = 0; i < dist.length; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = grid[0][0];
        map.put(dist[0][0], new Cell(0, 0));

        while (!map.isEmpty()) {
            Map.Entry<Integer, Cell> e = map.pollFirstEntry();
            Cell c = e.getValue();
            List<Cell> neighbours = new ArrayList<>();
            if (c.r + 1 < grid.length)
                neighbours.add(new Cell(c.r + 1, c.c));
            if (c.c + 1 < grid[0].length)
                neighbours.add(new Cell(c.r, c.c + 1));
            if (c.r - 1 >= 0)
                neighbours.add(new Cell(c.r - 1, c.c));
            if (c.c - 1 >= 0)
                neighbours.add(new Cell(c.r, c.c - 1));

            for (int i = 0; i < neighbours.size(); i++) {
                Cell nbr = neighbours.get(i);
                if (dist[c.r][c.c] + grid[nbr.r][nbr.c] < dist[nbr.r][nbr.c]) {
                    List<Map.Entry<Integer, Cell>> entries = map.entrySet().stream().filter(en -> en.getValue() == nbr).collect(Collectors.toList());
                    if (entries != null && !entries.isEmpty())
                        map.remove(entries.get(0).getKey());

                    dist[nbr.r][nbr.c] = dist[c.r][c.c] + grid[nbr.r][nbr.c];
                    map.put(dist[nbr.r][nbr.c], new Cell(nbr.r, nbr.c));
                }
            }
        }
        dist[dist.length - 1][dist[0].length - 1] = grid[grid.length-1][grid.length-1] + Math.min(dist[dist.length-1][dist[0].length-2], dist[dist.length-2][dist.length-1]);
        return dist[dist.length - 1][dist[0].length - 1];
    }

    static class Cell {
        public int r;
        public int c;

        public Cell(int r, int c) {
            this.c = c;
            this.r = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return r == cell.r && c == cell.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
