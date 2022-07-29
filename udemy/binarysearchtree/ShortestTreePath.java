package udemy.binarysearchtree;

import udemy.binarysearchtree.ds.Node;

public class ShortestTreePath {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{10, 4, 15, 2, 5, 13, 22, 1, 14});
        // System.out.println(shortestPath(root, 1, 4));
        System.out.println(shortestPathBruteForce(root, 1, 4));
        System.out.println(shortestPathUsingLca(root, 1, 4));
    }

    private static int shortestPathBruteForce(Node root, int a, int b) {
        int aCnt = countDistance(root, a);
        int bCnt = countDistance(root, b);

        if (a <= root.val && b > root.val)
            return aCnt + bCnt;
        else
            return Math.abs(aCnt - bCnt);
    }

    private static int shortestPathUsingLca(Node root, int a, int b) {
        Node lca = LowestCommonAncestor.lowestCommonAncestor(root, a, b);
        int d1 = countDistance(lca, a);
        int d2 = countDistance(lca, b);
        return d1 + d2;
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

