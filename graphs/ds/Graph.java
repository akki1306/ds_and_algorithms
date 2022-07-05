package graphs.ds;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int v;
    List<List<Integer>> l;

    public Graph(int v) {
        this.v = v;
        l = new ArrayList<>();
    }

    public void addEdge(int i, int j, boolean undir) {
        int cnt = l.size() - 1;
        while (cnt++ < Math.max(i, j)) {
            l.add(new ArrayList<>());
        }

        l.get(i).add(j);
        if (undir)
            l.get(j).add(i);
    }

    public void printAdjList() {
        //iterate over all row
        for (int i = 0; i < v; i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < l.get(i).size(); j++) {
                System.out.print(l.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(2, 1, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 5, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 5, true);

        g.printAdjList();
    }
}
