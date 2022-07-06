package graphs.ds;

import java.util.ArrayList;
import java.util.List;

public class GraphWeighted {
    public int v;
    public List<List<Pair>> edges;

    public GraphWeighted(int v) {
        this.v = v;
        this.edges = new ArrayList<>(this.v);
        int cnt = 0;
        while (cnt++ < v)
            this.edges.add(new ArrayList<>());
    }

    public void addEdge(int s, int d, int w, boolean undir) {
        this.edges.get(s).add(new Pair(w, d));

        if (undir) {
            this.edges.get(d).add(new Pair(w, s));
        }
    }

    public static class Pair {
        public int n;
        public int w;

        public Pair(int w, int n) {
            this.w = w;
            this.n = n;
        }
    }
}
