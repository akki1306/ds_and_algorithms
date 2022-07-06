package graphs;

import graphs.ds.Graph;

public class CycleDetectionDirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(0, 4, false);
        g.addEdge(0, 5, false);
        g.addEdge(5, 4, false);

        System.out.println(contains_cycle(g));
    }

    private static boolean dfs(int val, Graph g, boolean[] visited, boolean[] stack) {
        // mark the node as visited and add it in the stack
        visited[val] = true;
        stack[val] = true;

        for (int i = 0; i < g.l.get(val).size(); i++) {
            int nmbr = g.l.get(val).get(i);
            if (stack[nmbr] == true) { // if the number is already in the stack
                return true;
            } else if (!visited[nmbr]) { // try to search if neighbour of current node detected a cycle
                boolean nbrFoundACycle = dfs(nmbr, g, visited, stack);
                if (nbrFoundACycle)
                    return true;
            }
        }
        stack[val] = false; // before leaving the node mark the stack entry for the node as false
        return false;
    }

    private static boolean contains_cycle(Graph g) {
        boolean[] visited = new boolean[g.v];
        boolean[] stack = new boolean[g.v];

        for (int i = 0; i < g.v; i++) {   // try to start traversing the graph from every node until we detect a cyclt
            if (!visited[i]) {
                if (dfs(i, g, visited, stack))
                    return true;
            }
        }
        return false;
    }
}
