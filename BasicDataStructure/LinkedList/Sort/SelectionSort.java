package BasicDataStructure.LinkedList.Sort;

import BasicDataStructure.LinkedList.ListNode;

public class SelectionSort {
    public ListNode selectionSort(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        ListNode currentHead = head;
        ListNode smallestPre = null;
        ListNode smallest = null;

        while(currentHead != null){

            //把要操作的node先赋值成current
            smallest = currentHead;
            smallestPre = findSmallPreNode(currentHead);

            //头元素是最小的，剩一个元素的时候为null
            if (smallestPre != null){
                smallest = smallestPre.next;
                //先把该节点从原链表中删除
                smallestPre.next = smallest.next;
            }

            //再把该最小值加到tail位置
            tail.next = smallest;

            //current的位置要永远指向 剩余list的第一位，这样才能找到之后的元素
            currentHead = currentHead == smallest ? currentHead.next : currentHead;
            tail = tail.next;
        }
        //current.next = null;
        return dummyHead.next;
    }

    private ListNode findSmallPreNode(ListNode head){
        ListNode smallest = head;
        ListNode smallestPre = null;
        ListNode pre = head;
        ListNode cur = head.next;

        while(cur != null){
            if(cur.value < smallest.value){
                smallest = cur;
                smallestPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallestPre;
    }
}
