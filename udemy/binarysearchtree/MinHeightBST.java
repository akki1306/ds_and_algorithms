package udemy.binarysearchtree;

import udemy.binarysearchtree.ds.Node;

/**
 * Min Height BST
 *
 * Given a sorted array, construct a BST of minimum height
 *
 * 1 2 3 4 5 6 7
 */
public class MinHeightBST {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node root = minHeightBst(null , arr, 0, arr.length-1);
        BSTCreation.printBST(root);
    }

    public static Node minHeightBst(Node root, int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        if (root == null)
            root = new Node(arr[mid], null, null);

        root.left = minHeightBst(null, arr, start, mid - 1);
        root.right = minHeightBst(null, arr, mid + 1, end);

        return root;
    }
}
