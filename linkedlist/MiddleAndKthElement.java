package linkedlist;

public class MiddleAndKthElement {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(null);
        head = insertAtHead(head, 7);
        head = insertAtHead(head, 6);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        // printAll(head);
        // System.out.println(findMiddle(head));
        System.out.println(findKthElement(head.next, 3));
    }

    private static int findKthElement(LinkedListNode head, int k) {
        LinkedListNode kth = head;
        LinkedListNode fast = head;
        int cnt = 1;
        while (fast != null && cnt<=k) {
            fast = fast.next;
            cnt++;
        }
        while(fast!=null){
            fast = fast.next;
            kth = kth.next;
        }
        return kth.data;
    }

    private static int findMiddle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return slow.data;
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
