package udemy.linkedlist;

public class MergeSort {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(null);
        head = insertAtHead(head, 10);
        head = insertAtHead(head, 7);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 17);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 14);
//        printAll(head);
        head = mergeSort(head.next);
        printAll(head);
    }

    private static LinkedListNode midPoint(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static LinkedListNode mergeSort(LinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        LinkedListNode start = head;
        LinkedListNode mid = midPoint(head);

        LinkedListNode midPlusOne = mid.next;

        mid.next = null;
        LinkedListNode left = mergeSort(start);
        LinkedListNode right = mergeSort(midPlusOne);
        return merge(left, right);
    }

    private static LinkedListNode merge(LinkedListNode left, LinkedListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        LinkedListNode result = null;

        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private static void printAll(LinkedListNode head) {
        while (head != null) {
            LinkedListNode lln = head;
            if (lln.data != null)
                System.out.print(lln.data + "-->");
            head = head.next;
        }
        System.out.println();
    }

    private static LinkedListNode insertAtHead(LinkedListNode head, Integer data) {
        LinkedListNode node = new LinkedListNode(data);
        if (head == null) {
            head = new LinkedListNode(null);
        }
        node.next = head.next;
        head.next = node;
        return head;
    }

    static class LinkedListNode {
        public Integer data;
        public LinkedListNode next;

        public LinkedListNode(Integer data) {
            this.data = data;
        }
    }
}
