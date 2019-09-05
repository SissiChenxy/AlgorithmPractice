package BasicDataStructure.Array;

import java.util.HashMap;
import java.util.Map;

public class GetCountArray {
    public int[] countArray(int[] array) {
        // Write your solution here
        int[] result = new int[array.length];
        if(array.length <= 1){
            return result;
        }

        //record the change of the element's index
        int[] indexArr = new int[array.length];
        int[] helper = new int[array.length];
        for(int i = 0; i < result.length; i++){
            indexArr[i] = i;
        }
        partition(array, result, indexArr, helper, 0, array.length - 1);
        return result;
    }

    private void partition(int[] array, int[] result, int[] indexArr, int[] helper, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        partition(array, result, indexArr, helper, left, mid);
        partition(array, result, indexArr, helper, mid + 1, right);
        merge(array, result, indexArr, helper, left, mid, right);
    }

    private void merge(int[] array, int[] result, int[] indexArr, int[] helper, int left, int mid, int right){
        for(int i = left; i <= right; i++){
            helper[i] = indexArr[i];
        }
        int l = left, r = mid + 1, tail = left;
        while(l <= mid){
            if(r > right || array[helper[l]] <= array[helper[r]]){
                result[helper[l]] += r - mid - 1;
                indexArr[tail++] = helper[l++];
            }else{
                indexArr[tail++] = helper[r++];
            }
        }
    }


//static class record index, value, counter relationship
    public int[] countArray2(int[] array) {
        // Write your solution here
        int[] result = new int[array.length];
        if(array.length <= 1){
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] eleArr = new int[array.length];
        int[] helper = new int[array.length];
        for(int i = 0; i < array.length; i++){
            eleArr[i] = array[i];
            map.put(array[i], 0);
        }
        partition(eleArr, result, helper, map, 0, array.length - 1);
        for(int i = 0; i < result.length; i++){
            result[i] = map.get(array[i]);
        }
        return result;
    }

    private void partition(int[] array, int[] result, int[] helper, Map<Integer, Integer> map, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        partition(array, result, helper, map, left, mid);
        partition(array, result, helper, map, mid + 1, right);
        merge(array, helper, map, left, mid, right);
    }

    private void merge(int[] array, int[] helper, Map<Integer, Integer> map, int left, int mid, int right){
        for(int i = left; i <= right; i++){
            helper[i] = array[i];
        }
        int l = left;
        int r = mid + 1;
        int tail = l;
        while(l <= mid){
            if(r > right || helper[l] <= helper[r]){
                array[tail] = helper[l];
                int counter = r - mid - 1;
                map.put(array[tail], map.get(array[tail]) + counter);
                l++;
            }else{
                array[tail] = helper[r];
                map.put(array[tail], map.get(array[tail]));
                r++;
            }

            tail++;
        }
    }


}
