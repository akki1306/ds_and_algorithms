package linkedlist;

public class KReverse {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(null);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        printAll(head);
        head = iterativeKReverseLinkedList(head, 3);
        head = recursiveKReverse(head.next, 3);
        printAll(head);
    }

    private static LinkedListNode iterativeKReverseLinkedList(LinkedListNode head, int k) {
        LinkedListNode prev = null;
        LinkedListNode curr = head.next;
        LinkedListNode temp;
        LinkedListNode tail = null;
        LinkedListNode join;
        LinkedListNode newhead = null;
        while (curr != null) {
            int count = k;
            join = curr;
            while (count > 0 && curr != null) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                count--;
            }
            if (newhead == null)
                newhead = prev;

            if (tail != null)
                tail.next = prev;

            tail = join;
            prev = null;
        }
        return newhead;
    }

    private static LinkedListNode recursiveKReverse(LinkedListNode head, int k) {
        if (head == null)
            return null;

        int count = k;
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        LinkedListNode temp;
        while (curr != null && count > 0) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;
        }

        curr.next = recursiveKReverse(curr, k); // recursive link tail of first k batch of nodes to head of next batch.
        return prev;   // return the head in first recursive call
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
