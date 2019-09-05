package BasicDataStructure.LinkedList.Reverse;

import BasicDataStructure.LinkedList.ListNode;

public class ReverseAlternateNodes {

    public ListNode reverseAlternate(ListNode head) {
        // zhangzhiwei solution

        //0，1，2个元素不做处理
        ListNode odd = head;
        if (odd == null || odd.next == null || odd.next.next == null) {
            return head;
        }

        // even points to the beginning of even list
        ListNode even = odd.next;
        // Remove the first even node
        odd.next = odd.next.next;
        // odd points to next node in odd list
        odd = odd.next;
        // Set terminator for even list
        even.next = null;

        // Traverse the list
        while (odd != null && odd.next != null) {
            // Store the next node in odd list
            ListNode temp = odd.next.next;
            // Link the next even node at the beginning of even list
            odd.next.next = even;
            even = odd.next;
            // Remove the even node from middle
            odd.next = temp;
            // Move odd to the next odd node
            if (temp != null) {
                odd = temp;
            }
        }
        // Append the even list at the end of odd list
        odd.next = even;
        return head;
    }


    public ListNode reverseAlternateNodes(ListNode head) {
        // Write your solution here

        //deal 0，1，2 elements,no change
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        //maintain odd and even list separately, and then connect them together
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode oldEvenHead = even;

        while(odd.next != null){
            //connect odd and even nodes separately
            ListNode nextOdd = odd.next.next;
            odd.next = nextOdd;

            //保证了odd不可能为null
            if(nextOdd != null){
                //下一轮使用odd.next.next,一定要保证 nextOdd不为null
                odd = nextOdd;
            }

            if(even.next != null){
                //corner case只处理了0，1，2个元素，3个元素时还能保证even.next不为空，无法保证even.next.next不为空，使用之前一定要check
                ListNode nextEven = even.next.next;
                even.next = nextEven;
                even = nextEven;
            }
        }

        //reverse even loop
        ListNode newEvenHead = reverse(oldEvenHead);

        //append to the tail of odd list
        odd.next = newEvenHead;
        oldEvenHead.next = null;

        return head;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

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
