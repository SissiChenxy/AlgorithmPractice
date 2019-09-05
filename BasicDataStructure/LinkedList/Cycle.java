package BasicDataStructure.LinkedList;

public class Cycle {
    public ListNode cycleNode(ListNode head) {
        // write your solution here
        if(head == null || head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                isCycle = true;
                //fast = head;
                break;
            }
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
