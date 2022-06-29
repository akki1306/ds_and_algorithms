package linkedlist;

/**
 * Given two sorted linked list, merge them into a new linked list
 * <p>
 * Input:
 * <p>
 * 1 -> 5 -> 7 -> 10
 * 2 -> 3 -> 6
 * <p>
 * Output:
 * <p>
 * 1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 10
 */
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        LinkedListNode h1 = new LinkedListNode(null);
        h1 = insertAtHead(h1, 10);
        h1 = insertAtHead(h1, 7);
        h1 = insertAtHead(h1, 5);
        h1 = insertAtHead(h1, 1);

        LinkedListNode h2 = new LinkedListNode(null);
        h2 = insertAtHead(h2, 6);
        h2 = insertAtHead(h2, 3);
        h2 = insertAtHead(h2, 2);

        System.out.print("H1: ");
        printAll(h1);
        System.out.print("H2: ");
        printAll(h2);
        LinkedListNode h = mergeSortedLinkedList(h1.next, h2.next);
        printAll(h);
    }

    private static LinkedListNode mergeSortedLinkedList(LinkedListNode h1, LinkedListNode h2) {
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;

        LinkedListNode node = h1.data < h2.data ? h1 : h2;
        if(h1.data < h2.data)
            node.next = mergeSortedLinkedList(h1.next, h2);
        else
            node.next = mergeSortedLinkedList(h1, h2.next);
        return node;
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
