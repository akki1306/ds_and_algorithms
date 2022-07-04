package binarytrees;

import binarytrees.ds.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodesAtDistanceKSorted {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, 7, 8, -1, -1, -1, -1, 9, 10});
        Node target = root.left.right;
        List<Integer> result = new ArrayList<>();
        nodesAtDistanceK(root, target, 2, result);
        Collections.sort(result);
        System.out.println(result);
    }

    static void printAtLevelK(Node root, int k, List<Integer> result) {
        if (root == null)
            return;

        if (k == 0) {
            result.add(root.val);
            return;
        }

        printAtLevelK(root.left, k - 1, result);
        printAtLevelK(root.right, k - 1, result);
    }

    private static int nodesAtDistanceK(Node root, Node target, int k, List<Integer> result) {
        if (root == null)
            return -1;

        // reached the target node
        if (root == target) {
            printAtLevelK(target, k, result);
            return 0;
        }

        // other case
        int DL = nodesAtDistanceK(root.left, target, k, result);
        if (DL != -1) {
            // 2 cases
            //print the current node
            if (DL + 1 == k) {
                result.add(root.val);
            } else {
                printAtLevelK(root.right, k - 2 - DL, result);
            }
            return 1 + DL;
        }

        int DR = nodesAtDistanceK(root.right, target, k, result);
        if (DR != -1) {
            // 2 cases
            // print the current node
            if (DR + 1 == k) {
                result.add(root.val);
            } else {
                printAtLevelK(root.left, k - 2 - DR, result);
            }
            return 1 + DR;
        }

        return -1;
    }
}
