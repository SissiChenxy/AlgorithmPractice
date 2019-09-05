package BasicDataStructure.Array.KSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumDistinctValues {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < array.length - 2; i++){
            if(i > 0 && array[i] == array[i-1]){
                continue;
            }
            int j = i + 1;
            int k = array.length - 1;
            while(j < k){
                if(j > i + 1 && array[j] == array[j-1]){
                    j++;
                    continue;
                }
                int cur = array[j] + array[k];
                if(cur == target - array[i]){
                    result.add(Arrays.asList(array[i], array[j], array[k]));
                    j++;
                    k--;
                }else if(cur < target - array[i]){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}
