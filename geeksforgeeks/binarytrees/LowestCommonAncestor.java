package geeksforgeeks.binarytrees;

import geeksforgeeks.binarytrees.ds.BuildLevelOrder;
import geeksforgeeks.binarytrees.ds.Node;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder("1 2 3");
        System.out.println(lca(root, 2, 3));
    }

    //Function to return the lowest common ancestor in a Binary Tree.
    static Node lca(Node root, int n1, int n2)
    {
        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left!=null && right!=null)
            return root;

        if(left==null)
            return right;

        return left;
    }

    static boolean isPresent(Node root, int n){
        if(root == null)
            return false;

        if(root.data == n)
            return true;

        return isPresent(root.left, n) || isPresent(root.right, n);
    }
}
