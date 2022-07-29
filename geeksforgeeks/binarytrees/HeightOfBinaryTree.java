package geeksforgeeks.binarytrees;

import geeksforgeeks.binarytrees.ds.BuildLevelOrder;
import geeksforgeeks.binarytrees.ds.Node;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder("1 2 3");
        System.out.println(height(root));
    }

    static int height(Node node)
    {
        if(node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

}
