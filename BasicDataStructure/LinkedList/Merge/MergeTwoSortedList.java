package BasicDataStructure.LinkedList.Merge;

import BasicDataStructure.LinkedList.ListNode;

public class MergeTwoSortedList {
    public ListNode merge(ListNode left, ListNode right){
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
}
