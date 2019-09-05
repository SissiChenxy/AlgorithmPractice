package BasicDataStructure.LinkedList.Remove;

import BasicDataStructure.LinkedList.ListNode;

public class DeleteAtIndices {
    public ListNode deleteNodes(ListNode head, int[] indices) {
        // Write your solution here
        if(head == null){
            return null;
        }
        if(indices == null || indices.length == 0){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //head指向已确定的元素
        head = dummyHead;

        int count = 0;
        int k = 0;
        for (int i = 0; i < indices.length; i++) {
            while (head != null && head.next != null) {
                if (count == indices[i] - k) {
                    ListNode next = head.next;
                    head.next = next.next;
                    next.next = null;
                    k++;
                    break;
                }
                head = head.next;
                count++;
            }
        }

        return dummyHead.next;
    }
}
