package binarytrees;

import binarytrees.ds.Node;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Build Level Order
 *
 * Build a binary tree from Level Order Input, -1 in input represents NULL
 *
 * 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 *
 */
public class BuildLevelOrder {
    public static void main(String[] args) {
    Node root = buildLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, 7, -1, -1, -1, -1, -1});
        System.out.println();
    }

    // 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
    public static Node buildLevelOrder(int[] arr) {
        Queue<Node> queue = new LinkedBlockingQueue<>();

        Node root = new Node(arr[0], null, null);

        queue.add(root);
        int i=0;
        while (!queue.isEmpty() && i < arr.length) {
            Node n = queue.poll();
            ++i;
            if (i< arr.length && arr[i] != -1) {
                n.left = new Node(arr[i], null, null);
                queue.add(n.left);
            }

            ++i;
            if (i < arr.length && arr[i] != -1) {
                n.right = new Node(arr[i], null, null);
                queue.add(n.right);
            }
        }

        return root;
    }
}
