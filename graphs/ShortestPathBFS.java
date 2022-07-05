package graphs;

import graphs.ds.Graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ShortestPathBFS {
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

        shortestPath(1, 7, g, 6);
    }

    public static void shortestPath(int source, int v, Graph g, int dest) {
        boolean[] visited = new boolean[v];
        int[] parent = new int[v];
        int[] dist = new int[v];
        Queue<Integer> q = new ArrayBlockingQueue(v);
        q.add(source);
        parent[source] = source;
        dist[source] = 0;
        visited[source] = true;
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i : g.l.get(p)) {
                if (!visited[i]) {
                    q.add(i);
                    parent[i] = p;
                    dist[i] = dist[p] + 1;
                    visited[i] = true;
                }
            }
        }
        //print shortest distance
        for (int i = 0; i < v; i++) {
            System.out.println("Shortest dist to " + i + " is " + dist[i]);
        }

        //print path from source to any destination
        if (dest != -1) {
            int temp = dest;
            while (temp != source) {
                System.out.print(temp + " -- ");
                temp = parent[temp];
            }
            System.out.println(source + " -- ");
        }
    }
}
