package BasicDataStructure.Array;

import java.util.Arrays;

public class ArrayDuplication3 {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array.length <= 1){
            return array;
        }

        int slow = 1;
        int fast = 1;

        while(fast < array.length){
            if((slow == 0 && array[fast] != array[slow]) || array[fast] != array[slow-1]){
                array[slow] = array[fast];
                slow++;
                fast++;
            }else{
                while(fast < array.length && array[fast] == array[slow-1]){
                    fast++;
                }
                slow--;
                //fast == array.length
                if(slow < array.length && array[fast-1] != array[slow]){
                    array[slow] = array[fast-1];
                    slow++;
                }
            }
        }



        return Arrays.copyOf(array, slow);
    }
}
