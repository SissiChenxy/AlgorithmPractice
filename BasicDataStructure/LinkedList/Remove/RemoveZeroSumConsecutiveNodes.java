package BasicDataStructure.LinkedList.Remove;

import BasicDataStructure.LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodes {
    /*
    https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    Repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
    Return the head of the final linked list.
    [1,2,-3,3,1] [3,1]

    data structure:
        dummyhead
        prefixsum -- the prefix sum from the first node to the current cur node.
        map<prefixsum, Node> -- key==current sum including current node, node==reference
            map.put(0, dummyhead);
    algorithm:
        we scan the linked list, accumulate the node's value as prefix sum
            if the prefixsum isn't in the map, map.put()
            if the prefixsum is in the map, map.get(prefixsum) is the node we achieve this prefixsum,
            meaning that the sum of all nodes between map.get(prefixsum) and cur(inclusive) is 0, so
            map.get(prefixsum).next = cur.next;
    Time = O(n)
    Space = O(n)
     */

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyhead);
        int prefixsum = 0;
        while(head != null){
            prefixsum += head.value;
            if(map.containsKey(prefixsum)){
                map.get(prefixsum).next = head.next;
            }else{
                map.put(prefixsum, head);
            }
            head = head.next;
        }
        return dummyhead.next;
    }

    public void test1(){
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(-3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(1);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        removeZeroSumSublists(head);
    }
}
