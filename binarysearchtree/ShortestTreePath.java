package binarysearchtree;

import binarysearchtree.ds.Node;

public class ShortestTreePath {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{10, 4, 15, 2, 5, 13, 22, 1, 14});
        // System.out.println(shortestPath(root, 1, 4));
        System.out.println(shortestPath(root, 15, 22));
    }

    private static int shortestPath(Node root, int a, int b) {
        int aCnt = countDistance(root, a);
        int bCnt = countDistance(root, b);

        if (a <= root.val && b > root.val)
            return aCnt + bCnt;
        else
            return Math.abs(aCnt - bCnt);
    }

    private static int countDistance(Node root, int val) {
        int cnt = 0;
        Node temp = root;
        while (temp != null && temp.val != val) {
            cnt++;
            if (val <= temp.val)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return cnt;
    }

}

