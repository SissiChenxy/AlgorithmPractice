package BasicDataStructure.LinkedList.Sort;

import BasicDataStructure.LinkedList.ListNode;

public class MergeSort {
    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode secondHead = mid.next;
        mid.next = null;

        ListNode first = mergeSort(head);
        ListNode second = mergeSort(secondHead);

        return merge(first, second);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(left != null && right != null){
            if(left.value <= right.value){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left != null){
            cur.next = left;
        }
        return dummyHead.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }
}
