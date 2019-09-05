package NestedDataStrucuture;

import java.util.*;

public class MaxOfSlidingWindow {
    /*
    data structure:
        maxheap -- all the elements in the sliding window
        two pointers: left, right
    algorithm:
        1. initialize:
            left = 0, right = k - 1
            maxheap.offer() [0, k-1]
        2. for each step:
            check whether the index of top element in the maxheap valid or not
                if not valid, poll();
                if valid, result.add(maxheap.peek());
            left++, right++;
            if right is still in bound, maxheap.offer(array[right], right);
        3. termination condition:
            right > array.length

        time = O(nlogn)
        space = O(n)
     */
    public List<Integer> maxWindows(int[] array, int k) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[0] == a2[0]){
                    return 0;
                }
                return a1[0] > a2[0] ? -1 : 1;
            }
        });

        for(int i = 0; i < k; i++){
            maxHeap.offer(new int[]{array[i], i});
        }

        int left = 0;
        int right = k - 1;
        while(right < array.length){
            while(maxHeap.peek()[1] < left){
                maxHeap.poll();
            }
            result.add(maxHeap.peek()[0]);
            left++;
            right++;
            if(right < array.length){
                maxHeap.offer(new int[]{array[right], right});
            }
        }
        return result;
    }


    /*
    优化：
        data structure: queue 两端操作
        algorithm： linear scan 回头看
            when the sliding window moves to the right side by 1 step
                1 new element (x) enters sliding window"
                    while deque.tail.value <= x:
                        remove tail from deque
                    deque.offerLast((x, index(x)))
                the leftmost element(y) in the sliding window wxists
                    if(deque.head.index == index(y)):
                        deque.pollFirst()
                update global max with deque.head.value
        time: O(n)

     */

    public List<Integer> max(int[] array, int k){
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < array.length; i++){
            while(!deque.isEmpty() && array[deque.peek()] <= array[i]){
                deque.pollLast();
            }
            if(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            deque.offerLast(i);
            if(i >= k -1){
                result.add(array[deque.peekFirst()]);
            }
        }
        return result;
    }

    public void test1(){
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,1,1};
        System.out.println(maxWindows(a, 2));
    }
}
