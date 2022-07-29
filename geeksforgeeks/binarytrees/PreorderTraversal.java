package geeksforgeeks.binarytrees;

import geeksforgeeks.binarytrees.ds.BuildLevelOrder;
import geeksforgeeks.binarytrees.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode tn = BuildLevelOrder.buildLevelOrder(new Integer[]{10, 20, 30, 40, 50, 60, null, 70, 80});
        System.out.println(preOrderIterative(tn));
        List<Integer> list = new ArrayList<>();
        preOrderRecursive(tn, list);
        System.out.println(list);
        System.out.println(morrisPreorderTraversal(tn));
    }

    private static void preOrderRecursive(TreeNode root, List<Integer> output) {
        if (root == null)
            return;

        output.add(root.getVal());
        preOrderRecursive(root.getLeft(), output);
        preOrderRecursive(root.getRight(), output);
    }

    private static List<Integer> preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preOrderTraversal = new ArrayList<>();

        TreeNode temp = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            while (temp != null) {
                preOrderTraversal.add(temp.getVal());
                stack.push(temp.getRight());
                temp = temp.getLeft();
            }
        }

        return preOrderTraversal;
    }

    private static List<Integer> morrisPreorderTraversal(TreeNode root) {
        List<Integer> preOrderTraversal = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.getLeft() == null) {
                preOrderTraversal.add(curr.getVal());
                curr = curr.getRight();
            } else {
                TreeNode prev = curr.getLeft();
                while (prev.getRight() != null && prev.getRight() != curr) {
                    prev = prev.getRight();
                }

                if (prev.getRight() == null) {
                    prev.setRight(curr);
                    preOrderTraversal.add(curr.getVal());
                    curr = curr.getLeft();
                } else {
                    prev.setRight(null);
                    curr = curr.getRight();
                }
            }
        }
        return preOrderTraversal;
    }
}
