package udemy.graphs;

import udemy.graphs.ds.Graph;

public class DepthFirstSearch {
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

        boolean[] visited = new boolean[7];
        dfs(1, g, visited);
    }

    // Time complexity - O(v + e)
    private static void dfs(int val, Graph g, boolean[] visited) {
        if (g.l.get(val).isEmpty())
            return;

        visited[val] = true;
        System.out.print(val + "--");
        for (int i = 0; i < g.l.get(val).size(); i++) {
            if (!visited[g.l.get(val).get(i)])
                dfs(g.l.get(val).get(i), g, visited);
        }
    }
}
