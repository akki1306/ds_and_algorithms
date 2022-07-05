package binarysearchtree;

import binarysearchtree.ds.Node;

public class InorderSuccessorBST {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{8,3,10,1,6,14,4,7,13});
        System.out.println(inorderSuccessorBST(root, 13));
    }

    private static int inorderSuccessorBST(Node root, int val) {
        if (root == null)
            return -1;

        int max = root.val;
        if (val <= root.val)
            max = Math.max(max, inorderSuccessorBST(root.left, val));
        else
            max = Math.max(max, inorderSuccessorBST(root.right, val));

        return max;
    }
}
