package BasicDataStructure.Array.KSum;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public boolean existSum(int[] array, int target) {
        // Write your solution here
        if(array.length <= 1){
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();
        for(Integer i : array){
            if(set.contains(target - i)){
                return true;
            }else{
                set.add(i);
            }
        }
        return false;
    }
}
