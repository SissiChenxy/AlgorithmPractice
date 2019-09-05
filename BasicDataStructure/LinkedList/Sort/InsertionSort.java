package BasicDataStructure.LinkedList.Sort;

import BasicDataStructure.LinkedList.ListNode;

public class InsertionSort {
    public ListNode insertionSort(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode maxNode = head;
        ListNode current = head.next;

        while(current != null){
            if(current.value > maxNode.value){
                maxNode = current;
            }
            ListNode tail = dummyHead;

            //tail 指向已确定元素的最后端，要让tail移动到tail.next，必须保证tail.next < current
            while(tail.next != null && current.value > tail.next.value){
                tail = tail.next;
            }
            ListNode nextNode = current.next;
            ListNode next = tail.next;
            tail.next = current;
            current.next = next;
            maxNode.next = null;
            current = nextNode;
        }

        return dummyHead.next;
    }
}
