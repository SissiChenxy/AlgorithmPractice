package BasicDataStructure.HashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKWords {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if(combo.length == 0){
            return new String[0];
        }
        if(k >= combo.length){
            return combo;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s : combo){
            Integer value = map.get(s);
            if(value != null){
                map.put(s, value + 1);
            }else{
                map.put(s, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }else{
                if(minHeap.peek().getValue() < entry.getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        String[] result = new String[minHeap.size()];
        for(int i = minHeap.size() - 1; i >= 0 ; i--){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
