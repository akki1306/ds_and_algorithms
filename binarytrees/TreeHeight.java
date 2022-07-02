package binarytrees;

import binarytrees.ds.Node;
import binarytrees.ds.Tree;

public class TreeHeight {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.buildTree(new int[]{1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1});
        System.out.println(treeHeight(root));
    }

    private static int treeHeight(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(treeHeight(node.left), treeHeight(node.right));
    }
}
