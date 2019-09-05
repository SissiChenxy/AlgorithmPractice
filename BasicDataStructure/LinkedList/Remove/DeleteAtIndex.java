package BasicDataStructure.LinkedList.Remove;

import BasicDataStructure.LinkedList.ListNode;

public class DeleteAtIndex {
    public ListNode deleteNode(ListNode head, int index) {
        // Write your solution here

        if(head == null || (head.next == null && index == 0)){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;

        int count = 0;
        while(head != null && head.next != null){
            if(count == index){
                ListNode next = head.next.next;
                head.next.next = null;
                head.next = next;
            }
            head = head.next;
            count++;
        }

        return dummyHead.next;
    }
}
