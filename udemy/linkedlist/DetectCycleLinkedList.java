package udemy.linkedlist;

public class DetectCycleLinkedList {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(null);
        head = insertAtHead(head, 7);
        head = insertAtHead(head, 6);
        head = insertAtHead(head, 5);
        LinkedListNode cycle = head;
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        head.next = cycle;
        System.out.println(detectCycle(head));
    }

    private static boolean detectCycle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head.next;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow==fast;
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
