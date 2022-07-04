package binarysearchtree;

import binarysearchtree.ds.Node;

public class BSTCreation {
    public static void main(String[] args) {
        Node root = createBinarySearchTree(new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13});
        printBST(root);
        System.out.println();
        System.out.println(search(root, 10));
    }

    private static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key, null, null);

        if (key < root.val)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    public static boolean search(Node root, int key) {
        if(root.val == key)
            return true;

        if(key < root.val)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void printBST(Node root) {
        if (root == null)
            return;

        printBST(root.left);
        System.out.print(root.val + " ");
        printBST(root.right);
    }

    public static Node createBinarySearchTree(int[] arr) {
        Node root = insert(null, arr[0]);

        for (int i = 1; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }

        return root;
    }
}
