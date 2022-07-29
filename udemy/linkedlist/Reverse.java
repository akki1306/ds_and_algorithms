package udemy.linkedlist;

/**
 * LinkedList reverse
 *
 * Given a linked list, write a function to reverse the linked list
 *
 * Input:
 *
 * 1 => 2 => 3 => 4 => 5
 *
 * Output:
 *
 * 5 => 4 => 3 => 2 => 1
 */
public class Reverse {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(null);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        printAll(head);
       // head = iterativeReversalLinkedList(head);
        head = recursiveReverseLinkedList(head);
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

    private static LinkedListNode recursiveReverseLinkedList(LinkedListNode head) {
        // if you are passed linked list with a null head or you are at the second last element in the linked list.
        if (head == null || head.next == null)
            return head;

        LinkedListNode sHead = recursiveReverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return sHead;
    }

    private static LinkedListNode iterativeReversalLinkedList(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode curr = head.next;
        LinkedListNode temp;
        while (curr!=null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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
