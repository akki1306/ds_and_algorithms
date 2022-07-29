package udemy.binarytrees;

import udemy.binarytrees.ds.Node;

/**
 * Siblings Swap
 *
 * Determine if a binary tree can be converted to another by doing any number of swaps
 * of children!
 */
public class SiblingsSwap {
    public static void main(String[] args) {
        Node root1 = BuildLevelOrder.buildLevelOrder(new int[]{6, 3, 8, 1, 7, 4, 2, -1, -1, -1, -1, 7, 1, -1, 3});
        Node root2 = BuildLevelOrder.buildLevelOrder(new int[]{6, 8, 3, 2, 4, 7, 1, 3, -1, 1, 7, -1, -1, -1, -1});
        System.out.println(equal(root1, root2));
    }

    private static boolean equal(Node X, Node Y) {
        if (X == Y) {
            return true;
        }

        return (X != null && Y != null) && (X.val == Y.val) &&
                ((equal(X.left, Y.left) && equal(X.right, Y.right)) ||
                        (equal(X.right, Y.left) && equal(X.left, Y.right)));
    }
}
