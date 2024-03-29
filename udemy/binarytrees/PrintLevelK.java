package udemy.binarytrees;

import udemy.binarytrees.ds.Node;

/**
 * Print at Level K
 *
 * Print all nodes at level K from the root node.
 *
 * K=2
 */
public class PrintLevelK {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, 6, -1, -1, -1, 7, -1});
        printLevelK(root, 2);
    }

    public static void printLevelK(Node root, int level) {
        if (root == null)
            return;

        if (level == 0)
            System.out.print(root.val + " ");

        printLevelK(root.left, level - 1);
        printLevelK(root.right, level - 1);
    }
}
