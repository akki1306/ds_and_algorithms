package graphs.ds;

import java.util.*;

public class GraphNode {
    // All Nodes
    // HashMap (String, Node)
    Map<String, Node> m;

    public GraphNode(List<String> cities){
        m = new HashMap<>();
        for(String s: cities){
            m.put(s, new Node(s));
        }
    }

    public void addEdge(String x, String y, boolean undir){
        m.get(x).nbrs.add(y);
        if(undir)
            m.get(y).nbrs.add(x);
    }

    public void printAdjList(){
        for(Map.Entry<String, Node> s: m.entrySet()){
            String name = s.getKey();
            Node node = s.getValue();
            System.out.print(name + "-->");
            for(String x: node.nbrs){
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi", "London", "Paris", "New York");
        GraphNode gn = new GraphNode(cities);
        gn.addEdge("Delhi", "London", false);
        gn.addEdge("New York", "London", false);
        gn.addEdge("Delhi", "Paris", false);
        gn.addEdge("Paris", "New York", false);

        gn.printAdjList();
    }

    static class Node{
        String name;
        List<String> nbrs;

        public Node(String name){
            this.name = name;
            this.nbrs = new ArrayList<>();
        }
    }
}



