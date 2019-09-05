package BasicDataStructure.Queue.PriorityQueue;

import java.util.*;

public class TopKFrequent {
    /*
    Given a non-empty array of integers, return the k most frequent elements.
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    ** result is descending order of frequence
    nums = [1,1,1,2,2,3], k = 2  [1,2]

    data structure:
        minheap -- size == k, keep the top k element at any times
        map -- <key = element's val, value = element's frequence>, store the frequence of each element
    algorithm:
        first loop:
            count the frequence of each element and store it in map
            when a new element comes,
                if it doesn't exist in map, map.put(ele, 1)
                else, map.put(ele, map.get(ele) + 1)
        second loop:
            iterate map's entry set, update the minheap, select top k frequent elements

     Time = O(nlogk)
     Space = O(k)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        //maintain hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
//            Integer freq = map.get(i);
//            if(freq == null){
//                map.put(i, 1);
//            }else{
//                map.put(i, freq + 1);
//            }
        }

        //maintain minheap
//        PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>(){
//            public int compare(Map.Entry<Integer, Integer> e1,Map.Entry<Integer, Integer> e2){
//                if(e1.getValue().equals(e2.getValue())){
//                    return 0;
//                }
//                return e1.getValue() < e2.getValue()? -1 : 1;
//            }
//        });

        PriorityQueue<Integer> minheap = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer e1, Integer e2){
                if(map.get(e1) == map.get(e2)){
                    return 0;
                }
                return map.get(e1) < map.get(e2)? -1 : 1;
            }
        });

        for(int e : map.keySet()){
            minheap.offer(e);
            if(minheap.size() > k){
                minheap.poll();
            }
        }

        while(!minheap.isEmpty()){
            result.add(minheap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public void test(){
        int[] array = {1,1,1,2,2,3};
        System.out.println(topKFrequent(array, 2));
    }
}
