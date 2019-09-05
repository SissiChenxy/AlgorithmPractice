package BasicDataStructure.LinkedList.Reverse;

import BasicDataStructure.LinkedList.ListNode;

public class ReverseInKPairs {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your solution here
        if (k == 1 || head == null || head.next == null) {
            return head;
        }

        int length = count(head);
        return reverseKGroup(head, k, length);
    }

    private ListNode reverseKGroup(ListNode head, int k, int length) {
        if (length / k == 0) {
            return head;
        }

        //先保留下来下一层recursion的节点
        ListNode next = findNext(head, k);
        //调用下一层recursion
        ListNode nextHead = reverseKGroup(next, k, length - k);
        //当前层做的事
        ListNode newHead = reverse(head, k);
        head.next = nextHead;
        //返回当前层reverse后的新节点
        return newHead;
    }

    private ListNode findNext(ListNode head, int k) {
        ListNode next = head;
        for (int i = 1; i <= k; i++) {
            next = next.next;
        }
        return next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        for (int i = 1; i <= k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }


    //zhangzhiwei version
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        int count = 0;

        //先走k步，看剩余node是否有k个
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        //如果有k个就执行
        if (count == k) {
            //调用下一层，返回值是newHead
            curr = reverseKGroup2(curr, k);
            //当前层做reverse

            while (count-- > 0) {
                ListNode tem = head.next;
                head.next = curr;
                curr = head;
                head = tem;
            }
            head = curr;
        }
        return head;
    }
}
