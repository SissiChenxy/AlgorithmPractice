package BasicDataStructure.LinkedList;

public class AddTwoSum {
    public ListNode addTwoSum(ListNode head1, ListNode head2){

        if (head1 == null && head2 == null){
            return null;
        }

        //正序时要反过来
        ListNode newhead1 = reverse(head1);
        ListNode newhead2 = reverse(head2);

        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (newhead1 != null || newhead2 != null){

            //从贡献值的角度，不要按位算，如果这一位是null，其实就是贡献了0
            int x = newhead1 == null ? 0 : newhead1.value;
            int y = newhead2 == null ? 0 : newhead2.value;
            int sum = x + y + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;

            if (newhead1 != null){
                newhead1 = newhead1.next;
            }
            if (newhead2 != null){
                newhead2 = newhead2.next;
            }

            tail = tail.next;
        }

        if (carry > 0){
            tail.next = new ListNode(carry);
        }

        //正序时要反过来
        ListNode result = reverse(dummyHead.next);
        return result;
    }

    private ListNode reverse(ListNode head){
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
