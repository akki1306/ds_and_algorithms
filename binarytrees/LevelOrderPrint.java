package binarytrees;

import binarytrees.ds.Node;
import binarytrees.ds.Tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Print level order (BFS)
 *
 * Print a Binary Tree using a Level Order Traversal
 *
 * Input Tree
 *        1
 *      2   3
 *    4   5   6
 *      7
 *
 * Output
 *
 * 1
 * 2 3
 * 4 5 6
 * 7
 */
public class LevelOrderPrint {
    public static void main(String[] args) {
        Tree tree = new Tree();
        levelOrderPrint(tree.buildTree(new int[]{1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1}));
    }

    public static void levelOrderPrint(Node root) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        Node nullNode = new Node(-999, null, null);
        queue.add(nullNode);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.val == -999) {
                System.out.println();
                if (!queue.isEmpty())
                    queue.add(nullNode);
            } else
                System.out.print(poll.val + " ");

            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }
    }
}
