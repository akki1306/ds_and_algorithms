package graphs;

import graphs.ds.Graph;

public class AstronautPairs {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);

        System.out.println(countAstronautPairs(g));
    }

    private static int traverseHelper(int s, boolean[] visited, Graph g) {
        visited[s] = true;
        int size = 1;

        for (int i : g.l.get(s)) {
            if (!visited[i]) {
                size += traverseHelper(i, visited, g);
            }
        }
        return size;
    }

    private static int countAstronautPairs(Graph g) {
        boolean[] visited = new boolean[g.v];
        int ans = (g.v * (g.v - 1)) / 2;  // find total number of pairs of all astronauts
        for (int i = 0; i < g.v; i++) {
            if (!visited[i]) {
                int csize = traverseHelper(i, visited, g); // find number of pairs of one country astronauts connected with graph
                ans -= (csize * (csize - 1)) / 2; // substract country pairs from total since we only want inter country pairs
            }
        }
        return ans;
    }
}
