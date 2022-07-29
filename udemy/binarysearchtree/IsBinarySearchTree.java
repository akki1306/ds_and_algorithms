package udemy.binarysearchtree;

import udemy.binarytrees.BuildLevelOrder;
import udemy.binarytrees.ds.Node;

//import javax.swing.tree.TreeNode;

//import javax.swing.tree.TreeNode;

/**
 * IsBST
 *
 * Given a binary tree, Check if the tree is a BST or not!
 */
public class IsBinarySearchTree {
    public static void main(String[] args) {
        // not a binary tree
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6});
        System.out.println(isBinarySearchTree(root, null, null));

        // binary tree
        root = BuildLevelOrder.buildLevelOrder(new int[]{4, 2, 6, 1, 3, 5, 7});
        System.out.println(isBinarySearchTree(root, null, null));

        root = BuildLevelOrder.buildLevelOrder(new int[]{2,2,2});
        System.out.println(isBinarySearchTree(root, null, null));
    }


    private static boolean isBinarySearchTree(Node root, Node min, Node max) {
        if(root == null)
            return true;

        if(min!=null && min.val>=root.val)
            return false;

        if(max!=null && max.val<=root.val)
            return false;

        return isBinarySearchTree(root.left, min, root) &&
                isBinarySearchTree(root.right, root, max);

    }
}
