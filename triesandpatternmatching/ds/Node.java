package triesandpatternmatching.ds;

import java.util.HashMap;
import java.util.Map;

public class Node {
    public Map<Character, Node> children;
    boolean isTerminal;

    public Node(boolean isTerminal) {
        this.children = new HashMap<>();
        this.isTerminal = isTerminal;
    }
}

