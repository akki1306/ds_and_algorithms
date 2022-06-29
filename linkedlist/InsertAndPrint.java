package linkedlist;

public class InsertAndPrint {
    public static void main(String[] args) {
        LinkedListNode head = null;
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 0);
        insertInTheMiddle(head, 7, 3);
        printAll(head);
    }

    private static void insertInTheMiddle(LinkedListNode head, int data, int pos) {
        int count = 1;
        LinkedListNode n = head.next;
        while (n != null && count < pos-1) {
            n = n.next;
            count++;
        }
        if(n==null)
            return;

        LinkedListNode node = new LinkedListNode(data);
        node.next = n.next;
        n.next = node;
    }

    private static void printAll(LinkedListNode head) {
        while (head.next != null) {
            LinkedListNode lln = head.next;
            System.out.print(lln.data + "-->");
            head = head.next;
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

    private static class LinkedListNode {
        public Integer data;
        public LinkedListNode next;

        public LinkedListNode(Integer data) {
            this.data = data;
        }
    }
}
