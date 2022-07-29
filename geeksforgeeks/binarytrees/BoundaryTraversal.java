package geeksforgeeks.binarytrees;

import geeksforgeeks.binarytrees.ds.BuildLevelOrder;
import geeksforgeeks.binarytrees.ds.Node;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder("1 2 3 4 5 6 7 N 8 9");
        System.out.println(boundary(root));
    }

    static ArrayList<Integer> boundary(Node node) {
        Node temp = node;
        ArrayList<Integer> list = new ArrayList();
        if (!isLeaf(node)) list.add(node.data);
        traverseLeftTree(node, list);
        traverseLeafNodes(node, list);
        traverseRightTree(node, list);
        return list;
    }

    private static void traverseLeftTree(Node node, ArrayList<Integer> list) {
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                list.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static void traverseRightTree(Node node, ArrayList<Integer> list) {
        Node curr = node.right;
        ArrayList<Integer> tmp = new ArrayList();
        while (curr != null) {
            if (!isLeaf(curr)) {
                tmp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for (int i = tmp.size() - 1; i >= 0; i--) {
            list.add(tmp.get(i));
        }
    }

    private static void traverseLeafNodes(Node node, ArrayList<Integer> list) {
        if (isLeaf(node)) {
            list.add(node.data);
            return;
        }

        if (node.left != null)
            traverseLeafNodes(node.left, list);

        if (node.right != null)
            traverseLeafNodes(node.right, list);
    }

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }


}
