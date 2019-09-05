package BasicDataStructure.LinkedList.Remove;

import BasicDataStructure.LinkedList.ListNode;

public class RemoveDuplicateNodes {
    public ListNode removeDupE(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while(head != null && head.next != null){
            if(head.value == head.next.value){
                head = head.next;
            }else{
                prev.next = head;
                head = head.next;
                prev = prev.next;
            }
        }
        prev.next = head;
        return dummyHead.next;
    }

    public ListNode removeDup(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        int count = 0;

        while(head != null && head.next != null){
            if(head.value != head.next.value){
                if(count == 0){
                    head = head.next;
                    prev = prev.next;
                }else{
                    head = head.next;
                    prev.next = head;
                    count = 0;
                }
            }else{
                head = head.next;
                count++;
            }
        }
        //post processing,对于最后一个元素看要不要加
        if(count > 0){
            prev.next = null;
        }else{
            prev.next = head;
        }
        return dummyHead.next;
    }
}
