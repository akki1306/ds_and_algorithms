package udemy.graphs;

import udemy.graphs.ds.Graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CycleDetectionUndirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(1, 0, true);
        g.addEdge(0, 4, true);
        g.addEdge(0, 5, true);
        g.addEdge(4, 5, true);

        System.out.println(isCyclic(0, g, 7));
    }

    private static boolean isCyclic(int source, Graph g, int v) {
        int[] parent = new int[v];
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new ArrayBlockingQueue(v);

        q.add(source);
        parent[source] = source;
        visited[source] = true;

        while (!q.isEmpty()) {
            int val = q.poll();
            for (int i = 0; i < g.l.get(val).size(); i++) {
                Integer number = g.l.get(val).get(i);
                if (!visited[number]) {
                    parent[number] = val;
                    visited[number] = true;
                    q.add(number);
                } else if (parent[val] != number) { // not returning to the node from bidirectional link in undirected graph but through another node which is not the original parent of current node hence forming a cycle
                    return true;
                }
            }
        }
        return false;
    }

}
