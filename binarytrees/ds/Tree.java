package binarytrees.ds;

public class Tree {
    private Node root;


    private static int i = -1;

    public Node buildTree(int[] arr) {
        if (arr[++i] == -1)
            return null;
        Node n = new Node(arr[i], null, null);
        n.left = buildTree(arr);
        n.right = buildTree(arr);
        return n;
    }
}



