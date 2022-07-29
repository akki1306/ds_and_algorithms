package udemy.binarysearchtree;

import udemy.binarysearchtree.ds.Node;

/**
 * Closest in BST
 *
 * Function to find the integer closest to a given target value
 * in a BST.
 */
public class ClosestInBST {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13});
        System.out.println(closestInBST(root, 16));
        System.out.println(closestInBSTIterative(root, 0));
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
        int currentDiff;
        int diff = Integer.MAX_VALUE;
        Node temp = root;
        int closest = -1;
        while (temp != null) {
            currentDiff = Math.abs(temp.val - key);
            if (currentDiff == 0)
                return temp.val;

            if (currentDiff < diff) {
                diff = currentDiff;
                closest = temp.val;
            }

            if (temp.val < key)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return closest;
    }
}
