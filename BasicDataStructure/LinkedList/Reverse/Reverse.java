package BasicDataStructure.LinkedList.Reverse;

import BasicDataStructure.LinkedList.ListNode;

public class Reverse {

    //iterative
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //recursion

}
