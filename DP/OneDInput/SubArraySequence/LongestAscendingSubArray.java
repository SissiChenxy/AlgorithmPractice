package DP.OneDInput.SubArraySequence;

public class LongestAscendingSubArray {
    /*
    DP: input is 1D array, similar smallest element -- linear scan and look back
    data structure:
        M[i] --- represents the max length of the ascending subarray from the beginning to the i-th element
        globalMax --- the max in M[i]
    Algorithm:
        base case: M[0] = 1
        induction rule:
            when a new element array[i] comes:
                if array[i] is larger than array[i-1], M[i] = M[i-1] + 1
                    globalMax = max(globalMax, M[i]);
                if array[i] is smaller than array[i-1], M[i] = 1
    Time = O(n)
    Space = O(n) ---- can be optimized to O(1)
     */
    public int longestAscendingSubArray(int[] array){
        if(array == null){
            return -1;
        }
        if(array.length == 0){
            return 0;
        }
        //globalMax must be initialized as 1, covering the case which array.length == 1
        //since the latter for loop begins from index == 1
        int globalMax = 1;
        int[] record = new int[array.length];
        record[0] = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] > array[i-1]){
                record[i] = record[i-1] + 1;
                globalMax = Math.max(globalMax, record[i]);
            }else {
                record[i] = 1;
            }
        }
        return globalMax;
    }

    //optimized space: globalMax, prev
    public int longestAscendingSubArray2(int[] array){
        if(array == null){
            return -1;
        }
        if(array.length == 0){
            return 0;
        }
        int globalMax = 1;
        int prev = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] > array[i-1]){
                prev++;
                globalMax = Math.max(globalMax, prev);
            }else {
                prev = 1;
            }
        }
        return globalMax;
    }

    /*
    Sliding Window: the difference(right - left + 1) between left and right bounds is the length
    data structure:
        globalMax
        left
    algorithm:
        right bound -- i
        iterate the input array
            if array[i] > array[i-1]
                globalMax = Math.max(globalMax, i - left + 1);
            else
                left = i
     Time = O(n)
     Space = O(1)
     */
    public int longestAscendingSubArray3(int[] array){
        if(array == null){
            return -1;
        }

        if(array.length == 0){
            return 0;
        }

        int globalMax = 1;
        for(int i = 0, left = 0; i < array.length; i++){
            if(i == 0 || array[i] > array[i-1]){
                globalMax = Math.max(globalMax, i - left + 1);
            }else{
                left = i;
            }
        }
        return globalMax;
    }


    public void test1(){
        int[] array = new int[]{7, 2, 3, 1, 5, 8, 9, 6};
        System.out.println(longestAscendingSubArray2(array));
    }
}
