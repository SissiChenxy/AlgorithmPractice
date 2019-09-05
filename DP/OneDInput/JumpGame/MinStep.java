package DP.OneDInput.JumpGame;

public class MinStep {
    /*
    Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
    A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
    Determine the minimum number of jumps you need to reach the end of array.
    If you can not reach the end of the array, return -1.
    {3, 3, 1, 0, 4} -- 2

    DP
    data structure:
        M[i] -- represents the minimum steps needed from index i to target position(end)
    algorithm:
        base case:
            M[array.length - 1] = 0
        induction rule:
            M[i] = -1
            if there is a j, i < j <= i + array[j], 最小的M[j] != -1
                M[i] = M[j] + 1
    Time = O(n^2)
    Space = O(n)
     */

    //原始版本 从后往前
    public int minJump(int[] array) {
        // Write your solution here
        if(array.length == 1){
            return 0;
        }

        int[] record = new int[array.length];
        record[array.length - 1] = 0;

        for(int i = array.length - 2; i >= 0; i--){
            //initialize as invalid (-1)
            record[i] = -1;
            for(int j = i + 1; j <= Math.min(array.length - 1, i + array[i]); j++){
                if(record[j] != -1){
                    if(record[i] == -1 || record[i] > record[j] + 1){
                        record[i] = record[j] + 1;
                    }
                }
            }
        }
        return record[0];
    }

    //从前往后
    public int minJump2(int[] array) {
        if(array.length == 1){
            return 0;
        }

        int[] record = new int[array.length];
        record[0] = 0;

        for(int i = 1; i < array.length; i++){
            record[i] = -1;

            for(int j = 0; j < i; j++){
                if(j + array[j] >= i && record[j] != -1){
                    if(record[i] == -1 || record[j] + 1 < record[i])
                        record[i] = record[j] + 1;
                }
            }
        }
        return record[array.length - 1];
    }

    public void test1(){
        int[] array = {3, 3, 1, 0, 4};
        System.out.println(minJump2(array));
    }
}
