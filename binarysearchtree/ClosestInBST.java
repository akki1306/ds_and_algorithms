package binarysearchtree;

import binarysearchtree.ds.Node;

public class ClosestInBST {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13});
        System.out.println(closestInBST(root, 16));
        System.out.println(closestInBSTIterative(root, 16));
    }

    private static int closestInBST(Node root, int key) {
        if (root == null)
            return Integer.MIN_VALUE;


        if (key < root.val)
            return Math.max(root.val, closestInBST(root.left, key));
        else
            return Math.max(root.val, closestInBST(root.right, key));
    }

    private static int closestInBSTIterative(Node root, int key) {
        int max = Integer.MIN_VALUE;
        while (root != null) {
            max = Math.max(root.val, max);
            if (key < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return max;
    }
}
