package binarysearchtree.ds;

public class Node {
    public Integer val;
    public Node left;
    public Node right;

    public Node(Integer val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}