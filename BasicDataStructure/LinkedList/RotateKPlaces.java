package BasicDataStructure.LinkedList;

public class RotateKPlaces {
    public ListNode rotateKplace(ListNode head, int n) {
        // Write your solution here
        if(head == null || head.next == null || n == 0){
            return head;
        }

        ListNode newHead = reverse(head);
        ListNode tail = findTail(newHead);

        while(n > 0){
            ListNode nextHead = newHead.next;
            tail.next = newHead;
            newHead.next = null;
            newHead = nextHead;
            tail = tail.next;
            n--;
        }
        ListNode result = reverse(newHead);
        return result;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode findTail(ListNode head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }
}
