package BasicDataStructure.LinkedList.Remove;

import BasicDataStructure.LinkedList.ListNode;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Write your solution here
        if(head == null){
            return null;
        }

        head = reverse(head);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        int count = 1;
        while(head != null){
            if(count == n){
                ListNode next = head.next;
                prev.next = next;
            }
            head = head.next;
            prev = prev.next;
            count++;
        }

        return reverse(dummyHead.next);
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
}
