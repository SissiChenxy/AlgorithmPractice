package DFS.Permutations;

import java.util.HashSet;
import java.util.Set;

public class KeepDistanceForIdenticalElements {

    //permutation方法：
    public int[] keepDistance1(int k) {
        // Write your solution here.
        int[] array = new int[2 * k];
        for(int i = 0; i < k; i++){
            array[i * 2] = i + 1;
            array[i * 2 + 1] = i + 1;
        }
        //boolean[] used = new boolean[k + 1];
        Set<Integer> set = new HashSet<>();
        return helper(array, set, 0) ? array : null;
    }

    private boolean helper(int[] array, Set<Integer> set, int index){
        if(index == array.length){
            return true;
        }

        for(int i = index; i < array.length; i++){
            int k = array[i];
            //!used[k]
            if(!set.contains(k) || index > k && array[index - k - 1] == k){
                swap(array, index, i);
                //used[k] = !used[k];
                set.add(k);
                if(helper(array, set, index + 1)){
                    return true;
                }
                swap(array, index, i);
                //used[k] = !used[k];
                set.remove(k);
            }
        }
        return false;
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //一个一个放
    public int[] keepDistance2(int k) {
        int[] array = new int[2 * k];
        return helper2(array, k) ? array : null;
    }

    private boolean helper2(int[] array, int k){
        //base case
        if(k == 0){
            return true;
        }
        for(int i = 0; i < array.length - k - 1; i++){
            if(array[i] == 0 && array[i + k + 1] == 0){
                array[i] = k;
                array[i + k + 1] = k;
                if(helper2(array, k - 1)){
                    return true;
                }
                array[i] = 0;
                array[i + k + 1] = 0;
            }

        }
        return false;
    }
}
