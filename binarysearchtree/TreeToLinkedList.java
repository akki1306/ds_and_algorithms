package binarysearchtree;

import binarysearchtree.ds.Node;

/**
 * Flatten the tree
 *
 * Given a BST convert it to a sorted linked list, right pointer should behave
 * as next pointer for the linked list.
 */
public class TreeToLinkedList {
    public static void main(String[] args) {
        Node root = BSTCreation.createBinarySearchTree(new int[]{4, 2, 6, 1, 3, 5, 7});

        Node head = treeToLinkedList(root).head;

        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.right;
        }
    }

    private static HTPair treeToLinkedList(Node root) {

        HTPair ret = new HTPair(null, null);
        if (root == null)
            return new HTPair(null, null);
        if (root != null && root.left == null && root.right == null)
            return new HTPair(root, root);
        else if (root.left != null && root.right == null) {
            HTPair leftPair = treeToLinkedList(root.left);
            leftPair.tail.right = root;
            ret.head = leftPair.head;
            ret.tail = root;
        } else if (root.left == null && root.right != null) {
            HTPair rightPair = treeToLinkedList(root.right);
            root.right = rightPair.head;
            ret.head = root;
            ret.tail = rightPair.tail;
        } else {
            HTPair leftPair = treeToLinkedList(root.left);
            HTPair rightPair = treeToLinkedList(root.right);
            leftPair.tail.right = root;
            root.right = rightPair.head;

            ret.head = leftPair.head;
            ret.tail = rightPair.tail;
        }

        return ret;
    }

    static class HTPair {
        Node head;
        Node tail;

        HTPair(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
