package hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Break the chain
 *
 * Given a linked list which contains a cycle, build hasing based algorithm to break the cycle and return the head
 *
 */
public class BreakTheChain {
    public static void main(String[] args) {
        Node head = createLinkedList(new int[]{1, 2, 3, 4, 5});
        Set<Node> s = new HashSet<>();
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            boolean isAdded = s.add(temp);
            if (!isAdded) {
                prev.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    private static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        Node node2 = null;
        Node node5 = null;
        for (int i = 1; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            if (arr[i] == 2)
                node2 = n;
            else if (arr[i] == 5)
                node5 = n;
            temp.next = n;
            temp = temp.next;
        }
        node5.next = node2;
        return head;
    }

    static class Node {
        public Integer data;
        public Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }
}
