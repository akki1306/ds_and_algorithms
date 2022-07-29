package udemy.graphs;

import udemy.graphs.ds.GraphWeighted;
import udemy.graphs.ds.GraphWeighted.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Dijkshtras {
    public static void main(String[] args) {
        GraphWeighted gw = new GraphWeighted(5);

        gw.addEdge(0, 1, 1, true);
        gw.addEdge(1, 2, 1, true);
        gw.addEdge(0, 2, 4, true);
        gw.addEdge(0, 3, 7, true);
        gw.addEdge(3, 2, 2, true);
        gw.addEdge(3, 4, 3, true);

        System.out.println(dijkshtra(5, 0, 4, gw));
    }

    private static int dijkshtra(int v, int src, int dest, GraphWeighted g) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dist[src] = 0;
        map.put(0, src);
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> e = map.pollFirstEntry(); // map key is distance and map value is the node value.

            for (Pair p : g.edges.get(e.getValue())) { // iterate over adjacency list
                if ((p.w + e.getKey()) < dist[p.n]) {
                    // if neighbour already exists in the set with a larger distance, then remove that entry
                    List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream().filter(en -> en.getValue() == p.n).collect(Collectors.toList());
                    if (entries != null && !entries.isEmpty())
                        map.remove(entries.get(0).getKey());

                    // update distance till nor for the destination node in the pair
                    dist[p.n] = p.w + e.getKey();
                    // insert updated distance for the destination in the sorted tree map so it will be placed in ascending order of the distance till now
                    map.put(dist[p.n], p.n);
                }
            }
        }

        for (int i = 0; i < g.v; i++) {
            System.out.println("Node is " + i + " distance is " + dist[i]);
        }

        return dist[dest];
    }

}
