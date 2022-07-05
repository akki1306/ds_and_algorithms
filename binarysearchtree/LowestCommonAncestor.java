package binarysearchtree;

import binarysearchtree.ds.Node;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{5, 2, 12, -4, 3, 9, 21, 19, 25});
        Node lca = lowestCommonAncestor(root, 9, 25);
        System.out.println("LCA is " + lca.val);
    }

    private static Node lowestCommonAncestor(Node root, int a, int b) {
        if (root == null)
            return null;

        if (a < root.val && b > root.val)
            return root;
        else if (a < root.val && b < root.val)
            return lowestCommonAncestor(root.left, a, b);
        else
            return lowestCommonAncestor(root.right, a, b);
    }
}
