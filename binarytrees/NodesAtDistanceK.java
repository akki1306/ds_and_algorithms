package binarytrees;

import binarytrees.ds.Node;

/**
 * Nodes at distance K
 *
 * Given a Binary Tree, and a Target Node T. Find all nodes at distance K from
 * given node, where K is also an integer input.
 *
 *
 */
public class NodesAtDistanceK {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, 7, 8, -1, -1, -1, -1, 9, 10});
        Node target = root.left.right.right;
        nodesAtDistanceK(root, target, 3);
    }

    static void printAtLevelK(Node root, int k) {
        if (root == null)
            return;

        if (k == 0) {
            System.out.print(root.val + " ");
            return;
        }

        printAtLevelK(root.left, k - 1);
        printAtLevelK(root.right, k - 1);
    }

    private static int nodesAtDistanceK(Node root, Node target, int k) {
        if (root == null)
            return -1;

        // reached the target node
        if (root == target) {
            printAtLevelK(target, k);
            return 0;
        }

        // other case
        int DL = nodesAtDistanceK(root.left, target, k);
        if (DL != -1) {
            // 2 cases
            //print the current node
            if (DL + 1 == k)
                System.out.print(root.val);
            else
                printAtLevelK(root.right, k - 2 - DL);

            return 1 + DL;
        }

        int DR = nodesAtDistanceK(root.right, target, k);
        if (DR != -1) {
            // 2 cases
            // print the current node
            if (DR + 1 == k)
                System.out.print(root.val + " ");
            else
                printAtLevelK(root.left, k - 2 - DR);

            return 1 + DR;
        }

        return -1;
    }
}
