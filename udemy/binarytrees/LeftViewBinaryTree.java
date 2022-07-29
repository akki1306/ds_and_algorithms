package udemy.binarytrees;

import udemy.binarytrees.ds.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Left View
 * <p>
 * Given a binary tree, print left view of it. Left view of a binary tree is set of nodes that
 * are visible when a tree visited from the left side.
 */
public class LeftViewBinaryTree {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6});
       // Node root = BuildLevelOrder.buildLevelOrder(new int[]{4, 5, 2, -1, -1, 3, 1, 6, 7, -1});
        ArrayList<Integer> list = new ArrayList<>();
        leftViewBinaryTree(root, list, 1);
        System.out.println(list);
    }

    static int maxLevel = 0;

    private static void leftViewBinaryTree(Node root, List<Integer> list, int level) {
        if (root == null)
            return;

        if (maxLevel < level) {
            list.add(root.val);
            maxLevel = level;
        }

        leftViewBinaryTree(root.left, list, level + 1);
        leftViewBinaryTree(root.right, list, level + 1);
    }
}
