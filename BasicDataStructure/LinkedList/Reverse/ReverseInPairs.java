package BasicDataStructure.LinkedList.Reverse;

import BasicDataStructure.LinkedList.ListNode;

public class ReverseInPairs {
    public ListNode reverseInPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        //先保留下来下一层recursion的节点
        ListNode next = head.next;
        //调用下一层recursion
        ListNode newHead = reverseInPairs(next.next);
        //当前层做的事
        next.next = head;
        head.next = newHead;
        //返回当前层reverse后的新节点
        return next;
    }
}
