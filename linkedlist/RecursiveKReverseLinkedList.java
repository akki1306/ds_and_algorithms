package linkedlist;

public class RecursiveKReverseLinkedList {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(null);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        printAll(head);
        head = recursiveKReverse(head.next, 3);
        printAll(head);
    }

    private static LinkedListNode recursiveKReverse(LinkedListNode curr, int k) {
        if (curr == null)
            return null;

        int count = k;

        LinkedListNode i = curr;
        LinkedListNode j = null;
        LinkedListNode temp;
        while (i != null && count > 0) {
            temp = i.next;
            i.next = j;
            j = i;
            i = temp;
            count--;
        }

        curr.next = recursiveKReverse(i, k);
        return j;
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
