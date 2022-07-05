package graphs;

import graphs.ds.Graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1, true);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 5, true);
        g.addEdge(5, 6, true);
        g.addEdge(4, 5, true);
        g.addEdge(0, 4, true);
        g.addEdge(3, 4, true);

        bfs(1, g);
    }

    private static void bfs(int source, Graph g) {
        Queue<Integer> q = new ArrayBlockingQueue(7);
        boolean[] visited = new boolean[7];
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            System.out.print(poll + ",");
            for (Integer i : g.l.get(poll)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
