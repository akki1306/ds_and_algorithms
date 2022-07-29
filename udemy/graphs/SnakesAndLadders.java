package udemy.graphs;

import udemy.graphs.ds.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SnakesAndLadders {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(32, 30);
        snakes.put(34, 12);
        snakes.put(24, 16);
        snakes.put(17, 4);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 15);
        ladders.put(5, 7);
        ladders.put(18, 20);
        ladders.put(25, 35);

        System.out.println(min_dice_throws_to_reach_top(36, snakes, ladders));
    }

    private static int min_dice_throws_to_reach_top(int n, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        int[] board = new int[n + 1];
        Graph g = new Graph(n + 1);

        for (Map.Entry<Integer, Integer> e : ladders.entrySet()) {
            board[e.getKey()] = e.getValue() - e.getKey();
        }

        for (Map.Entry<Integer, Integer> e : snakes.entrySet()) {
            board[e.getKey()] = e.getValue() - e.getKey();
        }

        for (int i = 1; i < n; i++) {
            for (int dice = 1; dice <= 6; dice++) {
                int v = i + dice;
                if (v <= n) {
                    v += board[v];
                    if (v <= n)
                        g.addEdge(i, v, true);
                }
            }
        }

        return minCostBFS(1,n,n,g);
    }

    private static int minCostBFS(int src, int dest, int n, Graph g) {
        Queue<Integer> q = new ArrayBlockingQueue(n + 1);
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        q.add(src);
        visited[src] = true;
        dist[src] = 0;

        while (!q.isEmpty()) {
            int f = q.peek();
            q.poll();

            for (int nbr : g.l.get(f)) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                    dist[nbr] = dist[f] + 1;
                }
            }
        }
        return dist[dest];
    }
}
