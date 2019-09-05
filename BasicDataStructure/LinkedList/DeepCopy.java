package BasicDataStructure.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy {
    public ListNode copy(ListNode head) {
        // Write your solution here.
        if(head == null){
            return null;
        }

        //loop1: generate all nodes and map the new node with the original node
        Map<ListNode, ListNode> nodes = new HashMap<>();
        ListNode current = head;
        while(current != null){
            nodes.put(current, new ListNode(current.value));
            current = current.next;
        }

        //loop2: assign next and random pointers
        current = head;
        while(current != null){
            nodes.get(current).next = nodes.get(current.next);
            current = current.next;
        }
        return nodes.get(head);
    }
}
