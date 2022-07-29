package geeksforgeeks.binarytrees;

import geeksforgeeks.binarytrees.ds.BuildLevelOrder;
import geeksforgeeks.binarytrees.ds.Node;

public class SumTree {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder("3 1 2");
        System.out.println(isSumTree(root));
    }

    static boolean isSumTree(Node root)
    {
        if(root == null || (root.left==null && root.right==null))
            return true;

        return root.data == (sum(root.left) + sum(root.right)) && isSumTree(root.left) &&
                isSumTree(root.right);
    }

    static int sum(Node root) {
        if(root == null)
            return 0;

        return root.data + sum(root.left) + sum(root.right);
    }
}
