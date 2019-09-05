package DP.OneDInput.SubArraySequence;

import java.util.ArrayList;
import java.util.List;

public class LargestSubArraySum {
    /*
    Given an unsorted integer array, find the subarray that has the greatest sum.
    Return the sum.
    {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

    DP - 1D input, linear scan and look back
    data structure:
        M[i] -- represents the sum from 0-th element to i-th element(inclusive), i is index
        globalMax
    algorithm:
        base case:
            M[0] = input[0]
        induction rule:
            when a new element comes:
                general rule : M[i] = M[i-1] + input[i]
                check if M[i-1] < 0, M[i] = input[i]
                      else, M[i] = M[i-1] + input[i]
            globalMax = max(globalMax, M[i])
     Time = O(n)
     Space = O(n)
     */
    public int largestSubArraySum(int[] array){
        int[] record = new int[array.length];
        int globalMax = Integer.MIN_VALUE;
        record[0] = array[0];
        for(int i = 1; i < array.length; i++){
            if(record[i - 1] < 0){
                record[i] = array[i];
            }else{
                record[i] = record[i-1] + array[i];
            }
            globalMax = Math.max(globalMax, record[i]);
        }
        return globalMax;
    }

    /*
    Return the left and right bounds of the largest subarray sum.
    data structure:
        M[i] -- represents the sum from 0-th element to i-th element(inclusive), i is index
        globalMax
        globalLeft, globalRight, currentLeft
    algorithm:
        base case:
            M[0] = input[0]
        induction rule:
            when a new element comes:
                general rule : M[i] = M[i-1] + input[i]
                check if M[i-1] < 0, M[i] = input[i], currentLeft = i
                      else, M[i] = M[i-1] + input[i]
            globalMax = max(globalMax, M[i])
                when globalMax is updated, globalLeft = currentLeft, globalRight = i

     Time = O(n)
     Space = O(n)
     */

    public List<Integer> bounds(int[] array){
        int[] record = new int[array.length];
        int globalMax = Integer.MIN_VALUE;
        int globalLeft = 0;
        int globalRight = 0;
        int currentLeft = 0;
        record[0] = array[0];
        for(int i = 1; i < array.length; i++){
            if(record[i - 1] < 0){
                record[i] = array[i];
                currentLeft = i;
            }else{
                record[i] = record[i-1] + array[i];
            }
            if(record[i] > globalMax){
                globalMax = record[i];
                globalLeft = currentLeft;
                globalRight = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(globalLeft);
        result.add(globalRight);
        return result;
    }

    public void test(){
        int[] array = new int[]{1,2,4,-1,-2,10,-1,-100,-1,10};
        System.out.println(largestSubArraySum(array));
        System.out.println(bounds(array));
    }
}
