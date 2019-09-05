package BasicDataStructure.Array.KSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumExisted {

    //O(n^2) 2 loops
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        //map: key - two sum, value - j1
        Map<Integer, Integer> map = new HashMap<>();
        //1st loop: generate map
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                Integer index = map.get(array[i] + array[j]);
                if(index == null || (index != null && j < index)){
                    map.put(array[i] + array[j], j);
                }
            }
        }

        //2nd loop: find pairs
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length;j++){
                Integer j1 = map.get(target - array[i] - array[j]);
                if(j1 != null && j1 < i){
                    return true;
                }
            }
        }
        return false;
    }

    //一边查一边放，用一个static class 存pair
    public boolean exist2(int[] array, int target){
        //key: two sum, pair: Pair
        Map<Integer, Pair> map = new HashMap<>();

        //another pair is (j, i)
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                int pairSum = array[j] + array[i];
                if(map.containsKey(target - pairSum) && map.get(target - pairSum).right < j){
                    return true;
                }
                if(!map.containsKey(pairSum)){
                    map.put(pairSum, new Pair(j, i));
                }
            }
        }
        return false;
    }

    static class Pair{
        int left;
        int right;
        public Pair(int l, int r){
            left = l;
            right = r;
        }
    }

    //一边查一边放/更新，map只存较小的j，保证right一定是递增的 ----- 不用更新
    public boolean exist3(int[] array, int target) {
        // Write your solution here
        Map<Integer, Integer> map = new HashMap<>();

        for(int right = 1; right < array.length; right++){
            for(int left = 0; left < right; left++){
                int pairSum = array[left] + array[right];
                if(map.containsKey(target - pairSum) && map.get(target - pairSum) < left){
                    return true;
                }
                if(!map.containsKey(pairSum)){
                    map.put(pairSum, right);
                }
            }
        }
        return false;
    }
}
