package binarysearchtree;

import binarytrees.BuildLevelOrder;
import binarytrees.ds.Node;

/**
 * IsBST
 *
 * Given a binary tree, Check if the tree is a BST or not!
 */
public class IsBinarySearchTree {
    public static void main(String[] args) {
        // not a binary tree
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6});
        System.out.println(isBinarySearchTree(root));

        // binary tree
        root = BuildLevelOrder.buildLevelOrder(new int[]{4, 2, 6, 1, 3, 5, 7});
        System.out.println(isBinarySearchTree(root));
    }


    private static boolean isBinarySearchTree(binarytrees.ds.Node root) {
        boolean isLeftBST = true, isRightBST = true;

        if (root.left != null) {
            isLeftBST = root.left.val <= root.val && isBinarySearchTree(root.left);
        }

        if (root.right != null) {
            isRightBST = root.right.val > root.val && isBinarySearchTree(root.right);
        }

        return isLeftBST && isRightBST;
    }
}
