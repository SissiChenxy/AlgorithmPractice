package DP.OneDInput.JumpGame;

public class CanGetToEnd {
    /*
    Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
    A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
    Determine if you are able to reach the last index.
    {1, 3, 2, 0, 3} true
    {2, 1, 1, 0, 2} false

    DP -- linear scan and look back all before
    data structure:
        M[i] -- represents whether i can jump to the target from index i
            if there is j, i < j <= i + array[i], M[j] = true ---> M[i] = true
    algorithm:
        base case:
            M[input.length - 1] = true
        induction rule:
            M[i] =
                M[j] == true && i-j <= input[j]
    Time = O(n^2)
    Space = O(n)
    */

    //从第一格开始向后跳
    public boolean canJump(int[] array) {
        boolean[] record = new boolean[array.length];
        record[0] = true;
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(record[j] && array[j] >= i - j){
                    record[i] = true;
                    break;
                }
            }
        }
        return record[array.length - 1];
    }

    //从最后一格往前跳
    public boolean canJump2(int[] array) {
        boolean[] record = new boolean[array.length];
        record[array.length - 1] = true;
        for(int i = array.length - 2; i >= 0; i--){
            //一次跳到位
            if(i + array[i] >= array.length - 1){
                record[i] = true;
            }else{
                //能跳到的所有位置
                for(int j = array[i]; j >= 1; j--){
                    if(record[j + i]){
                        record[i] = true;
                        break;
                    }
                }
            }

        }
        return record[0];
    }

    public void test1(){
        int[] array = new int[]{2,3,1,1 ,4};
        System.out.println(canJump2(array));
    }
}
