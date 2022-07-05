package binarysearchtree;

import binarysearchtree.ds.Node;

public class InorderSuccessorBST {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13});
        System.out.println(inorderSuccessorBST(root, root.right.right.left));
    }

    private static Node inorderSuccessorBST(Node root, Node target) {
        if (target.right != null) {
            Node temp = target.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            int max = Integer.MIN_VALUE;
            Node maxNode = null;
            while (root != null) {
                if (root.val > max) {
                    max = root.val;
                    maxNode = root;
                }
                if (target.val <= root.val) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }

            return maxNode;
        }
    }
}
