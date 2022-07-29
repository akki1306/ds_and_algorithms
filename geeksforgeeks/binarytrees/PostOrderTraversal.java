package geeksforgeeks.binarytrees;

import geeksforgeeks.binarytrees.ds.BuildLevelOrder;
import geeksforgeeks.binarytrees.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode tn = BuildLevelOrder.buildLevelOrder(new Integer[]{10, 20, 30, 40, 50, 60, null, 70, 80});
        List<Integer> output = new ArrayList<>();
        postOrderTraversalRecursive(tn, output);
        System.out.println(output);
        System.out.println(postOrderTraversalIterativeOneStack(tn));
        System.out.println(postOrderTraversalIterativeTwoStack(tn));
        System.out.println(postOrderTraversalIterativeOneStackApproach2(tn));
    }

    private static void postOrderTraversalRecursive(TreeNode tn, List<Integer> output) {
        if (tn == null)
            return;

        postOrderTraversalRecursive(tn.getLeft(), output);
        postOrderTraversalRecursive(tn.getRight(), output);
        output.add(tn.getVal());
    }

    private static List<Integer> postOrderTraversalIterativeOneStack(TreeNode tn) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        TreeNode curr = tn;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                TreeNode temp = stack.peek().getRight();
                if (temp == null) {
                    temp = stack.pop();
                    output.add(temp.getVal());
                    while (!stack.isEmpty() && temp == stack.peek().getRight()) {
                        temp = stack.pop();
                        output.add(temp.getVal());
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return output;
    }

    private static List<Integer> postOrderTraversalIterativeTwoStack(TreeNode tn) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> output = new ArrayList<>();
        s1.push(tn);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);

            if (node.getLeft() != null)
                s1.push(node.getLeft());

            if (node.getRight() != null)
                s1.push(node.getRight());
        }

        while (!s2.isEmpty()) {
            output.add(s2.pop().getVal());
        }
        return output;
    }

    private static List<Integer> postOrderTraversalIterativeOneStackApproach2(TreeNode tn) {
        TreeNode curr = tn;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        while (true) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.getLeft();
            }

            if (stack.isEmpty()) break;
            curr = stack.pop();
            if (!stack.isEmpty() && stack.peek() == curr)
                curr = curr.getRight();
            else
                output.add(curr.getVal());
        }
        return output;
    }
}
