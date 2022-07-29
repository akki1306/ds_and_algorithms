package udemy.binarytrees;

import udemy.binarytrees.ds.Node;

public class BuildPreorder {
    public static void main(String[] args) {

    }

    private static Node buildPreorder(int[] arr, int i) {
        Node root = new Node(arr[i], null, null);
        root.left = buildPreorder(arr, i + 1);
        root.right = buildPreorder(arr, i + 5);
        return root;
    }
}
