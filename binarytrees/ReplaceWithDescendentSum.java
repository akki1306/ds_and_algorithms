package binarytrees;

import binarytrees.ds.Node;
import binarytrees.ds.Tree;

/**
 * Replace with Sum
 *
 * Given a binary tree, replace every node by sum of all its
 * descendents, leave leaf nodes intact.
 */
public class ReplaceWithDescendentSum {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.buildTree(new int[]{1, 2, 4, -1, -1, 5 , 7, -1, -1, -1, 3, -1, 6, -1, -1});
        descendentSum(root);
        LevelOrderPrint.levelOrderPrint(root);
    }

    private static int descendentSum(Node n) {
        if(n==null)
            return 0;
        if (n.left == null && n.right == null)
            return n.val;

        int temp = n.val;
        n.val = descendentSum(n.left) + descendentSum(n.right);

        return temp + n.val;
    }
}
