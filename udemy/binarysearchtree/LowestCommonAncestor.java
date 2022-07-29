package udemy.binarysearchtree;

import udemy.binarysearchtree.ds.Node;

/**
 * Lowest Common Ancestor
 *
 * Given a Binary Search Tree and values of two nodes that lie, inside the tree, find the Lowest Common Ancestor.
 *
 * Let T be the rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in
 * T that has both n1 and n2 as descendents(where we allow node to be descendent of itself).
 *
 * You may assume that both values exist in the tree and are unique.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        //balanced tree
        Node root = BSTCreation.createBinarySearchTree(new int[]{5, 2, 12, -4, 3, 9, 21, 19, 25});
        Node lca = lowestCommonAncestor(root, 9, 19);
        System.out.println("LCA is " + lca.val);

        // left sub tree absent - skewed tree
        root = BSTCreation.createBinarySearchTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        lca = lowestCommonAncestor(root, 2, 9);
        System.out.println("LCA is " + lca.val);

        // right sub tree ansent - skewed tree
        root = BSTCreation.createBinarySearchTree(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        lca = lowestCommonAncestor(root, 2, 10);
        System.out.println("LCA is " + lca.val);
    }

    public static Node lowestCommonAncestor(Node root, int a, int b) {
        if (root == null)
            return null;

        if (root.val == a || root.val == b)
            return root;

        if ((a <= root.val && b > root.val) || (b <= root.val && a > root.val))
            return root;
        else if (a < root.val && b < root.val)
            return lowestCommonAncestor(root.left, a, b);
        else
            return lowestCommonAncestor(root.right, a, b);
    }
}
