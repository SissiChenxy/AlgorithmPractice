package BasicDataStructure.Array.KSum;

import java.util.*;

public class TwoSumAllPairIndicies {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            List<Integer> indicies = map.get(target - array[i]);
            if(indicies != null){
                for(int j : indicies){
                    result.add(Arrays.asList(j, i));
                }
            }
            if(!map.containsKey(array[i])){
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }
}
