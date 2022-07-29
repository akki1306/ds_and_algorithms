package udemy.binarytrees;

import udemy.binarytrees.ds.Node;

/**
 * Max Subset Sum
 *
 * Find the largest sum of a subset of nodes in a binary tree, such that if a node
 * is included in the sum then its parent and children must not be included in the
 * subset sum.
 */
public class MaxSubsetSumTree {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, 6, -1, -1, -1, 7, -1});
        IEPair iePair = maxSubsetSumTree(root);
        System.out.println(Math.max(iePair.included, iePair.excluded));
    }

    private static IEPair maxSubsetSumTree(Node node) {
        if (node == null)
            return new IEPair(0, 0);

        IEPair left = maxSubsetSumTree(node.left);
        IEPair right = maxSubsetSumTree(node.right);
        int nodeIncluded = node.val + left.excluded + right.excluded;
        int nodeExcluded = Math.max(left.included, left.excluded) + Math.max(right.included, right.excluded);
        IEPair ie = new IEPair(nodeIncluded, nodeExcluded);
        return ie;
    }

    static class IEPair {
        int included;
        int excluded;

        IEPair(int included, int excluded) {
            this.included = included;
            this.excluded = excluded;
        }

        @Override
        public String toString() {
            return "IEPair{" +
                    "included=" + included +
                    ", excluded=" + excluded +
                    '}';
        }
    }
}
