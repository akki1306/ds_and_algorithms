package binarytrees;

import binarytrees.ds.Node;

public class LeftViewBinaryTree {
    public static void main(String[] args) {
//        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6});
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{4, 5, 2, -1, -1, 3, 1, 6, 7, -1});
        leftViewBinaryTree(root, true);
    }

    private static void leftViewBinaryTree(Node root, boolean isLeft) {
        if (root == null)
            return;

        if (isLeft)
            System.out.print(root.val + " ");

        leftViewBinaryTree(root.left, true);
        leftViewBinaryTree(root.right, false);
    }
}
