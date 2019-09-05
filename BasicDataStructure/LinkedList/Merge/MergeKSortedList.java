package BasicDataStructure.LinkedList.Merge;

import BasicDataStructure.LinkedList.ListNode;

import java.util.*;

public class MergeKSortedList {

    //iterative method
    public ListNode merge(List<ListNode> listOfLists) {
        if(listOfLists.size() == 0){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        List<ListNode> headList = new ArrayList<>();
        for(int i = 0; i < listOfLists.size(); i++){
            headList.add(listOfLists.get(i));
        }

        Set<Integer> duplicate = new HashSet<>();
        while(duplicate.size() < listOfLists.size()) {
            int globalSmall = Integer.MAX_VALUE;
            int index = 0;
            ListNode next = null;
            for (int i = 0; i < listOfLists.size(); i++) {
                ListNode currentHead = headList.get(i);
                if (currentHead == null) {
                    duplicate.add(i);
                    continue;
                } else if (currentHead.value < globalSmall) {
                    globalSmall = currentHead.value;
                    next = currentHead;
                    index = i;
                }
            }

            tail.next = next;
            if(next != null){
                headList.set(index, next.next);
            }
            tail = tail.next;
        }

        return dummyHead.next;
    }

    //binary reduction
    public ListNode merge2(List<ListNode> listOfLists) {
        // Write your solution here/.
        if(listOfLists.size() == 0){
            return null;
        }
        return partition(listOfLists, 0, listOfLists.size() - 1);
    }

    private ListNode partition(List<ListNode> listOfLists, int left, int right){
        if(left == right) return listOfLists.get(left);
        if(left < right){
            int mid = left + (right - left) / 2;
            ListNode n1 = partition(listOfLists, left, mid);
            ListNode n2 = partition(listOfLists, mid + 1, right);
            return merge(n1,n2);
        }
        return null;
    }

    private ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        if(n1.value < n2.value){
            n1.next = merge(n1.next, n2);
            return n1;
        }else{
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }


    //k-way together
    public ListNode merge3(List<ListNode> listOfLists) {
        // Write your solution here/.
        if(listOfLists.size() == 0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(listOfLists.size(), new MyComparator());
        for(int i = 0; i < listOfLists.size(); i++){
            if(listOfLists.get(i) != null){
                minHeap.offer(listOfLists.get(i));
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            tail.next = node;
            if(node.next != null){
                node = node.next;
                minHeap.offer(node);
            }
            tail = tail.next;
        }
        return dummyHead.next;
    }

    static class MyComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode n1, ListNode n2){
            if(n1.value == n2.value){
                return 0;
            }
            return n1.value < n2.value ? -1 : 1;
        }
    }
}
