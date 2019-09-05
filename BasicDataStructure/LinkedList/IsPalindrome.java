package BasicDataStructure.LinkedList;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMid(head);
        ListNode secondHead = reverse(mid.next);
        mid.next = null;

        while (head != null && secondHead != null) {
            if (head.value == secondHead.value) {
                head = head.next;
                secondHead = secondHead.next;
            } else {
                return false;
            }
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
