package linkedlist;

public class RecursiveReversalLinkedList {
    public static void main(String[] args) {
        LinkedListNode head = null;
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 0);
        printAll(head);
        head = reverseLinkedList(head);
        printAll(head);
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

    private static LinkedListNode reverseLinkedList(LinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        LinkedListNode sHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return sHead;
    }

    static class LinkedListNode {
        public Integer data;
        public LinkedListNode next;

        public LinkedListNode(Integer data) {
            this.data = data;
        }
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

}
