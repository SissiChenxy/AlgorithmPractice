package BasicDataStructure.LinkedList.Sort;

import BasicDataStructure.LinkedList.ListNode;

public class QuickSort {
    public ListNode quickSort(ListNode head){
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end){
        if(head != end){
            ListNode node = partition(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    private ListNode partition(ListNode head, ListNode end){
        ListNode p1 = head;
        ListNode p2 = head.next;

        //choose head as pivot
        while(p2 != null){
            if(p2.value < head.value){
                p1 = p1.next;

                int temp = p1.value;
                p1.value = p2.value;
                p2.value = temp;
            }
            p2 = p2.next;
        }

        if (p1 != head){
            int temp = p1.value;
            p1.value = head.value;
            head.value = temp;
        }
        return p1;
    }
}
