package udemy.binarytrees;

import udemy.binarytrees.ds.Node;
import udemy.binarytrees.ds.Tree;

/**
 * Given a binary tree, check if it is height balanced.
 * <p>
 * A non empty binary tree is balanced if:
 * 1. Left subtree of T is balanced.
 * 2. Right subtree of T is balanced.
 * 3. The difference between the heights of left subtree and right subtree
 * is not more than 1.
 */
public class HeightBalancedTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1,2,3,4,5,-1,6,-1,-1,7,8,-1,-1,-1,-1});
        //Node root = tree.buildTree(new int[]{1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1});
        System.out.println(heightBalanced(root));
    }

    private static HBPair heightBalanced(Node node) {
        if (node == null)
            return new HBPair(0, true);

        HBPair leftPair = heightBalanced(node.left);
        HBPair rightPair = heightBalanced(node.right);
        int height = 1 + Math.max(leftPair.height, rightPair.height);
        int diff = Math.abs(leftPair.height - rightPair.height);
        if(leftPair.isBalanced && rightPair.isBalanced && diff <= 1)
            return new HBPair(height, leftPair.isBalanced
                && rightPair.isBalanced && diff <= 1);
        return new HBPair(height, false);
    }

    static class HBPair {
        int height;
        boolean isBalanced;

        HBPair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        @Override
        public String toString() {
            return "HBPair{" +
                    "height=" + height +
                    ", isBalanced=" + isBalanced +
                    '}';
        }
    }
}
