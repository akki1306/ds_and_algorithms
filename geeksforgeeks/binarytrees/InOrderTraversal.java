package geeksforgeeks.binarytrees;

import geeksforgeeks.binarytrees.ds.BuildLevelOrder;
import geeksforgeeks.binarytrees.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode tn = BuildLevelOrder.buildLevelOrder(new Integer[]{10, 20, 30, 40, 50, 60, null, 70, 80});
        List<Integer> output = new ArrayList<>();
        inOrderTraversalRecursive(tn, output);
        System.out.println(inOrderTraversalIterative(tn));
        System.out.println(morrisTraversalInorder(tn));
    }

    private static void inOrderTraversalRecursive(TreeNode tn, List<Integer> output) {
        if (tn == null)
            return;

        inOrderTraversalRecursive(tn.getLeft(), output);
        output.add(tn.getVal());
        inOrderTraversalRecursive(tn.getRight(), output);
    }

    private static List<Integer> inOrderTraversalIterative(TreeNode tn) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        TreeNode temp = tn;

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }

            TreeNode pop = stack.pop();
            output.add(pop.getVal());

            temp = pop.getRight();
        }

        return output;
    }

    private static List<Integer> morrisTraversalInorder(TreeNode tn) {
        TreeNode curr = tn;
        List<Integer> output = new ArrayList<>();
        while (curr != null) {
            if (curr.getLeft() == null) {
                output.add(curr.getVal());
                curr = curr.getRight();
            } else {
                TreeNode prev = curr.getLeft();
                while (prev.getRight() != null && prev.getRight() != curr) {
                    prev = prev.getRight();
                }

                if (prev.getRight() == null) {
                    prev.setRight(curr);
                    curr = curr.getLeft();
                } else {
                    prev.setRight(null);
                    output.add(curr.getVal());
                    curr = curr.getRight();
                }
            }
        }
        return output;
    }

}
