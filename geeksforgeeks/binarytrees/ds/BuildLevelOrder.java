package geeksforgeeks.binarytrees.ds;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BuildLevelOrder {
    public static TreeNode buildLevelOrder(Integer[] arr) {
        Queue<TreeNode> q = new ArrayDeque<>();

        TreeNode root = new TreeNode(arr[0], null, null);
        q.add(root);

        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left, right;
            if (i < arr.length) {
                left = new TreeNode(arr[i++], null, null);
                right = new TreeNode(arr[i++], null, null);
                q.add(left);
                q.add(right);
            } else {
                left = null;
                right = null;
            }
            node.setLeft(left);
            node.setRight(right);
        }
        return root;
    }

    public static Node buildLevelOrder(String str){
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }
}
